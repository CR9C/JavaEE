package com._520it._05_one2many;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	/*
	 * one2many时:many方即便知道外键,也不会去维护关系
	 * 所以最后由one方再额外发送两条SQL来维护外键
	 * 
	 先保存one方,再保存many方:
	Hibernate: insert into Department (name) values (?)
	Hibernate: insert into Employee (name) values (?)
	Hibernate: insert into Employee (name) values (?)
	Hibernate: update Employee set dept_id=? where id=?
	Hibernate: update Employee set dept_id=? where id=?
	先保存many方,再保存one方:
	Hibernate: insert into Employee (name) values (?)
	Hibernate: insert into Employee (name) values (?)
	Hibernate: insert into Department (name) values (?)
	Hibernate: update Employee set dept_id=? where id=?
	Hibernate: update Employee set dept_id=? where id=?
	 */
	@Before
	public void testSave() throws Exception {
		Employee e1 = new Employee();
		e1.setName("张三");
		Employee e2 = new Employee();
		e2.setName("李四");
		
		Department dept = new Department();
		dept.setName("开发部");
		
		//维护关系
		dept.getEmps().add(e1);
		dept.getEmps().add(e2);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(dept);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}
	
	/*
	1:通过one方获取many方,使用了延迟加载.
	2:one方的many方的属性是一个集合,必须使用接口来声明.
	3:不能通过if-null来判断one方是否有many方,只能通过size方法来判断.
	不能使用if-null来做判断,因为返回的是一个集合.使他自己生产一个代理对象PersisterBag.这个集合不为空,仅仅只是没有元素
	4:必须在session关闭之前使用集合对象,否则报错:no session.
	 */
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		
		Department d = (Department) session.get(Department.class, 1L);
		System.out.println(d);
		System.out.println(d.getEmps().getClass());
//		if (d.getEmps() == null) {
		//单个元素用if-null,集合来判断元素个数
		if (d.getEmps().size() == 0) {
			System.out.println("没有员工");
		} else {
			System.out.println("有员工");
		}
		d.getEmps().size();
		session.close();
	}
}
