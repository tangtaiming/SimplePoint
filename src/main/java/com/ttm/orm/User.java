package com.ttm.orm;
/**
 * 
 * <p>介绍 用户实体</p>
 * @author 唐太明
 * @date 2016年6月26日 上午12:22:05
 * @version 1.0
 */
public class User {

	private Integer id;
	
	private String name;
	
	private String account;
	
	private String password;
	
	private String createDate;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
