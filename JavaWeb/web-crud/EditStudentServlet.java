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

//进入编辑界面
//新增的时候没有id,更新的时候有id
@WebServlet("/student/edit")
public class EditStudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求对象,封装成对象
		String sid = req.getParameter("id");
		//2:调用业务方法处理请求
		//有id,就先转换,再从数据库中查询出来(编辑,就要传一个id);没有id,就直接跳转(添加)
		if (hasLength(sid)) {
			Student stu = dao.get(Long.valueOf(sid));
			req.setAttribute("student", stu);//传递给edit.jsp,用于回显被编辑的学生
		}
		//3:控制界面跳转
		req.getRequestDispatcher("/WEB-INF/views/student/edit.jsp").forward(req, resp);
	}
	
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
