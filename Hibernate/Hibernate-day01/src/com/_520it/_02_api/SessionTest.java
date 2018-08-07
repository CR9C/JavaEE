package com._520it._02_api;

import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import com._520it._01_crud.domain.User;
import com._520it.util.HibernateUtil;

public class SessionTest {
	//测试一级缓存
	@Test
	public void testFistLevelCache() throws Exception {
		Session session = HibernateUtil.getSession();
		User u = (User)session.get(User.class, 1L);
		//session.clear();//清空一级缓存,一级缓存中所有的 对象不复存在
		session.evict(u);//从一级缓存中,清除指定的一个对象
		session.get(User.class, 1L);
		session.close();
	}
}
