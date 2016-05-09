package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.PreferentialDao;
import com.ttm.orm.Preferential;

/**
 * 
 * <p>
 * 介绍:优惠模块数据实现类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月2日 下午8:39:17
 * @version 1.0
 */
public class PreferentialDaoImpl implements PreferentialDao {

	private MySqlDataFactory factory = new MySqlDataFactory();

	public boolean addPreferential(Preferential preferential) {
		return factory.save(Preferential.class, preferential);
	}

	public boolean updatePreferential(Preferential preferential) {
		return factory.update(Preferential.class, preferential);
	}

	@SuppressWarnings("unchecked")
	public List<Preferential> findPreferentialByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<Preferential>) factory.findToListLimit(Preferential.class, query, sort, pageing);
	}

	public Preferential findPreferentialById(Integer id) {
		return (Preferential) factory.findById(Preferential.class, id);
	}

	public boolean deletePreferential(Preferential preferential) {
		return factory.delete(Preferential.class, preferential);
	}

}
