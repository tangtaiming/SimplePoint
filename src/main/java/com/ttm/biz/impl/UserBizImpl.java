package com.ttm.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.ttm.biz.UserBiz;
import com.ttm.dao.UserDao;
import com.ttm.dao.impl.UserDaoImpl;
import com.ttm.orm.User;
import com.ttm.util.Dumper;
import com.ttm.util.Md5;
import com.ttm.util.ParamsUtils;
import com.ttm.util.ServiceQueryHelper;

/**
 * 
 * <p>介绍 用户业务层实现层</p>
 * @author 唐太明
 * @date 2016年6月26日 上午1:05:13
 * @version 1.0
 */
public class UserBizImpl implements UserBiz {

	private Logger logger = Logger.getLogger(UserBizImpl.class);
	
	private UserDao userDao = new UserDaoImpl();
	
	public User login(String account, String passwor) {
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "account", account);
		ServiceQueryHelper.and(query, "password", Md5.getEncode(passwor));
		Dumper.dump(query);
		List<User> users = userDao.findUser(query, null, null);
		if (CollectionUtils.isNotEmpty(users)) {
			return users.get(ParamsUtils.NUMBERZERO);
		} else {
			logger.info("查询用户数据为空...");
		}
		return null;
	}

}
