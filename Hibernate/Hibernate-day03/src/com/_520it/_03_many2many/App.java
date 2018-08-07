package com._520it._03_many2many;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	@Test
	public void testSave() throws Exception {
		Student s1 = new Student();
		s1.setName("小王");
		Student s2 = new Student();
		s2.setName("小黄");
		
		Teacher t1 = new Teacher();
		t1.setName("Stef");
		Teacher t2 = new Teacher();
		t2.setName("Will");
		
		//维护关系
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);
		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t2.getStudents().add(s1);
		t2.getStudents().add(s2);
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(s1);
		session.save(s2);
		session.save(t1);
		session.save(t2);
		
		session.getTransaction().commit();
		session.close();
	}
}
