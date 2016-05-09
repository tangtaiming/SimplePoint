package com.ttm.enums;

/**
 * 
 * <p>
 * 介绍:店铺属性枚举
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月25日 上午7:48:52
 * @version 1.0
 */
public enum StoreEnum {

	/**
	 * 店名
	 */
	NAME("店名", "name"),
	/**
	 * 评分
	 */
	REVIEWSCORES("评分", "reviewScores"),
	/**
	 * 销售量(月)
	 */
	SALESQUANTITY("销售量(月)", "salesQuantity"),
	/**
	 * 销售量(总)
	 */
	SALESALLQUANTITY("销售量(总)", "salesAllQuantity"),
	/**
	 * 起送价格
	 */
	SENDTHEPRICE("起送价格", "sendThePrice"),
	/**
	 * 配送费
	 */
	DISTRIBUTIONCOST("配送费", "distributionCost"),
	/**
	 * 送餐所需时间
	 */
	SHOPHOURS("送餐所需时间", "shopHours"),
	/**
	 * 送餐到达率
	 */
	SHOPRREACH("送餐到达率", "shoprReach"),
	/**
	 * 收藏数量
	 */
	COLLECTQUANTITY("收藏数量", "collectQuantity"),
	/**
	 * 营业时间
	 */
	BUSINESSDATE("营业时间", "businessDate"),
	/**
	 * 地址
	 */
	ADDRESS("地址", "address"),
	/**
	 * 电话
	 */
	PHONE("电话", "phone"),
	/**
	 * url
	 */
	URL("url", "url"),
	/**
	 * 店铺是否关闭
	 */
	STATUS("店铺是否关闭", "status"),
	/**
	 * 类型
	 */
	SORTTYPEID("类型", "sortTypeId"),
	/**
	 * 首单优惠
	 */
	FIRSTORDER("首单优惠", "firstOrder"),
	/**
	 * 减免
	 */
	MINUSEXEMPT("减免", "minusExempt"),
	/**
	 * 达到就送
	 */
	GIVE("达到就送", "give"),
	/**
	 * 学校
	 */
	SCHOOLID("学校", "schoolId");

	private String storeNameZh;
	private String storeName;

	private StoreEnum(String storeNameZh, String storeName) {
		this.storeNameZh = storeNameZh;
		this.storeName = storeName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreNameZh() {
		return storeNameZh;
	}

	public void setStoreNameZh(String storeNameZh) {
		this.storeNameZh = storeNameZh;
	}

}
