package com.ttm.biz;

import java.util.List;

import com.ttm.orm.School;

/**
 * 
 * <p>介绍:业务层</p>
 * @author 唐太明
 * @date 2016年3月26日 下午4:33:55
 * @version 1.0
 */
public interface SchoolBiz {

	/**
	 * 保存一条学校数据
	 * @param school
	 * @param creatdId
	 * @param creatDate
	 * @return
	 */
	public abstract boolean saveSchool(School school, Integer creatdId, String creatDate);
	
	/**
	 * 删除一条学校数据
	 * @param id 学校id
	 * @return
	 */
	public abstract boolean deleteSchool(Integer id);
	
	/**
	 * 分页查询学校数据
	 * @param page 当前页
	 * @param size 每页显示数量
	 * @return
	 */
	public abstract List<School> findSchoolList(Integer page, Integer size);
	
	/**
	 * 计算数量
	 * @param Integer 数量
	 * @return
	 */
	public abstract Integer countSchoolNumber();

	/**
	 * 排序查询学校所有数据
	 * @param sortValue 
	 * @return
	 */
	public abstract List<School> findSchoolList(String sortName, String sortValue);
	
	/**
	 * id 查询学校信息
	 * @param id
	 * @return
	 */
	public abstract School findSchoolById(Integer id);
	
}
