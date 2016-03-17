package com.ttm.reptile;

import us.codecraft.webmagic.Spider;

/**
 * <p>介绍：美团爬虫启动</p>
 * @author 唐太明
 * @date 2016年3月15日 下午11:03:21
 * @version 1.0
 */
public class MeiTuanReptileFactory {
	
	private static final String MEI_TUAN = "http://waimai.meituan.com";
	
	/**
	 * 开启一个美团爬虫爬取对应网址的数据
	 * @param url
	 */
	public void startMeituan(String url) {
		MeiTuanReptile meiTuanReptile = new MeiTuanReptile();
		meiTuanReptile.setReal(url);
		Spider.create(meiTuanReptile).addUrl(MEI_TUAN).thread(3).run();
	}
	
}