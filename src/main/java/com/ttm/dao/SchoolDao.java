package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.School;

/**
 * 
 * <p>
 * 介绍：学校 数据层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月26日 上午12:12:39
 * @version 1.0
 */
public interface SchoolDao {

	/**
	 * 添加学校数据
	 * 
	 * @param school
	 * @return
	 */
	public abstract boolean addSchool(School school);

	/**
	 * 删除学校数据
	 * 
	 * @param id
	 * @return
	 */
	public abstract boolean deleteSchool(School school);

	/**
	 * ID查询学校数据
	 * 
	 * @param id
	 * @return
	 */
	public abstract School findSchoolById(Integer id);

	/**
	 * 分页查询数据
	 * 
	 * @param paging
	 * @return
	 */
	public abstract List<School> findSchoolByList(Map<String, Integer> paging);

	/**
	 * 分页条件排序查询
	 * 
	 * @param query
	 * @return
	 */
	public abstract List<School> findSchoolByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing);

}
