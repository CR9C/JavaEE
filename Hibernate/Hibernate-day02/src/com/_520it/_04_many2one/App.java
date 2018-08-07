package com._520it._04_many2one;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	/*
	 先保存one方,再保存many方:
	Hibernate: insert into Department (name) values (?)
	Hibernate: insert into Employee (name, dept_id) values (?, ?)
	Hibernate: insert into Employee (name, dept_id) values (?, ?)
	
	先保存many方,再保存one方:
	Hibernate: insert into Employee (name, dept_id) values (?, ?)
	Hibernate: insert into Employee (name, dept_id) values (?, ?)
	Hibernate: insert into Department (name) values (?)---->dept_id有值
	Hibernate: update Employee set name=?, dept_id=? where id=?
	Hibernate: update Employee set name=?, dept_id=? where id=?
	
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
		e1.setDept(dept);
		e2.setDept(dept);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(dept);
		
		session.getTransaction().commit();
		session.close();
	}
	
	//1:many方获取one方的时候,使用了延迟加载.
 	//2:可以使用if-null方式来判断,是否存在one方.
	//同样是延迟加载,load永远返回的不为null,但是many2one去one方的时候却可以为null.
	//因为先查询出了一个员工了,如果dept_id为null,则部门就为null.one方为null.
	//在查询员工的时候就已经知道外键列有没有值,load是因为之前没有查过数据库,不知道有没有对象,就先返回一个不为空的对象
 	//3:得到的one方,必须在session关闭之前实例化(获取),否则报错:no session.(延迟加载)
	//因为session关闭之后就没有连接了,没有连接就不能再去做查询操作了
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getSession();
		
		Employee e = (Employee) session.get(Employee.class, 1L);
		System.out.println(e);
		//获取员工所在的部门
		//当我们要拿部门的时候才再发一条SQL,去查询当前所在的员工所在的是哪一个部门.
		//延迟加载.说明查询只查询员工,不会查询部门信息,当我们需要查询部门信息的时候才会额外的发送SQL
		//many方获取one方的时候,使用了延迟加载
		Department dept = e.getDept();
		if (dept == null) {
			System.out.println("没有部门");
		}
		
		session.close();
	}
}
