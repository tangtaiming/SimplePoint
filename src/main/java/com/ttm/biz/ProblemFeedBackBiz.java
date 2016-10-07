package com.ttm.biz;

import java.util.List;

import com.ttm.orm.ProblemFeedBack;

/**
 * 
 * <p>
 * 介绍 问题反馈业务处理层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年7月5日 下午11:11:13
 * @version 1.0
 */
public interface ProblemFeedBackBiz {

	/**
	 * 保存/修改
	 * @param problemFeedBack
	 * @return
	 */
	public abstract boolean saveOrUpdateProblemFeedBack(ProblemFeedBack problemFeedBack);
	
	/**
	 * id删除 反馈问题
	 * @param id
	 * @return
	 */
	public abstract boolean deleteProblemFeedBack(Integer id);
	
	
}
