package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MeiShiJiaDao;
import com.ttm.dao.MySqlDataFactory;
import com.ttm.orm.MeiShiJia;

/**
 * 
 * <p>
 * 介绍：美食家数据层实现类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月17日 下午12:30:50
 * @version 1.0
 */
public class MeiShiJiaDaoImpl implements MeiShiJiaDao {

	private MySqlDataFactory factory = new MySqlDataFactory();

	public boolean addMeiShiJia(MeiShiJia meiShiJia) {
		return factory.save(MeiShiJia.class, meiShiJia);
	}

	public boolean updateMeiShiJia(MeiShiJia meiShiJia) {
		return factory.update(MeiShiJia.class, meiShiJia);
	}

	public MeiShiJia findMeiShiJiaById(Integer id) {
		return (MeiShiJia) factory.findById(MeiShiJia.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<MeiShiJia> findMeiShiJiaByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<MeiShiJia>) factory.findToListLimit(MeiShiJia.class, query, sort, pageing);
	}

}
