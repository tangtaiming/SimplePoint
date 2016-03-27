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
	
	private String createDate;
	
	/**
	 * 所属平台
	 */
	private Integer sortTypeId;
	
	/**
	 * 学校
	 */
	private Integer schoolId;

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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getSortTypeId() {
		return sortTypeId;
	}

	public void setSortTypeId(Integer sortTypeId) {
		this.sortTypeId = sortTypeId;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	
}
