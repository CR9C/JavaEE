package com._520it._02_cascade;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.engine.HibernateIterator;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	@Before
	public void testSave() throws Exception {
		SaleBill bill = new SaleBill();
		bill.setSn("001");
		bill.setVdate(new Date());
		
		SaleBillItem item1 = new SaleBillItem();
		item1.setProduct("泡椒凤爪");
		//用字符串的构造器才能表示精确
		item1.setNumber(new BigDecimal("2"));
		
		SaleBillItem item2 = new SaleBillItem();
		item2.setProduct("啤酒");
		item2.setNumber(new BigDecimal("10"));

		SaleBillItem item3 = new SaleBillItem();
		item3.setProduct("花生米");
		item3.setNumber(new BigDecimal("4"));
		
		bill.getItems().add(item1);
		bill.getItems().add(item2);
		bill.getItems().add(item3);
		
		item1.setBill(bill);
		item2.setBill(bill);
		item3.setBill(bill);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(bill);
		session.save(item1);
		session.save(item2);
		session.save(item3);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		SaleBill bill = (SaleBill) session.get(SaleBill.class, 1L);
		session.delete(bill);
		
		session.getTransaction().commit();
		session.close();
	}
}
