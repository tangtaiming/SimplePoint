package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.ProblemFeedBackDao;
import com.ttm.orm.ProblemFeedBack;

/**
 * 
 * <p>介绍 问题反馈 数据处理实现</p>
 * @author 唐太明
 * @date 2016年7月5日 下午11:01:07
 * @version 1.0
 */
public class ProblemFeedBackDaoImpl implements ProblemFeedBackDao {

	private MySqlDataFactory factory = new MySqlDataFactory();
	
	public boolean addProblemFeedBack(ProblemFeedBack problemFeedBack) {
		return factory.save(ProblemFeedBack.class, problemFeedBack);
	}

	@SuppressWarnings("unchecked")
	public List<ProblemFeedBack> findProblemFeedBackList(Map<String, Object> query, Map<String, Integer> pageing,
			Map<String, Object> sort) {
		return (List<ProblemFeedBack>) factory.findToListLimit(ProblemFeedBack.class, query, sort, pageing);
	}

	public boolean updateProblemFeedBack(ProblemFeedBack problemFeedBack) {
		return factory.update(ProblemFeedBack.class, problemFeedBack);
	}

	public boolean deleteProblemFeedBack(ProblemFeedBack problemFeedBack) {
		return factory.delete(ProblemFeedBack.class, problemFeedBack);
	}

}
