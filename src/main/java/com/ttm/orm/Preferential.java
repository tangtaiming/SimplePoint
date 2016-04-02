package com.ttm.orm;

/**
 * 
 * <p>
 * 介绍 ：优惠
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月2日 下午4:54:49
 * @version 1.0
 */
public class Preferential {

	private Integer id;

	private String name;

	private Integer creatdId;

	private String creatdDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
