package com.ttm.dao.impl;

import java.util.List;
import java.util.Map;

import com.ttm.dao.MySqlDataFactory;
import com.ttm.dao.SchoolDao;
import com.ttm.orm.School;

@SuppressWarnings("unchecked")
public class SchoolDaoImpl implements SchoolDao {
	
	private MySqlDataFactory factory = new MySqlDataFactory();
	
	public boolean addSchool(School school) {
		return factory.save(School.class, school);
	}

	public School findSchoolById(Integer id) {
		return (School) factory.findById(School.class, id);
	}

	
	public List<School> findSchoolByList(Map<String, Integer> pageing) {
		return (List<School>) factory.findToListLimit(School.class, null, null, pageing);
	}

	public boolean deleteSchool(School school) {
		return factory.delete(School.class, school);
	}

	public List<School> findSchoolByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing) {
		return (List<School>) factory.findToListLimit(School.class, query, sort, pageing);
	}

}
