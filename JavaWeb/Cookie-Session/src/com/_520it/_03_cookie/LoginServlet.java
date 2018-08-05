package com._520it._03_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//处理登录请求并输出欢迎界面
@WebServlet("/cookie/login")
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
		String username = req.getParameter("username");
		//===================================
		//创建Cookie,存储数据
		//Cookie c = new Cookie("currentName", username);
		Cookie c = new Cookie("currentName", URLEncoder.encode(username, "UTF-8"));
		//Cookie c2 = new Cookie("currentName", "xx");
		c.setMaxAge(15);//15s
		c.setPath("/");//整个应用中
		//把Cookie响应响应给浏览器
		resp.addCookie(c);
		//resp.addCookie(c2);
		//===================================
		out.println("欢迎:" + username +"<br/>");
		out.println("<a href='/abc/list'>收件箱</a>");
	}
}
