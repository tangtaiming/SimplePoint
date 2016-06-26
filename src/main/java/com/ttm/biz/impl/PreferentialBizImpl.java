package com.ttm.biz.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.dialect.Sybase11Dialect;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttm.biz.PreferentialBiz;
import com.ttm.dao.PreferentialDao;
import com.ttm.dao.impl.PreferentialDaoImpl;
import com.ttm.orm.Preferential;
import com.ttm.orm.PreferentialValue;
import com.ttm.util.Dumper;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ParamsUtils;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceSorterHelper;
/**
 * 
 * <p>介绍:优惠业务层</p>
 * @author 唐太明
 * @date 2016年4月2日 下午11:19:08
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class PreferentialBizImpl implements PreferentialBiz {
	
	private static final Logger log = Logger.getLogger(PreferentialBizImpl.class);
	
	private PreferentialDao preferentialDao = new PreferentialDaoImpl();
	
	private Preferential preferential;
	
	private Page page;

	private List<Integer> showPage;
	
	/**
	 * 默认当前页
	 */
	private int pageNumber = 1;

	/**
	 * 每页显示数量
	 */
	private int size = 1;

	/**
	 * 总共数量
	 */
	private int totalNumber = 1;

	/**
	 * 前后显示数量
	 */
	private int pageRange = 5;
	
	private List<PreferentialValue> preferentialValuesList;
	
	public boolean saveOrUpdatePreferentialCurrent(Map<String, Object> preferentialMap) {
//		Map<String, Object> mList = (Map<String, Object>) preferentialMap.get("requestJson");
		String name = (String) preferentialMap.get("name");
		String url = (String) preferentialMap.get("url");
		
		preferential = new Preferential();
		if (preferentialMap.get("id") == null) {
			//1 代表唐太泰明
			preferential.setCreatdId(1);
			//获取系统当前时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String creatdDate = format.format(new Date());
			preferential.setCreatdDate(creatdDate);
			preferential.setName(name);
			preferential.setUrl(ParamsUtils.URL_START + url + ParamsUtils.URL_END);
			if (preferentialDao.addPreferential(preferential)) {
				log.info("preferential 保存数据成功...");
			} else {
				log.error("preferential 保存数据失败...");
			}
		} else {
			
		}
		
		
//		if (mList.size() <= 1) {
//			Map<String, Object> mValueMap = mList.get(0);
//			String firstKey = "0";
//			Map<String, Object> firstMap = (Map<String, Object>) mValueMap.get(firstKey);
//			String name = (String) firstMap.get("name");
//			
//			//循环获取
//			Integer number = 0;
//			String mParams = "";
//			for (String mKey : mValueMap.keySet()) {
//				if (mKey.equals(firstKey)) {
//					continue;
//				}
//				
//				Map<String, Object> mMap = (Map<String, Object>) mValueMap.get(mKey);
//				String attName = (String) mMap.get("fix");
//				String symbol = (String) mMap.get("sign");
//				String attValue = "";
//				String p = "&p" + (number + 1) + "=";
//				if (symbol.equals("gt") || symbol.equals("eq")) {
//					attValue = (String) mMap.get("value");
//					mParams += p + attName + "_" + symbol + "_" + attValue;
//				} else {
//					mParams += p + attName + "_" + symbol;
//				}
//				
//	 			number++;
//			}
//			log.info("params:" + mParams);
//			mParams += ParamsUtils.URL_END;
//			mParams = ParamsUtils.URL_START + StringUtils.removeStart(mParams, "&");
//			preferential = new Preferential();
//			preferential.setUrl(mParams);
//			preferential.setName(name);
//			//1 代表唐太泰明
//			preferential.setCreatdId(1);
//			//获取系统当前时间
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String creatdDate = format.format(new Date());
//			preferential.setCreatdDate(creatdDate);
//			if (preferentialDao.addPreferential(preferential)) {
//				log.info("preferential 保存数据成功...");
//			} else {
//				log.error("preferential 保存数据失败...");
//			}
//			
//		} else {
//			Map<String, Object> mId = mList.get(0);
//			String id = (String) mId.get("id");
//			
//			Preferential preferential = preferentialDao.findPreferentialById(Integer.valueOf(id));
//			if (preferential == null) {
//				System.out.println("没有查询出优惠数据.");
//				return false;
//			}
//			
//			Map<String, Object> mValueMap = mList.get(1);
//			String firstKey = "0";
//			Map<String, Object> firstMap = (Map<String, Object>) mValueMap.get(firstKey);
//			String name = (String) firstMap.get("name");
//			
//			//循环获取
//			Integer number = 0;
//			String mParams = "";
//			for (String mKey : mValueMap.keySet()) {
//				if (mKey.equals(firstKey)) {
//					continue;
//				}
//				
//				Map<String, Object> mMap = (Map<String, Object>) mValueMap.get(mKey);
//				String attName = (String) mMap.get("fix");
//				String symbol = (String) mMap.get("sign");
//				String attValue = "";
//				String p = "&p" + (number + 1) + "=";
//				if (!symbol.equals("not")) {
//					attValue = (String) mMap.get("value");
//					mParams += p + attName + "_" + symbol + "_" + attValue;
//				} else {
//					mParams += p + attName + "_" + symbol;
//				}
//				
//	 			number++;
//			}
//			log.info("params:" + mParams);
//			mParams += ParamsUtils.URL_END;
//			mParams = ParamsUtils.URL_START + StringUtils.removeStart(mParams, "&");
//			preferential.setUrl(mParams);
//			preferential.setName(name);
//			if (preferentialDao.updatePreferential(preferential)) {
//				log.info("preferential 修改数据成功...");
//			} else {
//				log.error("preferential 修改数据失败...");
//			}
//		}
		return true;
	}

	@Deprecated
	public boolean saveOrUpdatePreferential(Map<String, Object> preferentialMap) {
		if (MapUtils.isEmpty(preferentialMap)) {
			log.info("传入参数 为空...");
			return false;
		}
		for (String key : preferentialMap.keySet()) {
			String value = (String) preferentialMap.get(key);
			if (StringUtils.isEmpty(value)) {
				continue;
			}
			
			//如果为true 才进行数据保存和修改操作  这里的key 存储的就是 id
			if (findPreferential(Integer.valueOf(key))) {
				preferential.setId(Integer.valueOf(key));
				preferential.setName(value);
				//1 代表唐太泰明
				preferential.setCreatdId(1);
				
				//获取系统当前时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String creatdDate = format.format(new Date());
				preferential.setCreatdDate(creatdDate);
				
				if (preferentialDao.addPreferential(preferential)) {
					log.info("preferential 保存数据成功...");
				} else {
					log.error("preferential 保存数据失败...");
				}
			} else {
				preferential.setName(value);
				if (preferentialDao.updatePreferential(preferential)) {
					log.info("preferential 修改数据成功...");
				} else {
					log.error("preferential 修改数据失败...");
				}
			}
		}
		return true;
	}
	
	public Map<String, Object> parseRequestParams(String requestJson) {
		Map<String, Object> tempMap = new HashMap<String, Object>();
		ObjectMapper om = new ObjectMapper();
		if (StringUtils.isNotEmpty(requestJson)) {
			try {
				tempMap = om.readValue(requestJson, Map.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tempMap;
	}

	public List<Preferential> findPreferentialList(Integer page, Integer size) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build("id", ServiceSorterHelper.DESC);
		List<Preferential> preferentialsList = preferentialDao.findPreferentialByList(null, sort, pageing);
		
		PageUtil pageUtil = PageUtil.getPageUtil();
		if (CollectionUtils.isNotEmpty(preferentialsList)) {
			this.totalNumber = countReptileNumber();
			this.size = size;
			this.pageNumber = page;
		}
		this.page = pageUtil.createPage(this.pageNumber, this.size, this.totalNumber, this.pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return preferentialsList;
	}

	public Integer countReptileNumber() {
		List<Preferential> preferentials = preferentialDao.findPreferentialByList(null, null, null);
		if (CollectionUtils.isNotEmpty(preferentials)) {
			return preferentials.size();
		}
		return 1;
	}

	public List<Preferential> findPreferentialList(String sortName, String sortValue) {
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, sortValue);
		List<Preferential> preferentialsList = preferentialDao.findPreferentialByList(null, sort, ServicePaginationHelper.build(21, 1));
		if (CollectionUtils.isNotEmpty(preferentialsList)) {
			log.info("排序查询出数据...");
		}
		return preferentialsList;
	}
	
	public boolean saveOrUpdatePreferentialSimple(String name, String url) {
		//去除左右空格判断是否为空值?
		if (StringUtils.isEmpty(name.trim())) {
			log.warn("name值为空.");
			return false;
		} 
		if (StringUtils.isEmpty(url.trim())) {
			log.warn("url值为空.");
			return false;
		}
		
		preferential = new Preferential();
		preferential.setName(name);
		preferential.setUrl(url);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		preferential.setCreatdDate(format.format(new Date()));
		//1  代表唐太明
		preferential.setCreatdId(1);
		return preferentialDao.addPreferential(preferential);
	}

	public boolean deletePreferential(Integer id) {
		if (findPreferential(id)) {
			log.warn(preferential.getClass().getName() + " 实体对象查询数据为空.");
			return false;
		}
		
		return preferentialDao.deletePreferential(preferential);
	}
	
	public boolean updatePreferential(Preferential preferential) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Preferential findPreferentialById(Integer id) {
		preferential = preferentialDao.findPreferentialById(id);
		preferentialValuesList = parseUrl(preferential.getUrl());
		return preferential;
	}
	
	
	//******************************************************************************************
	
	/**
	 * 解析url 获取参数
	 * @param url
	 * @return
	 */
	public List<PreferentialValue> parseUrl(String url) {
		List<PreferentialValue> mList = new ArrayList<>();
		String mUrl = url;
		mUrl = StringUtils.removeStart(mUrl, ParamsUtils.URL_START);
		mUrl = StringUtils.removeEnd(mUrl, ParamsUtils.URL_END);
		String[] params = StringUtils.split(mUrl, "&");
		for (int x = 0; x < params.length; x++) {
			PreferentialValue pMap = new PreferentialValue();
			String mP = params[x];
			String removeP = "p" + (x + 1) + "=";
			if (StringUtils.contains(mP, removeP)) {
				mP = StringUtils.remove(mP, removeP);
			}
			String[] rowP = StringUtils.split(mP, "_");
			pMap.setName(rowP[0]);
			pMap.setSign(rowP[1]);
			if (rowP.length > 2) {
				pMap.setValue(Double.valueOf(rowP[2]));
			}
			mList.add(pMap);
		}
		return mList;
	}
	
	/**
	 * id查询是否有对应的优惠数据
	 * 	true 查询出 数据 做数据更新操作
	 *  false 否则做保存操作
	 * @param id
	 * @return
	 */
	private boolean findPreferential(Integer id) {
		preferential = preferentialDao.findPreferentialById(id);
		if (preferential == null) {
			preferential = new Preferential();
			return true;
		} else {
			return false;
		}
	}

	public boolean updateIndex() {
		List<Preferential> preferentialsList = findPreferentialList("id", ServiceSorterHelper.ASC);
		if (CollectionUtils.isEmpty(preferentialsList)) {
			return false;
		}
		File file = new File("E://Project//learngit//SimplePoint//src//main//webapp//index.jsp");
		System.out.println("~~~~~~~~~~~~~" + file.isFile());
		Document document = null;
		try {
			document = Jsoup.parse(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element div = document.getElementById("box_famoussite_1");
		System.out.println(div.html());
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^删除后");
		//删除所有元素
		div.select("span").remove();
		System.out.println(div.html());
		for (Preferential preferential : preferentialsList) {
			String startHtml = "<span> <a class=\"famoussite-mainlink\" href=\"http://www.fang.com \">";
			String endHtml = "</a></span>";
			div.append(startHtml + preferential.getName() + endHtml);
		}
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^更新之后");
		System.out.println(div.html());
		
		char[] buffer = new char[32];
		int hasRead = 0;
		
		StringReader sr = null;
		FileWriter sw = null;
		try {
			sr = new StringReader(document.html());
			sw = new FileWriter(file);
			while((hasRead = sr.read(buffer)) > 0){
				sw.write(buffer, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sr != null) {
				sr.close();
			}
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	
	/**
	 * 计算显示分页 
	 * <p>showPage集合在这里设置值</p>
	 * 
	 * @param start
	 * @param end
	 */
	private void countShowPage(Integer start, Integer end) {
		List<Integer> showPage = new ArrayList<Integer>();
		for (int x = start; x <= end; x++) {
			showPage.add(x);
		}
		setShowPage(showPage);
	}
	
	/**
	 * 查询没有数据的时候获取
	 * @return
	 */
	public List<Integer> fetch21() {
		List<Integer> numbersList = new ArrayList<Integer>();
		for (int x = 1; x <= 21; x++) {
			numbersList.add(x);
		}
		return numbersList;
	}
	
	public Preferential getPreferential() {
		return preferential;
	}

	public void setPreferential(Preferential preferential) {
		this.preferential = preferential;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Integer> getShowPage() {
		return showPage;
	}

	public void setShowPage(List<Integer> showPage) {
		this.showPage = showPage;
	}

	public List<PreferentialValue> getPreferentialValuesList() {
		return preferentialValuesList;
	}

	public void setPreferentialValuesList(List<PreferentialValue> preferentialValuesList) {
		this.preferentialValuesList = preferentialValuesList;
	}

}
