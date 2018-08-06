package com._520it.smis.dao.impl;

import java.util.List;

import com._520it.smis.dao.IStudentDAO;
import com._520it.smis.domain.Student;
import com._520it.smis.handler.impl.BeanHandler;
import com._520it.smis.handler.impl.BeanListHandler;
import com._520it.smis.util.JdbcTemplate;

//拼SQL要特别注意空格,没事就多敲两个空格
public class StudentDAOImpl implements IStudentDAO {
	// "INSERT INTO t_student(name,age) VALUES('?', ?)";
	public void save(Student stu) {
		String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
		Object[] args = { stu.getName(), stu.getAge() };
		JdbcTemplate.update(sql, args);
	}

	public void delete(Long id) {
		String sql = "delete from t_student where id = ?";
		JdbcTemplate.update(sql, id);
	}

	// UPDATE t_student SET name = '?', age = ? WHERE id = ?
	public void update(Student stu) {
		String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ?";
		Object[] args = { stu.getName(), stu.getAge(), stu.getId() };
		JdbcTemplate.update(sql, args);
	}

	// 不能抛异常,否则调用又要抛异常
	public Student get(Long id) {
		String sql = "select * from t_student where id = ?";
		return JdbcTemplate.query(sql, new BeanHandler<>(Student.class),id);
		/*List<Student> list = JdbcTemplate.query(sql,new StudentHandler(), id);
		return list.size() == 1 ? list.get(0) : null;*/
	}

	public List<Student> list() {
		String sql = "select * from t_student";
		return JdbcTemplate.query(sql, new BeanListHandler<>(Student.class));
		
		//没有参数不要写null,写null在args.length中会报空指针异常;
		//不写默认是new Object[0],这个有对象,只不过这个对象没有容量而已
		//return JdbcTemplate.query(sql,new StudentHandler());
	}
	
	/*private class StudentHandler implements IResultSetHandler<List<Student>> {
		@Override
		public List<Student> handle(ResultSet rs) throws Exception {
			List<Student> list = new ArrayList<>();
			while (rs.next()) {
			Long id = rs.getLong("id");
			String name = rs.getString("name");
			Integer age = rs.getInt("age");
			Student stu = new Student(id, name, age);
			list.add(stu);
		}
			return list;
		}*/
		
	}

