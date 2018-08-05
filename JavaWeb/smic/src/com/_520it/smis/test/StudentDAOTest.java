package com._520it.smis.test;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import com._520it.smis.dao.IStudentDAO;
import com._520it.smis.dao.impl.StudentDAOImpl;
import com._520it.smis.domain.Account;
import com._520it.smis.domain.Student;
import com._520it.smis.handler.IResultSetHandler;
import com._520it.smis.handler.impl.BeanListHandler;
import com._520it.smis.handler.impl.ScalarHandler;
import com._520it.smis.util.JdbcTemplate;

public class StudentDAOTest {
	//首先要有一个依赖关系
	//面向接口编程
	private IStudentDAO dao = new StudentDAOImpl();
	
	@Test
	public void testSave() {
		Student stu = new Student(null,"小龙",17);
		dao.save(stu);
	}

	@Test
	public void testDelete() {
		dao.delete(9L);
	}

	@Test
	public void testUpdate() {
		Student stu = new Student(7L,"福禄娃",8);
		dao.update(stu);
	}

	@Test
	public void testGet() {
		Student stu = dao.get(1580L);
		System.out.println(stu);
	}

	@Test
	public void testList() {
		List<Student> list = dao.list();
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testAccount() {
		String sql = "SELECT * FROM account";
		List<Account> list = JdbcTemplate.query(sql, new BeanListHandler<>(Account.class));
		for (Account account : list) {
			System.out.println(account);
		}
	}
	

	
	@Test
	public void testCount() throws Exception {
		String sql = "SELECT COUNT(id) FROM t_student";
		Long count = JdbcTemplate.query(sql, new IResultSetHandler<Long>() {
			@Override
			public Long handle(ResultSet rs) throws Exception {
				if (rs.next()) {
					return rs.getLong(1);
				}
				return 0L;
			}
		});
		System.out.println(count);
	}
	@Test
	public void testCount1() throws Exception {
		String sql = "SELECT COUNT(id) FROM t_student";
		Long count = JdbcTemplate.query(sql, new ScalarHandler<>(Long.class));
		System.out.println(count);
	}

}
