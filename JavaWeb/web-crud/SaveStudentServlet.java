package com._520it.smis.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.smis.dao.IStudentDAO;
import com._520it.smis.dao.impl.StudentDAOImpl;
import com._520it.smis.domain.Student;

//保存学生对象
@WebServlet("/student/save")
public class SaveStudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//1:接收请求对象,封装成对象
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		Student stu = new Student( null,name,Integer.valueOf(age));
		//2:调用业务方法处理请求
		String id = req.getParameter("id");
		if (hasLength(id)) {//更新
			stu.setId(Long.valueOf(id));
			dao.update(stu);
		} else {//新增
			dao.save(stu);
		}
		//3:控制界面跳转
		resp.sendRedirect("/student/list");
	}
	
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
