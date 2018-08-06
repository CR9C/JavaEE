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
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IStudentDAO dao;

	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}
	
	//分发
	//http://localhost/student进入service方法,到底是保存,删除,查询
	//http://localhost/student?cmd=save //保存操作
	//http://localhost/student?cmd=delete //删除操作
	//http://localhost/student?cmd=edit //编辑操作
	//http://localhost/student //列表操作(else)
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//在获取任意参数之间要进行编码
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			this.saveOrUpdate(req, resp);
		} else if ("edit".equals(cmd)) {
			this.edit(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		} else {
			this.list(req, resp);
		}
	}
	//列表操作
	protected void list(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数,封装成对象
		
		//2:调用业务方法处理请求
		List<Student> list = dao.list();//查询所有的时候是没有任何参数要接收的
		System.out.println(list);
		//3:控制页面跳转(访问WEB-INF中的资源只能用请求转发)
		req.setAttribute("student", list);//把结果数据共享给list.jsp
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
	//编辑操作
	protected void edit(HttpServletRequest req, HttpServletResponse resp) 
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
	//删除操作
	protected void delete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数,封装成对象
		Long id = Long.valueOf(req.getParameter("id"));
		//2:调用业务方法处理请求
		dao.delete(id);
		//3:控制页面跳转(用重定向,因为不共享数据,而且要跳转的资源没有在WEB-INF中)
		resp.sendRedirect(req.getContextPath()+"/student");
	}
	//新增或更新操作
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
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
		resp.sendRedirect(req.getContextPath()+"/student");
	}
	
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
