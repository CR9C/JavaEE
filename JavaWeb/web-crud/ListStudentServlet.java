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

@WebServlet("/student/list")
public class ListStudentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//将DAO声明在成员变量,声明在方法中每次都会创建一个新的DAO对象
	//一般将DAO设置成单例的,因为Servlet是单例的,而该成员变量是属于Servlet对象的,
	//对象只有一个,所以它也就只有一个.无参数的init方法对他完成初始化操作
	private IStudentDAO dao;
	
	public void init() throws ServletException {
		dao = new StudentDAOImpl();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数,封装成对象
		
		//2:调用业务方法处理请求
		List<Student> list = dao.list();//查询所有的时候是没有任何参数要接收的
		System.out.println(list);
		//3:控制页面跳转(访问WEB-INF中的资源只能用请求转发)
		req.setAttribute("student", list);//把结果数据共享给list.jsp
		req.getRequestDispatcher("/WEB-INF/views/student/list.jsp").forward(req, resp);
	}
}
