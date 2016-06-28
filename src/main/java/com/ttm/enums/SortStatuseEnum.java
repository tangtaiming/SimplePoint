package com.ttm.enums;
/**
 * 店铺状态枚举
 * <p>介绍</p>
 * @author 唐太明
 * @date 2016年3月21日下午1:16:28
 * @version 1.0
 */
public enum SortStatuseEnum {

	STATUS_ONE(1, "运营"),	//正在运营
	STATUS_TWO(2, "下线");	//店铺下线
	
	private int status;
	
	private String statusName;
	
	private SortStatuseEnum(int status, String statusName) {
		this.status = status;
		this.statusName = statusName;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusName() {
		return statusName;
	} 
	
}
