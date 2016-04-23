package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.ShuiGuoDao;
import com.ttm.orm.ShuiGuo;

/**
 * 
 * <p>
 * 介绍：水果数据处理层实现
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月17日 下午3:04:42
 * @version 1.0
 */
public class ShuiGuoDaoImpl implements ShuiGuoDao {

	private MySqlDataFactory factory = new MySqlDataFactory();

	public boolean addShuiGuo(ShuiGuo shuiGuo) {
		return factory.save(ShuiGuo.class, shuiGuo);
	}

	public boolean updateShuiGuo(ShuiGuo shuiGuo) {
		return factory.update(ShuiGuo.class, shuiGuo);
	}

	public ShuiGuo findShuiGuoById(Integer id) {
		return (ShuiGuo) factory.findById(ShuiGuo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ShuiGuo> findShuiGuoByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<ShuiGuo>) factory.findToListLimit(ShuiGuo.class, query, sort, pageing);
	}

	public boolean deleteShuiGuo(ShuiGuo shuiGuo) {
		return factory.delete(ShuiGuo.class, shuiGuo);
	}

}
