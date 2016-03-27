package com.ttm.dao;

import com.ttm.orm.Reptile;

public interface ReptileDao {

	/**
	 * 添加
	 * @param reptile
	 * @return
	 */
	public abstract boolean addReptile(Reptile reptile);
	
	public abstract Reptile findReptileById(Integer id);
	
}
