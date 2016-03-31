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
	private Integer storeId;
	
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
	private Integer shopHours;
	
	/**
	 * 送餐到达率
	 */
	private Integer shoprReach;
	
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
	private String phone;
	
	/**
	 * url
	 */
	private String url;
	
	/**
	 * 店铺是否关闭
	 */
	private Integer status;
	
	/**
	 * 类型
	 */
	private Integer sortTypeId;
	
	/**
	 * 首单优惠
	 */
	private String firstOrder;
	
	/**
	 * 减免
	 */
	private String minusExempt;
	
	/**
	 * 达到就送
	 */
	private String give;
	
	/**
	 * 创建人
	 */
	private Integer creatdId;
	
	/**
	 * 创建时间
	 */
	private String creatdDate;
	
	/**
	 * 修改时间
	 */
	private String updateDate;
	
	/**
	 * 学校
	 */
	private School schoolId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getReviewScores() {
		return reviewScores;
	}

	public void setReviewScores(Double reviewScores) {
		this.reviewScores = reviewScores;
	}

	public Integer getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(Integer salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public Integer getSalesAllQuantity() {
		return salesAllQuantity;
	}

	public void setSalesAllQuantity(Integer salesAllQuantity) {
		this.salesAllQuantity = salesAllQuantity;
	}

	public Integer getSendThePrice() {
		return sendThePrice;
	}

	public void setSendThePrice(Integer sendThePrice) {
		this.sendThePrice = sendThePrice;
	}

	public Integer getDistributionCost() {
		return distributionCost;
	}

	public void setDistributionCost(Integer distributionCost) {
		this.distributionCost = distributionCost;
	}

	public Integer getCollectQuantity() {
		return collectQuantity;
	}

	public void setCollectQuantity(Integer collectQuantity) {
		this.collectQuantity = collectQuantity;
	}

	public String getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(String businessDate) {
		this.businessDate = businessDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortTypeId() {
		return sortTypeId;
	}

	public void setSortTypeId(Integer sortTypeId) {
		this.sortTypeId = sortTypeId;
	}

	public String getFirstOrder() {
		return firstOrder;
	}

	public void setFirstOrder(String firstOrder) {
		this.firstOrder = firstOrder;
	}

	public String getMinusExempt() {
		return minusExempt;
	}

	public void setMinusExempt(String minusExempt) {
		this.minusExempt = minusExempt;
	}

	public String getGive() {
		return give;
	}

	public void setGive(String give) {
		this.give = give;
	}

	public Integer getCreatdId() {
		return creatdId;
	}

	public void setCreatdId(Integer creatdId) {
		this.creatdId = creatdId;
	}

	public String getCreatdDate() {
		return creatdDate;
	}

	public void setCreatdDate(String creatdDate) {
		this.creatdDate = creatdDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getShopHours() {
		return shopHours;
	}

	public void setShopHours(Integer shopHours) {
		this.shopHours = shopHours;
	}

	public Integer getShoprReach() {
		return shoprReach;
	}

	public void setShoprReach(Integer shoprReach) {
		this.shoprReach = shoprReach;
	}

	public School getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(School schoolId) {
		this.schoolId = schoolId;
	}
	
}
