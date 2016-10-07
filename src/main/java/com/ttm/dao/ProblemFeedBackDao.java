package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.ProblemFeedBack;

/**
 * 
 * <p>介绍 问题反馈 数据处理</p>
 * @author 唐太明
 * @date 2016年7月4日 下午11:58:42
 * @version 1.0
 */
public interface ProblemFeedBackDao {

	/**
	 * 保存问题反馈问题
	 * @param problemFeedBack
	 * @return
	 */
	public abstract boolean addProblemFeedBack(ProblemFeedBack problemFeedBack);
	
	/**
	 * 条件查询问题反馈
	 * @param query
	 * @param pageing
	 * @param sort
	 * @return
	 */
	public abstract List<ProblemFeedBack> findProblemFeedBackList(Map<String, Object> query, Map<String, Integer> pageing, Map<String, Object> sort);
	
	/**
	 * 修改问题反馈
	 * @param problemFeedBack
	 * @return
	 */
	public abstract boolean updateProblemFeedBack(ProblemFeedBack problemFeedBack);
	
	/**
	 * 删除问题反馈
	 * @param id
	 * @return
	 */
	public abstract boolean deleteProblemFeedBack(ProblemFeedBack problemFeedBack);
}
