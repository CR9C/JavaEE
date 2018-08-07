package com._520it._01_crud;

import static org.junit.Assert.*;

import java.io.DataOutput;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com._520it._01_crud.dao.IUserDAO;
import com._520it._01_crud.dao.impl.UserDAOImpl;
import com._520it._01_crud.domain.User;
import com._520it.util.HibernateUtil;

public class App {
	
	private IUserDAO dao = new UserDAOImpl();
	
	@Test
	public void test() throws Exception {
		//创建Session对象,先创建SessionFactory对象
		Session session = HibernateUtil.getSession();
		
		session.getSessionFactory().close();
	}
	@Test
	public void testSave() {
		User u = dao.get(1L);
		u.setName("xxx");
		dao.save(u);
	}

	@Test
	public void testDelete() {
		dao.delete(4L);
	}

	@Test
	public void testUpdate() {
		User u = dao.get(4L);
		u.setName("yyy");
		dao.update(u);
	}

	@Test
	public void testGet() {
		User u = dao.get(1L);
		System.out.println(u);
	}

	@Test
	public void testListAll() {
		List<User> us = dao.listAll();
		for (User u : us) {
			System.out.println(u);
		}
	}

}
