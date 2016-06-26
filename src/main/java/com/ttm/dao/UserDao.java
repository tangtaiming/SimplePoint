package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.User;

/**
 * 
 * <p>介绍 用户实体</p>
 * @author 唐太明
 * @date 2016年6月26日 上午12:24:27
 * @version 1.0
 */
public interface UserDao {

	/**
	 * 多条件查询数据
	 * @param account
	 * @param password
	 * @return
	 */
	public abstract List<User> findUser(Map<String, Object> query, Map<String, Integer> paging, Map<String, Object> sort);
	
}
