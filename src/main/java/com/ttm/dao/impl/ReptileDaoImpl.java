package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.ReptileDao;
import com.ttm.orm.Reptile;

/**
 * 
 * <p>介绍：学校 数据层实现类</p>
 * @author 唐太明
 * @date 2016年3月28日 下午11:09:13
 * @version 1.0
 */
public class ReptileDaoImpl implements ReptileDao {

	private MySqlDataFactory factory = new MySqlDataFactory();
	
	public boolean addReptile(Reptile reptile) {
		return factory.save(Reptile.class, reptile);
	}

	public boolean deleteReptile(Reptile reptile) {
		return factory.delete(Reptile.class, reptile);
	}

	public Reptile findReptileById(Integer id) {
		return (Reptile) factory.findById(Reptile.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Reptile> findReptileByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<Reptile>) factory.findToListLimit(Reptile.class, query, sort, pageing);
	}

}
