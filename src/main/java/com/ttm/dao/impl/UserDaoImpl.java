package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.UserDao;
import com.ttm.orm.User;
/**
 * 
 * <p>介绍 用户数据处理实现</p>
 * @author 唐太明
 * @date 2016年6月26日 上午12:31:02
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {
	
	private MySqlDataFactory factory = new MySqlDataFactory();

	@SuppressWarnings("unchecked")
	public List<User> findUser(Map<String, Object> query, Map<String, Integer> paging, Map<String, Object> sort) {
		return (List<User>) factory.findToListLimit(User.class, query, sort, paging);
	}

}
