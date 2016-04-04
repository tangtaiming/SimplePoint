package com.ttm.orm;

/**
 * 
 * <p>
 * 介绍：安全模块
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月4日 下午2:16:04
 * @version 1.0
 */
public class Safety {

	private Integer id;
	
	private String title;
	
	private String url;
	
	/**
	 * 图片地址
	 */
	private String img;
	
	/**
	 * 标记
	 */
	private Integer mark;
	
	private Integer creatdId;
	
	private String creatdDate;
	
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
