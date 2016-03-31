package com.ttm.reptile;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.beans.propertyeditors.ZoneIdEditor;

import com.ttm.orm.Store;
import com.ttm.util.Dumper;

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

	// private static final String GET_HOME = "http://waimai\\.meituan\\.com";

	/**
	 * 获取月销量 Map
	 */
	private Map<String, Object> tempMap;

	private List<Map<String, Object>> listsMap = new ArrayList<Map<String, Object>>();

	private List<Store> storesList = new ArrayList<Store>();

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
			// System.out.println(sortA.dataset().get("title"));

			Integer salesQuantity = 0;
			if (!(sortA.getElementsByAttributeValue("class", "total cc-lightred-new fr").isEmpty())) {
				Element salesQuantityB = sortA.getElementsByAttributeValue("class", "total cc-lightred-new fr").get(0);
				String startStr = "月售";
				String endStr = "单";
				String texText = salesQuantityB.text();

				if (StringUtils.startsWith(texText, startStr) && StringUtils.endsWith(texText, endStr)) {
					String numberStr = StringUtils.removeStart(texText, startStr);
					numberStr = StringUtils.removeEnd(numberStr, endStr);
					salesQuantity = Integer.valueOf(numberStr);
				}
			} else {
				System.out.println();
			}
			tempMap.put(sortId1, salesQuantity);
			// System.out.println(sortId1 + "============" + salesQuantity);
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
					newKey = "storeId";
				} else {
					newKey = "name";
				}

				if (newKey.equals("storeId")) {
					// 获取销售量(月)
					sortDetail.put("salesQuantity", tempMap.get(tempA.get(key)));
				}
				sortDetail.put(newKey, tempA.get(key));
			}
		}

		// 获取店家评分
		getRow("fl ack-ti", "reviewScores", sortDetail, document);

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
		sortDetail.put("sendThePrice", startUp);
		sortDetail.put("distributionCost", StringUtils.isEmpty(distributionUp) ? "0" : distributionUp);

		// 营业时间
		Element businessDateA = document.getElementsByClass("delivery-time").first();
		Element businessDateB = businessDateA.getElementsByTag("span").last();
		sortDetail.put("businessDate", businessDateB.text());

		// 送餐时间
		getRow("fl average-speed", "shopHours", sortDetail, document);

		// 送餐到达率
		getRow("fl in-ti", "shoprReach", sortDetail, document);

		// 收藏
		Element collectA = document.getElementsByClass("cc-lightred-new").first();
		if (StringUtils.isEmpty(document.getElementsByClass("cc-lightred-new").text())) {
			sortDetail.put("collectQuantity", 0);
		} else {
			Element collectB = collectA.getElementsByTag("span").first();
			sortDetail.put("collectQuantity", collectB.text());
		}

		// 地址
		Element locationA = document.getElementsByClass("location").first();
		Element locationB = locationA.getElementsByTag("span").last();
		sortDetail.put("address", locationB.text());

		// 电话
		Element telephoneA = document.getElementsByClass("telephone").first();
		Element telephoneB = telephoneA.getElementsByTag("span").last();
		sortDetail.put("phone", telephoneB.text());

		// url
		sortDetail.put("url", url);

		// 销售量(总)
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

				if (StringUtils.startsWith(texText, startStr) && StringUtils.endsWith(texText, endStr)) {
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

				if (StringUtils.startsWith(texText, startStr) && StringUtils.endsWith(texText, endStr)) {
					String numberStr = StringUtils.removeStart(texText, startStr);
					numberStr = StringUtils.removeEnd(numberStr, endStr);
					salesAllQuantity += Integer.parseInt(numberStr);
				}
			}
		}
		sortDetail.put("salesAllQuantity", salesAllQuantity);

		// 首单优惠 firstOrder
		getPrivilege("icon i-first", "1.没有首单优惠...", sortDetail, "firstOrder", document);

		// 减免
		getPrivilege("icon i-minus", "2.没有减免...", sortDetail, "minusExempt", document);

		// 达到就送
		getPrivilege("icon i-free-gift", "3.没有赠送优惠...", sortDetail, "give", document);
		System.out.println(sortDetail.toString());
		parseStore(sortDetail, url, (String) sortDetail.get("firstOrder"), (String) sortDetail.get("minusExempt"),
				(String) sortDetail.get("give"));
		listsMap.add(sortDetail);
		return sortDetail;
	}

	public void getPrivilege(String classValue, String emptyName, Map<String, Object> sortDetail, String key,
			Document document) {
		Elements firstOrderA = document.getElementsByAttributeValue("class", classValue);
		String bodyHtml = null;
		if (firstOrderA.isEmpty()) {
//			System.out.println("^^^^^^^^^^^^^^^^^^^^^" + emptyName);
		} else {
			Element firstOrderB = firstOrderA.first().nextElementSibling();
//			System.out.println("+++++++++++++++++++++" + firstOrderB.html());
			bodyHtml = firstOrderB.html();
		}
		sortDetail.put(key, bodyHtml);
	}

	/**
	 * 评分/平均送餐时间/送餐到达率
	 * 
	 * @param classValue
	 * @param key
	 * @param sortDetail
	 * @param document
	 */
	public void getRow(String classValue, String key, Map<String, Object> sortDetail, Document document) {
		Element arriveA = document.getElementsByAttributeValue("class", classValue).first();
		Element arriveB = arriveA.getElementsByAttributeValue("class", "nu").first();
		List<Node> arriveAList = arriveB.childNodes();
		for (int y = 0; y < arriveAList.size(); y++) {
			Node tempB = arriveAList.get(y);
			if (StringUtils.equals(tempB.nodeName(), "strong")) {
				String tempValue = null;
				if (classValue.equals("fl average-speed")) {
					tempValue = StringUtils.removeEnd(tempB.childNodes().get(0).toString(), "+");
				} else {
					tempValue = tempB.childNodes().get(0).toString();
				}
//				System.out.println("^^^^^^^^^^^^^^^^^^^^" + tempValue);
				sortDetail.put(key, tempValue);
			}
		}
	}

	public void parseStore(Map<String, Object> dataMap, String url, String firstOrder, String minusExempt,
			String give) {
		Store store = new Store();
		try {
			BeanUtils.populate(store, dataMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		store.setUrl(url);
		store.setFirstOrder(firstOrder);
		store.setMinusExempt(minusExempt);
		store.setGive(give);
		//1 代表 此家点正在运营
		store.setStatus(1);
		storesList.add(store);
		System.out.println("^^^^^^^^^^^^^爬取 " + storesList.size() + " 条数据");
//		Dumper.dump(store);
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		// TimeZone zon = TimeZone.getTimeZone("Asia/Shanghai");
		// Calendar calendar = Calendar.getInstance(zon);
		// String creatdDate = format.format(calendar.getTime());
		// store.setCreatdDate(creatdDate);

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
		Store store = new Store();
		for (Map<String, Object> tempA : meiTuanReptile.getListsMap()) {
			try {
				BeanUtils.populate(store, tempA);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Map<String, Object>> getListsMap() {
		return listsMap;
	}

	public void setListsMap(List<Map<String, Object>> listsMap) {
		this.listsMap = listsMap;
	}

	public List<Store> getStoresList() {
		return storesList;
	}

	public void setStoresList(List<Store> storesList) {
		this.storesList = storesList;
	}

}