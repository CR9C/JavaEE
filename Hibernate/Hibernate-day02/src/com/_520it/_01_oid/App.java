package com._520it._01_oid;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	@Before
	public void testSave() throws Exception {
		User u = new User();
		u.setName("乔峰");
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
	}
	
	//加载或查询指定类型和OID的一个对象:查询ID为1的User对象
	@Test
	public void testGet_load() throws Exception {
		Session session = HibernateUtil.getSession();
		User u = null;
		u = (User) session.get(User.class, 2L);
		System.out.println("----------------");
		if (u == null) {
			System.out.println("没有这个对象");
		}
		System.out.println(u.getName());
		session.close();
	}
	

}
