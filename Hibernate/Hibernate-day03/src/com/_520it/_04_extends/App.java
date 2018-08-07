package com._520it._04_extends;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	@Before
	public void testSave() throws Exception {
		User u = new User();
		u.setName("普通用户");
		
		Employee e = new Employee();
		e.setName("员工");
		e.setSalary(new BigDecimal("800"));
		
		Customer c = new Customer();
		c.setName("客户");
		c.setAddress("天河区");
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(u);
		session.save(e);
		session.save(c);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		
		User u = (User) session.get(User.class, 1L);
		Customer c = (Customer) session.get(Customer.class, 3L);
		
		session.close();
	}
}
