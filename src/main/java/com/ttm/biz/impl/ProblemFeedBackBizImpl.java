package com.ttm.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.assertj.core.error.ErrorMessageFactory;

import com.ttm.biz.ProblemFeedBackBiz;
import com.ttm.dao.ProblemFeedBackDao;
import com.ttm.dao.impl.ProblemFeedBackDaoImpl;
import com.ttm.orm.ProblemFeedBack;
import com.ttm.service.ServiceResponse;
import com.ttm.service.ServiceResponseCode;
import com.ttm.util.ParamsUtils;

public class ProblemFeedBackBizImpl implements ProblemFeedBackBiz {

	private ProblemFeedBackDao problemFeedBackDao = new ProblemFeedBackDaoImpl();

	private String errorMessage;
	
	public boolean saveOrUpdateProblemFeedBack(ProblemFeedBack problemFeedBack) {
		if (problemFeedBack.getId() == null || problemFeedBack.getId() < 0) {
			if (StringUtils.isEmpty(problemFeedBack.getName().trim()) || problemFeedBack.getName().equals(ParamsUtils.NAME)) {
				errorMessage = "名字不能为空";
			} else if (StringUtils.isEmpty(problemFeedBack.getEmail().trim()) || problemFeedBack.getEmail().equals(ParamsUtils.EMAIL)) {
				errorMessage = "邮箱不能为空";
			} else if (StringUtils.isEmpty(problemFeedBack.getTheme().trim()) || problemFeedBack.getTheme().equals(ParamsUtils.THEME)) {
				errorMessage = "主题不能为空";
			} else if (StringUtils.isEmpty(problemFeedBack.getThemeContent().trim()) || problemFeedBack.getThemeContent().equals(ParamsUtils.PROBLEM)) {
				errorMessage = "主题内容不能为空";
			} else {
				errorMessage = null;
			}
			
			if (errorMessage != null) {
				return false;
			}
			
			// 保存
			SimpleDateFormat format = new SimpleDateFormat(ParamsUtils.DATEDEFAULT);
			String createdDate = format.format(new Date());
			problemFeedBack.setCreatedDate(createdDate);
			
			if (!problemFeedBackDao.addProblemFeedBack(problemFeedBack)) {
				errorMessage = "保存数据库失败";
				return false;
			}
		} else {
			// 编辑
		}
		return true;
	}

	/**
	 * 验证值的可用性
	 * 
	 * @param problemFeedBack
	 */
	private void verificationSaveOrUpdateProblemFeedBack(ProblemFeedBack problemFeedBack) {
		String name = problemFeedBack.getName();
		String email = problemFeedBack.getEmail();
	}

	public boolean deleteProblemFeedBack(Integer id) {
		return false;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
