package com.ttm.orm;
/**
 * <p>介绍：商店实体</p>
 * @author 唐太明
 * @date 2016年3月17日下午12:57:42
 * @version 1.0
 */
public class Store {

	/**
	 * 流水号ID
	 */
	private Integer id;
	
	/**
	 * 店铺ID
	 */
	private Integer sortId;
	
	/**
	 * 店名
	 */
	private String name;
	
	/**
	 * 评分
	 */
	private Double reviewScores;
	
	/**
	 * 销售量(月)
	 */
	private Integer salesQuantity;
	
	/**
	 * 销售量(总)
	 */
	private Integer salesAllQuantity;
	
	/**
	 * 起送价格
	 */
	private Integer sendThePrice;
	
	/**
	 * 配送费
	 */
	private Integer distributionCost;
	
	/**
	 * 送餐所需时间
	 */
	private String shopHours;
	
	/**
	 * 送餐到达率
	 */
	private Double shoprReach;
	
	/**
	 * 收藏数量
	 */
	private Integer collectQuantity;
	
	/**
	 * 营业时间
	 */
	private String businessDate;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 电话
	 */
	private Integer phone;
	
	/**
	 * url
	 */
	private String url;
	
	/**
	 * 店铺是否关闭
	 */
	private Integer status;
	
	/**
	 * 店铺属于公司
	 */
	private Integer sortType;
	
	/**
	 * 首单优惠
	 */
	private String firstOrder;
	
	/**
	 * 减免
	 */
	private String minusExempt;
	
	/**
	 * 下单就送
	 */
	private String give;
	
}
