package com._520it.smis.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.smis.dao.IStudentDAO;
import com._520it.smis.dao.impl.StudentDAOImpl;
import com._520it.smis.domain.Student;

//处理删除指定ID学生的请求
@WebServlet("/student/delete")
public class DelectStudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IStudentDAO dao;
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数,封装成对象
		Long id = Long.valueOf(req.getParameter("id"));
		//2:调用业务方法处理请求
		dao.delete(id);
		//3:控制页面跳转(用重定向,因为不共享数据,而且要跳转的资源没有在WEB-INF中)
		resp.sendRedirect("/student/list");
	}
}
