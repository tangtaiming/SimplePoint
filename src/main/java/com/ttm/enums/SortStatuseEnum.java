package com.ttm.enums;
/**
 * 店铺状态枚举
 * <p>介绍</p>
 * @author 唐太明
 * @date 2016年3月21日下午1:16:28
 * @version 1.0
 */
public enum SortStatuseEnum {

	STATUS_ONE(1),
	STATUS_TWO(2);
	
	private int status;
	
	private SortStatuseEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	} 
	
}
