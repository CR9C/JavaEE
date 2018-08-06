package com._520it.smis.dao;

import java.util.List;

import com._520it.smis.domain.Student;

/**
 * 学生对象的数据访问接口
 * @author bunny
 *
 */
public interface IStudentDAO {
	/**
	 * 保存一个学生对象
	 * @param stu 被保存的学生
	 */
	void save(Student stu);
	/**
	 * 根据ID删除一个学生
	 * @param id 被删除的学生的ID
	 */
	void delete(Long id);
	/**
	 * 更新一个学生
	 * @param stu 更新后的学生对象,该对象必须包含ID值
	 */
	void update(Student stu);
	/**
	 * 根据ID查询一个学生
	 * @param id 被查询的学生的ID
	 * @return 查询的学生对象,查无此学生时返回null
	 */
	Student get(Long id);
	/**
	 * 查询所有学生的信息
	 * @return 学生对象的集合,无学生时返回空白集合
	 * (就是一个ArrayList,但这个ArrayList没有数据.不能返回空,因为很容易发生空指针异常)
	 */
	List<Student> list();
}
