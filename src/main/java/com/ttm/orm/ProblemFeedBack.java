package com.ttm.orm;
/**
 * 
 * <p>介绍 问题反馈</p>
 * @author 唐太明
 * @date 2016年7月4日 下午11:52:25
 * @version 1.0
 */
public class ProblemFeedBack {

	private Integer id;
	
	private String name;
	
	private String email;

	/**
	 * 主题
	 */
	private String theme;
	
	/**
	 * 主题内容
	 */
	private String themeContent;
	
	private String createdDate;
	
	/**
	 * 是否解决
	 */
	private Integer solve;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getThemeContent() {
		return themeContent;
	}

	public void setThemeContent(String themeContent) {
		this.themeContent = themeContent;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getSolve() {
		return solve;
	}

	public void setSolve(Integer solve) {
		this.solve = solve;
	}
	
}
