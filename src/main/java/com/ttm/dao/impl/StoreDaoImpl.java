package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.StoreDao;
import com.ttm.orm.Store;

public class StoreDaoImpl implements StoreDao {
	
	private MySqlDataFactory factory = new MySqlDataFactory();

	public boolean saveStore(Store store) {
		return factory.save(Store.class, store);
	}

	public boolean updateStore(Store store) {
		return factory.update(Store.class, store);
	}

	public boolean deleteStore(Store store) {
		return factory.delete(Store.class, store);
	}

	public Store findStoreById(Map<String, Object> query) {
		return (Store) factory.find(Store.class, query);
	}

	@SuppressWarnings("unchecked")
	public List<Store> findStoreByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<Store>) factory.findToListLimit(Store.class, query, sort, pageing);
	}

	public Store findStoreById(Integer id) {
		return (Store) factory.findById(Store.class, id);
	}

}
