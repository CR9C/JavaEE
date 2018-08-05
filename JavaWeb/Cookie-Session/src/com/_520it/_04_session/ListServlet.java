package com._520it._04_session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//输出收件箱界面
@WebServlet("/session/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		// ===================================
		//String username = "";
		//获取Session对象
		HttpSession session = req.getSession();
		//获取Session中存储的数据
		User user = (User) session.getAttribute("USER_IN_SESSION");
		//username = (String) session.getAttribute("currentName");
		// ===================================
		//out.println("欢迎:" + username + "<br/>");
		out.println("欢迎:" + user.getUsername() + "<br/>");
		String url = resp.encodeURL("/session/get");
		for (int i = 0; i < 6; i++) {
			out.println("<a href='"+url+"'>一封邮件</a><br>");
			//out.println("<a href='/session/get'>一封邮件</a><br>");
		}
	}
}
