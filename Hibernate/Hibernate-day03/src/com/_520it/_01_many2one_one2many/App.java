package com._520it._01_many2one_one2many;

import org.hibernate.Session;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	
	/*
	 * 	先保存one方,再保存many方:
	 *  Hibernate: insert into Department (name) values (?)
		Hibernate: insert into Employee (name, dept_id) values (?, ?)
		Hibernate: insert into Employee (name, dept_id) values (?, ?)
		Hibernate: update Employee set dept_id=? where id=?
		Hibernate: update Employee set dept_id=? where id=?
		
	 * 	先保存many方,再保存one方:
		Hibernate: insert into Employee (name, dept_id) values (?, ?)
		Hibernate: insert into Employee (name, dept_id) values (?, ?)
		Hibernate: insert into Department (name) values (?)
		Hibernate: update Employee set name=?, dept_id=? where id=?
		Hibernate: update Employee set name=?, dept_id=? where id=?
		Hibernate: update Employee set dept_id=? where id=?
		Hibernate: update Employee set dept_id=? where id=?
	 */
	@Test
	public void testSave() throws Exception {
		Department d = new Department();
		d.setName("开发部");
		
		Employee e1 = new Employee();
		e1.setName("张三");
		Employee e2 = new Employee();
		e2.setName("李四");
		
		//维护关系
		//部门维护关系
		d.getEmployees().add(e1);
		d.getEmployees().add(e2);
		//员工维护关系
		e1.setDept(d);
		e2.setDept(d);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(d);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}
}
