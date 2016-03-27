package com.ttm.biz.impl;

import java.util.List;
import java.util.Map;

import com.ttm.biz.SchoolBiz;
import com.ttm.dao.SchoolDao;
import com.ttm.dao.impl.SchoolDaoImpl;
import com.ttm.orm.School;
import com.ttm.util.Dumper;
import com.ttm.util.ServicePaginationHelper;

public class SchoolBizImpl implements SchoolBiz {

	private SchoolDao schoolDao = new SchoolDaoImpl();
	
	public boolean saveSchool(School school, Integer creatdId, String creatdDate) {
		//设置值
		school.setCreatdId(creatdId);
		school.setCreatdDate(creatdDate);
		System.out.println("准备添加学校数据....");
		Dumper.dump(school);
		return schoolDao.addSchool(school);
	}

	public List<School> findSchoolList(Integer page, Integer size) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		return schoolDao.findSchoolByList(pageing);
	}

	public boolean deleteSchool(Integer id) {
		School school = schoolDao.findSchoolById(id);
		if (school != null) {
			return schoolDao.deleteSchool(school);
		};
		return false;
	}

}
