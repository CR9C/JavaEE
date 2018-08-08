package com._520it._04_query_result;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com._520it.util.HibernateUtil;

//查询结果的封装
public class QueryResultPackageTest {

	//需求:查询所有员工的编号,名字,工资,所在部门的编号和名称:
	@Test
	public void testOId() throws Exception {
		String hql = "SELECT e.id,e.name,e.salary,e.dept.id,e.dept.name FROM Employee e";
		Session session = HibernateUtil.getSession();
		List<Object[]> list = session.createQuery(hql).list();
		session.close();
		for (Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//2>:List<Object>:使用LIST来封装查询结果
	@Test
	public void testLIST() throws Exception {
		String hql = "SELECT NEW LIST(e.id,e.name,e.salary,e.dept.id,e.dept.name) FROM Employee e";
		Session session = HibernateUtil.getSession();
		//List<Object> list = session.createQuery(hql).list();
		//是一个list,从Object数组到list就是一次升华,操作数组是很麻烦的,操作list可以操作索引
		List<List<Object>> list = session.createQuery(hql).list();
		session.close();
		for (List<Object> o : list) {
			System.out.println(o);
		}
	}
}
