package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.ShiPinDao;
import com.ttm.orm.ShiPin;

public class ShiPinDaoImpl implements ShiPinDao {
	
	private MySqlDataFactory factory = new MySqlDataFactory();

	public boolean addShiPin(ShiPin shiPin) {
		return factory.save(ShiPin.class, shiPin);
	}

	public boolean updateShiPin(ShiPin shiPin) {
		return factory.update(ShiPin.class, shiPin);
	}

	public ShiPin findShiPinById(Integer id) {
		return (ShiPin) factory.findById(ShiPin.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ShiPin> findShiPinByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<ShiPin>) factory.findToListLimit(ShiPin.class, query, sort, pageing);
	}

}
