package com._520it._04_session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//处理登录请求并输出欢迎界面
@WebServlet("/session/login")
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
		//接收请求参数,封装成对象
		User user = new User();
		user.setUsername(username);
		//user.setXxx......
		//1:创建和获取Session对象
		HttpSession session = req.getSession();
		//超过15秒,销毁Session.
		session.setMaxInactiveInterval(15);//超过时间为15秒
		//15秒之内不动,第16秒之后再来刷新就没有了,当我在第14秒时再来刷新的时候,会重新算时间,两次操作间隔的时间不能超过15秒,默认Tomcat是30分钟
		//System.out.println(session.getId());//7289E8484D67C75AD25F51E18237800A
		//2:往session存储数据
		session.setAttribute("USER_IN_SESSION", user);
		//不需要放到响应中,底层会放到响应中去
		//session.setAttribute("currentName", username);
		//===================================
		out.println("欢迎:" + username +"<br/>");
		String url = resp.encodeURL("/session/list");
		System.out.println(url);
		out.println("<a href='"+url+"'>收件箱</a>");
		//out.println("<a href='/session/list;jessionid="+session.getId()+"'>收件箱</a>");
		//out.println("<a href='/session/list'>收件箱</a>");
	}
}
