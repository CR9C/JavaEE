package com._520it._03_mapping;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	@Before
	public void save() throws Exception {
		Employee e = new Employee();
		e.setLastname("James");
		e.setFirstname("LeBron");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		Employee e = (Employee) session.get(Employee.class, 1L);
		session.close();
		System.out.println(e);
		//用的是create方式,重新运行又要创建表,删除表,表中没有数据,要做查询得先执行save,在运行get之前先执行before,数据先保存进数据库在查询出来
	}
}
