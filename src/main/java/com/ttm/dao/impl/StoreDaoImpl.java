package com.ttm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.ArrayUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ttm.dao.DataRegistry;
import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.StoreDao;
import com.ttm.orm.Store;
import com.ttm.util.Dumper;

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
	
	public static void main(String[] args) {
//		Criterion criterion = Restrictions.eq("", "");
//		Criteria criteria = 
		StoreDao sd = new StoreDaoImpl();
		
		Dumper.dump(sd.findStoreLianGeTiaoJianChaXun(null, null, null));
	}

	@SuppressWarnings("unchecked")
	public List<Store> findStoreLianGeTiaoJianChaXun(List<Criterion> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		Criteria criteria = null;
		List<Store> list = null;
		
		try {
			session = sf.openSession();
			criteria = session.createCriteria(Store.class);
			//获取条件存储查询条件
			if (!(query == null || query.isEmpty())) {
				for (Criterion c : query) {
					criteria.add(c);
				}
			}
			//分页条件
			if (!(pageing == null || pageing.isEmpty())) {
				int pageNumber = (pageing.get("page") - 1) * pageing.get("size");
				criteria.setFirstResult(pageNumber);
				criteria.setMaxResults(pageing.get("size"));
			}
			//排序条件
			if (!(sort == null || sort.isEmpty())) {
				for (String key : sort.keySet()) {
					String value = (String) sort.get(key);
					if (value.equals("desc")) {
						criteria.addOrder(Order.desc(key));
					} else {
						criteria.addOrder(Order.asc(key));
					}
				}
			}
			
			list = criteria.list();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return (List<Store>) list;
	}

}
