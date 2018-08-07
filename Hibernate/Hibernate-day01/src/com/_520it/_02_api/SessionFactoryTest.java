package com._520it._02_api;

import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import com._520it._01_crud.domain.User;
import com._520it.util.HibernateUtil;

public class SessionFactoryTest {
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User u = (User) session.get(User.class, 1L);
		session.getTransaction().commit();//底层会关闭session
		
		System.out.println(u);
	}
}
