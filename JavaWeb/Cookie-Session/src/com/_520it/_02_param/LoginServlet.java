package com._520it._02_param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//处理登录请求并输出欢迎界面
@WebServlet("/param/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码,仅仅只对POST有效
		req.setCharacterEncoding("UTF-8");
		//设置输出类型以及编码
		resp.setContentType("text/html;charset=utf-8");
		//获取一个输出流
		PrintWriter out = resp.getWriter();
		//先写以上三行代码
		//===================================
		String username = req.getParameter("username");
		out.println("欢迎:" + username +"<br/>");
		out.println("<a href='/param/list?username="+username+"'>收件箱</a>");
	}
}
