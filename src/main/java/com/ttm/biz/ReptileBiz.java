package com.ttm.biz;

import java.util.List;

import com.ttm.orm.Reptile;

public interface ReptileBiz {
	
	/**
	 * 保存一条url地址数据
	 * 
	 * @param school
	 * @param creatdId
	 * @param creatDate
	 * @return
	 */
	public abstract boolean saveReptile(Reptile reptile, Integer creatdId, String creatDate);

	/**
	 * 删除一条url地址数据
	 * 
	 * @param id
	 *            学校id
	 * @return
	 */
	public abstract boolean deleteReptile(Integer id);

	/**
	 * 分页查询url地址数据
	 * 
	 * @param page
	 *            当前页
	 * @param size
	 *            每页显示数量
	 * @return
	 */
	public abstract List<Reptile> findReptileList(Integer page, Integer size);

	/**
	 * 计算数量
	 * 
	 * @param Integer
	 *            数量
	 * @return
	 */
	public abstract Integer countReptileNumber();
	
	/**
	 * id 查询对象
	 * @param id
	 * @return
	 */
	public abstract Reptile findReptile(Integer id);
	
}
