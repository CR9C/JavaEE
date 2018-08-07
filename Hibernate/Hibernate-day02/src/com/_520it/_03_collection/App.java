package com._520it._03_collection;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	@Test
	public void testSave() throws Exception {
		User u = new User();
		u.setName("乔峰");
		u.setAge(25);
		u.getEmailSet().add("A@xx.com");
		u.getEmailSet().add("B@xx.com");
		u.getEmailSet().add("C@xx.com");
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
	}
}
