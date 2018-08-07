package com._520it._02_object_state;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

//对象的状态
public class ObjectStateTest {
	/*
	 * Transient(临时状态/瞬时状态):特点,没有OID,不被Session所管理. 
	 * 情况1):new语句刚创建了一个对象.
	 * 情况2):删除状态的对象,在事务提交之后,对象处于临时状态. 临时状态是没有ID的,测试可以打印该对象的ID,发现存在ID.
	 * --->设置hibernate.cfg.xml的属性:hibernate.use_identifier_rollback=true
	 */
	@Test
	public void testTransient() throws Exception {
		Person p = new Person();
		p.setName("乔峰");
		//上述对象p,处于临时状态
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(p);//把临时状态转换为持久化状态
		//此时p对象处于持久化状态,在一级缓存中
		session.get(Person.class, 1L);//没有发送SELECT语句:Person#1
		System.out.println("---------------");
		session.getTransaction().commit();
		session.close();
	}
	
	/*
	 * Persistent(持久化状态):特点:有OID,被Session所管理. 
	 * 情况1):save方法把临时状态转换为持久化状态.
	 * 情况2):save方法把游离对象变成另一个持久化状态.
	 * 保存一个对象之后,提交事务/关闭Session,此时对象处于游离状态,再创建新的Session来保存该对象.
	 * 情况3):get和load方法返回的是持久化对象.
	 * 情况4):Query.list方法返回的是持久化对象,在处理大数据量的时候,需要及时清理一级缓存(分页查询).
	 * 情况5):update方法把游离对象变成持久化对象.
	 */
	@Test
	public void testPersistent() throws Exception {
		Person p = new Person();
		p.setName("乔峰");
		//上述对象p,处于临时状态
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(p);
		//此时p对象处于持久化状态.在一级缓存中
		session.get(Person.class, 1L);//没有发送SELECT语句:Person#1
		session.getTransaction().commit();
		session.close();///一级缓存就销毁了
		//此时p有OID,但是不在一级缓存中-->游离状态
	}
	
	@Test
	public void testRemoved() throws Exception {
		Person p = new Person();
		p.setId(1L);
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.delete(p);
		System.out.println("------------");
		session.getTransaction().commit();
		//此时p处于临时状态
		System.out.println(p.getId());
		session.close();
	}
	
	/**
	 * Detached(游离状态/托管状态):特点:有OID,但是不被Session所管理(不在一级缓存中).
		情况1):session.close()方法把所有的持久化对象变成游离对象.
		情况2):session.clear()方法把所有持久化对象变成游离对象.
		情况3):session.evivt(Object)方法把制定的持久化对象变成游离对象.
		情况4):使用new创建对象,并设置OID(数据库存在该ID);
	 */
	@Test
	public void testDetached() throws Exception {
		Person p = new Person();//临时状态;没有OID,不在一级缓存中
		p.setId(1L);//游离状态;有OID,不在一级缓存
	}
}
