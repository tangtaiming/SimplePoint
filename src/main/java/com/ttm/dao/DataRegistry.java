package com.ttm.dao;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataRegistry {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
	
	public static SessionFactory getSessionFactory() {
		return ac.getBean("sessionFactory", SessionFactory.class);
	}

}
