package com.ttm.orm;
/**
 * 
 * <p>介绍: 爬虫起始URL 实体</p>
 * @author 唐太明
 * @date 2016年3月25日 下午9:25:51
 * @version 1.0
 */
public class Reptile {

	private Integer id;
	
	private String url;
	
	private Integer creatdId;
	
	private String creatdDate;
	
	/**
	 * 所属平台
	 */
	private Integer sortTypeId;
	
	/**
	 * 学校
	 */
	private School schoolId;
	
	/**
	 * 修改时间
	 */
	private String updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCreatdId() {
		return creatdId;
	}

	public void setCreatdId(Integer creatdId) {
		this.creatdId = creatdId;
	}


	public Integer getSortTypeId() {
		return sortTypeId;
	}

	public void setSortTypeId(Integer sortTypeId) {
		this.sortTypeId = sortTypeId;
	}

	public School getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(School schoolId) {
		this.schoolId = schoolId;
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

}
