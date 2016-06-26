package com.ttm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ttm.dao.DataRegistry;
import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.StoreDao;
import com.ttm.enums.SortStatuseEnum;
import com.ttm.enums.StoreEnum;
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
					boolean isTrue = false;
					for (StoreEnum val : StoreEnum.values()) {
						if (StringUtils.equals(val.getStoreName(), value)) {
							isTrue = true;
							break;
						}
					}
					if (isTrue) {
						if (value.equals("desc")) {
							criteria.addOrder(Order.desc(key));
						} else {
							criteria.addOrder(Order.asc(key));
						}
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
	
	@SuppressWarnings("unchecked")
	public List<Store> findStoreSearch(String sea, Integer schoolId, Integer page, Integer size) {
		List<Store> list = new ArrayList<Store>();
		SessionFactory sf = DataRegistry.getSessionFactory();
		Session session = null;
		
		try {
			session = sf.openSession();	
			Criteria criteria = session.createCriteria(Store.class);
			if (StringUtils.isNotEmpty(sea)) {
				criteria.add(Restrictions.like("name", "%" + sea + "%"));
			}
			criteria.add(Restrictions.eq("schoolId.id", schoolId));
			criteria.setFirstResult(page);
			criteria.setMaxResults(size);
			list = criteria.list();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Store> findStoreListMore(String params, String sort, Integer page, Integer size) {
		StringBuffer hql = new StringBuffer();
		hql.append("select ");
		hql.append("this_.id as id1_4_0_,");
		hql.append("this_.name as name2_4_0_,");
		hql.append("this_.storeId as storeId3_4_0_,");
		hql.append("this_.reviewScores as reviewSc4_4_0_,");
		hql.append("this_.salesQuantity as salesQua5_4_0_,");
		hql.append("this_.salesAllQuantity as salesAll6_4_0_,");
		hql.append("this_.sendThePrice as sendTheP7_4_0_,");
		hql.append("this_.distributionCost as distribu8_4_0_,");
		hql.append("this_.shopHours as shopHour9_4_0_,");
		hql.append("this_.shoprReach as shoprRe10_4_0_,");
		hql.append("this_.collectQuantity as collect11_4_0_,");
		hql.append("this_.businessDate as busines12_4_0_,");
		hql.append("this_.address as address13_4_0_,");
		hql.append("this_.phone as phone14_4_0_,");
		hql.append("this_.url as url15_4_0_,");
		hql.append("this_.status as status16_4_0_,");
		hql.append("this_.sortTypeId as sortTyp17_4_0_,");
		hql.append("this_.firstOrder as firstOr18_4_0_,");
		hql.append("this_.minusExempt as minusEx19_4_0_,,");
		hql.append("this_.give as give20_4_0_,");
		hql.append("this_.creatdId as creatdI21_4_0_,");
		hql.append("this_.creatdDate as creatdD22_4_0_,");
		hql.append("this_.updateDate as updateD23_4_0_,");
		hql.append("this_.schoolId as schoolI24_4_0_ ");
		hql.append("from ");
		hql.append("my_wxy.store this_ ");
		hql.append("where ");
		hql.append(params + " ");
		hql.append("order by this_." + sort + " desc ");
		hql.append("limit " + page + ", " + size);
		System.out.println(hql.toString());
		return null;
	}

}
