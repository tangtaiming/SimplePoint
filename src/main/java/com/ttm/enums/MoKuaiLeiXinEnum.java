package com.ttm.enums;

/**
 * 
 * <p>
 * 介绍:模块类型枚举
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月24日 上午10:12:48
 * @version 1.0
 */
public enum MoKuaiLeiXinEnum {

	//食物安全
	SHIWU_ANQUAN(1),
	//美食
	MEISHI(2),
	//视频
	SHIPIN(3),
	//美食家
	MEISHI_JIA(4),
	//水果
	SHUIGUO(5);
	
	private int type;
	
	private MoKuaiLeiXinEnum(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
