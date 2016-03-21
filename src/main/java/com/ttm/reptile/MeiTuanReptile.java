package com.ttm.reptile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class MeiTuanReptile implements PageProcessor {

	private Site site = Site.me().setRetrySleepTime(3).setSleepTime(5000);

	// http://waimai.meituan.com/restaurant/506239?pos=3
	private static final String GET = "http://waimai\\.meituan\\.com/restaurant/\\d+";

	// http://waimai.meituan.com/home/wk3n3pv1wft9
	private static final String GET_LIST = "http://waimai\\.meituan\\.com/home/\\w+";

	private static final String GET_HOME = "http://waimai\\.meituan\\.com";

	/**
	 * 获取月销量 Map
	 */
	private Map<String, Object> tempMap;
	
	/**
	 * 获取真实的url
	 */
	private String real;

	public void process(Page page) {
		if (page.getUrl().regex(GET_LIST).match()) {
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^这是列表页!");
			List<String> newList = new ArrayList<>();
			for (String key : page.getHtml().xpath("//div[@class=\"rest-list\"]").links().all()) {
				if (StringUtils.isNotEmpty(key)) {
					newList.add(key);
					System.out.println("fetch url:" + key);
				}
			}
			parseHtmlList(page.getHtml().getDocument());
			page.addTargetRequests(newList);
		} else if (page.getUrl().regex(GET).match()) {
			parseHtml(page.getHtml().getDocument(), page.getUrl().toString());
		} else {
			System.out.println("这是主页!");
			List<String> urlList = new ArrayList<>();
			urlList.add(real);
			page.addTargetRequests(urlList);
		}

	}
	
	public Map<String, Object> parseHtmlList(Document document) {
		tempMap = new HashMap<String, Object>();
		int salesQuantityNumber = document.getElementsByClass("restaurant").size();
		for (int x = 0; x < salesQuantityNumber; x++) {
			Element sortA = document.getElementsByClass("restaurant").get(x);
			String sortId1 = null;
			for (String key : sortA.dataset().keySet()) {
				if (key.equals("poiid")) {
					sortId1 = sortA.dataset().get(key);
				}
			}
//			System.out.println(sortA.dataset().get("title"));
			
			Integer salesQuantity = 0;
			if (!(sortA.getElementsByAttributeValue("class", "total cc-lightred-new fr").isEmpty())) {
				Element salesQuantityB = sortA.getElementsByAttributeValue("class", "total cc-lightred-new fr").get(0);
				String startStr = "月售";
				String endStr = "单";
				String texText = salesQuantityB.text();
				
				if (StringUtils.startsWith(texText, startStr)
						&& StringUtils.endsWith(texText, endStr)) {
					String numberStr = StringUtils.removeStart(texText, startStr);
					numberStr = StringUtils.removeEnd(numberStr, endStr);
					salesQuantity = Integer.valueOf(numberStr);
				}
			} else {
				System.out.println();
			}
			tempMap.put(sortId1, salesQuantity);
//			System.out.println(sortId1 + "============" + salesQuantity);
		}
		return tempMap;
	}

	public Map<String, Object> parseHtml(Document document, String url) {
		Map<String, Object> sortDetail = new LinkedHashMap<>();

		// 获取店名
		Element titleA = document.getElementsByClass("shopping-cart").first();
		Map<String, String> tempA = titleA.dataset();
		for (String key : tempA.keySet()) {
			if (StringUtils.equals(key, "status")) {
				continue;
			} else {
				String newKey = null;
				if (StringUtils.equals(key, "poiid")) {
					newKey = "sortId";
				} else {
					newKey = "sortName";
				}
				
				if (newKey.equals("sortId")) {
					sortDetail.put("salesQuantity", tempMap.get(tempA.get(key)));
				}
				sortDetail.put(newKey, tempA.get(key));
			}
		}

		// 获取店家评分
		Element rankA = document.getElementsByClass("nu").first();
		List<Node> rankList = rankA.childNodes();
		for (int y = 0; y < rankList.size(); y++) {
			Node tempB = rankList.get(y);
			if (StringUtils.equals(tempB.nodeName(), "strong")) {
				sortDetail.put("rank", tempB.childNodes().get(0));
			}
		}

		// 起送价格,配送费
		Element startMoneyA = document.getElementsByClass("rest-info-thirdpart").first();
		// System.out.println(startMoneyA.html());
		Element startMoneyB = startMoneyA.after(startMoneyA.html());
		String startMoneyCStr = startMoneyB.child(0).html();
		String[] startMoneyCStrArr = StringUtils.split(startMoneyCStr, "&nbsp;");
		String startUp = null;
		String distributionUp = null;
		for (int x = 0; x < startMoneyCStrArr.length; x++) {
			if (StringUtils.endsWith(startMoneyCStrArr[x], "元起送")) {
				startUp = StringUtils.removeEnd(startMoneyCStrArr[x], "元起送");
			} else {
				if (StringUtils.endsWith(startMoneyCStrArr[x], "元配送费")) {
					distributionUp = StringUtils.removeEnd(startMoneyCStrArr[x], "元配送费");
				} else {
					continue;
				}
			}
		}
		sortDetail.put("startUp", startUp);
		sortDetail.put("distributionUp", StringUtils.isEmpty(distributionUp) ? "0" : distributionUp);

		// 营业时间
		Element businessDateA = document.getElementsByClass("delivery-time").first();
		Element businessDateB = businessDateA.getElementsByTag("span").last();
		sortDetail.put("businessDate", businessDateB.text());

		// 送餐时间
		Element deliverMealsA = document.getElementsByClass("nu").get(1);
		List<Node> deliverMealsList = deliverMealsA.childNodes();
		for (int y = 0; y < deliverMealsList.size(); y++) {
			Node tempB = deliverMealsList.get(y);
			if (StringUtils.equals(tempB.nodeName(), "strong")) {
				sortDetail.put("deliverMeals", tempB.childNodes().get(0));
			}
		}

		// 送餐到达率
		Element arriveA = document.getElementsByClass("nu").last();
		List<Node> arriveAList = arriveA.childNodes();
		for (int y = 0; y < arriveAList.size(); y++) {
			Node tempB = arriveAList.get(y);
			if (StringUtils.equals(tempB.nodeName(), "strong")) {
				sortDetail.put("arrive", tempB.childNodes().get(0));
			} else {
				sortDetail.put("arrive", 0);
			}
		}

		// 收藏
		Element collectA = document.getElementsByClass("cc-lightred-new").first();
		if (StringUtils.isEmpty(document.getElementsByClass("cc-lightred-new").text())) {
			sortDetail.put("collectNumber", 0);
		} else {
			Element collectB = collectA.getElementsByTag("span").first();
			sortDetail.put("collectNumber", collectB.text());
		}

		// 地址
		Element locationA = document.getElementsByClass("location").first();
		Element locationB = locationA.getElementsByTag("span").last();
		sortDetail.put("location", locationB.text());

		// 电话
		Element telephoneA = document.getElementsByClass("telephone").first();
		Element telephoneB = telephoneA.getElementsByTag("span").last();
		sortDetail.put("telephone", telephoneB.text());

		// url
		sortDetail.put("url", url);

		// 销售量(月)
		int footBodyNumber = document.getElementsByClass("sold-count").size();
		int salesAllQuantity = 0;
		for (int x = 0; x < footBodyNumber; x++) {
			Element fooderBodyA = document.getElementsByClass("sold-count").get(x);
			if (StringUtils.isEmpty(StringUtils.trim(fooderBodyA.html()))) {
				continue;
			} else {
				Element fooderBoodyB = fooderBodyA.getElementsByTag("span").first();
				String startStr = "月售";
				String endStr = "份";
				String texText = fooderBoodyB.text();
				
				if (StringUtils.startsWith(texText, startStr)
						&& StringUtils.endsWith(texText, endStr)) {
					String numberStr = StringUtils.removeStart(texText, startStr);
					numberStr = StringUtils.removeEnd(numberStr, endStr);
					salesAllQuantity += Integer.parseInt(numberStr);
				}
			}
		}
		
		int footBodyNumber1 = document.getElementsByAttributeValue("class", "count ct-lightgrey").size();
		for (int x = 0; x < footBodyNumber1; x++) {
			Element fooderBodyC = document.getElementsByAttributeValue("class", "count ct-lightgrey").get(x);
			if (StringUtils.isEmpty(StringUtils.trim(fooderBodyC.html()))) {
				continue;
			} else {
				Element fooderBoodyD = fooderBodyC.getElementsByTag("span").first();
				String startStr = "月售";
				String endStr = "份";
				String texText = fooderBoodyD.text();
				
				if (StringUtils.startsWith(texText, startStr)
						&& StringUtils.endsWith(texText, endStr)) {
					String numberStr = StringUtils.removeStart(texText, startStr);
					numberStr = StringUtils.removeEnd(numberStr, endStr);
					salesAllQuantity += Integer.parseInt(numberStr);
				}
			}
		}
		sortDetail.put("salesAllQuantity", salesAllQuantity);
		System.out.println(sortDetail.toString());
		return sortDetail;
	}

	@Override
	public Site getSite() {
		return site;
	}

	public String getReal() {
		return real;
	}

	public void setReal(String real) {
		this.real = real;
	}

	public static void main(String[] args) {
		MeiTuanReptile meiTuanReptile = new MeiTuanReptile();
		meiTuanReptile.setReal("http://waimai.meituan.com/home/wsb0uqe32sz6");
		Spider.create(meiTuanReptile).addUrl("http://waimai.meituan.com").thread(1).run();
	}

}