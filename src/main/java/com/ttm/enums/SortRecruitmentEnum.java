package com.ttm.enums;

/**
 * <p>
 * 介绍 店铺兼职
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月21日下午1:16:28
 * @version 1.0
 */
public enum SortRecruitmentEnum {

	RECRUITMENT_TWO(0, "没有"), // 没有兼职
	RECRUITMENT_ONE(1, "有"); // 有兼职
	

	private int recruitment;

	private String recruitmentName;

	private SortRecruitmentEnum(int recruitment, String recruitmentName) {
		this.recruitment = recruitment;
		this.recruitmentName = recruitmentName;
	}

	public int getRecruitment() {
		return recruitment;
	}

	public String getRecruitmentName() {
		return recruitmentName;
	}

}
