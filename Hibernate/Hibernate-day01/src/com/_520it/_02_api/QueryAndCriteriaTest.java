package com._520it._02_api;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.DelayQueue;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com._520it._01_crud.domain.User;
import com._520it.util.HibernateUtil;

public class QueryAndCriteriaTest {
	@Test
	public void testSave() throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		for (int i = 0; i < 13; i++) {
			User u = new User();
			u.setName("test_"+i);
			session.save(u);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	//需求:查询名字中包含test,且id在1-10之间的
	//Query
	@Test
	public void testQuery() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT u FROM User u WHERE u.name LIKE ? AND u.id BETWEEN ? AND ?";
		Query query = session.createQuery(hql);
		//Java中从0开始,JDBC,JPA从1开始.都是SUN公司操作数据库的规范
		//设置占位符(支持链式编程)
		query.setParameter(0, "%test%").setParameter(1, 1L).setParameter(2, 10L);
		List<User> us = query.list();//查询操作
		session.close();
		for (User u : us) {
			System.out.println(u);
		}
	}
	
	//Criteria(知道存在即可,不用)
	@Test
	public void testCriteria() throws Exception {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.like("name", "test", MatchMode.ANYWHERE));
		criteria.add(Restrictions.between("id", 1L, 10L));
		List<User> us = criteria.list();//查询操作
		session.close();
		for (User u : us) {
			System.out.println(u);
		}
	}
}
