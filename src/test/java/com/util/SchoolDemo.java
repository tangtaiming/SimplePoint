package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ttm.biz.SchoolBiz;
import com.ttm.orm.School;

public class SchoolDemo {

	@Test
	public void addSchool() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
//		SchoolDao schoolDao = (SchoolDao) ac.getBean("schoolDao");
		School school = new School();
		school.setName("湖南工学院");
		school.setCode(102345);
//		school.setCreatdId(1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		school.setCreatdDate(format.format(new Date()));
//		Dumper.dump(school);
//		Dumper.dump(schoolDao.addSchool(school));
//		Dumper.dump(schoolDao.findSchoolById(6));
		
		SchoolBiz schoolBiz = (SchoolBiz) ac.getBean("schoolBiz");
		System.out.println(schoolBiz.saveSchool(school, 1, format.format(new Date())));
	}
	
}
