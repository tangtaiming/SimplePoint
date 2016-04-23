package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.SafetyDao;
import com.ttm.orm.Safety;

public class SafetyDaoImpl implements SafetyDao {

	private MySqlDataFactory factory = new MySqlDataFactory();
	
	public boolean addSafety(Safety safety) {
		return factory.save(Safety.class, safety);
	}

	public boolean updateSafety(Safety safety) {
		return factory.update(Safety.class, safety);
	}

	public Safety findSafetyById(Integer id) {
		return (Safety) factory.findById(Safety.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Safety> findSafetyByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<Safety>) factory.findToListLimit(Safety.class, query, sort, pageing);
	}

	public boolean deleteSafety(Safety safety) {
		return factory.delete(Safety.class, safety);
	}

}
