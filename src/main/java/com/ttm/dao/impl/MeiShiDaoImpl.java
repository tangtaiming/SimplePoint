package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MeiShiDao;
import com.ttm.dao.MySqlDataFactory;
import com.ttm.orm.MeiShi;

/**
 * 
 * <p>
 * 介绍:美食数据访问层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月7日 下午3:38:52
 * @version 1.0
 */
public class MeiShiDaoImpl implements MeiShiDao {
	
	private MySqlDataFactory factory = new MySqlDataFactory();

	public boolean addMeiShi(MeiShi meiShi) {
		return factory.save(MeiShi.class, meiShi);
	}

	public boolean updateMeiShi(MeiShi meiShi) {
		return factory.update(MeiShi.class, meiShi);
	}

	public MeiShi findMeiShiById(Integer id) {
		return (MeiShi) factory.findById(MeiShi.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<MeiShi> findMeiShiByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<MeiShi>) factory.findToListLimit(MeiShi.class, query, sort, pageing);
	}

	public boolean deleteMeiShi(MeiShi meishi) {
		return factory.delete(MeiShi.class, meishi);
	}


}
