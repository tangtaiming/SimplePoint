package com.ttm.biz;

import com.ttm.orm.User;

/**
 * 
 * <p>介绍 用户业务层</p>
 * @author 唐太明
 * @date 2016年6月26日 上午1:03:28
 * @version 1.0
 */
public interface UserBiz {

	/**
	 * 账号密码查询数据
	 * @param account
	 * @param passwor
	 * @return
	 */
	public abstract User login(String account, String passwor);
	
}
