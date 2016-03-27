package com.ttm.orm;
/**
 * 
 * <p>介绍：学校</p>
 * @author 唐太明
 * @date 2016年3月25日 上午12:17:46
 * @version 1.0
 */
public class School {

	private Integer id;
	
	private String name;
	
	/**
	 * 代码用于区分校区使用 例如 1 代表 老校区 2 代表 新校区等
	 */
	private Integer code;
	
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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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
