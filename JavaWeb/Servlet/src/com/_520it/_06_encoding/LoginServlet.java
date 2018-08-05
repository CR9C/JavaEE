package com._520it._06_encoding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//接收和处理登录的请求信息
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//对于POST请求,可以设置请求的编码
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		/*
		//1:按照ISO-8859-1把乱码恢复成二进制形式
		//前提是页面是UTF-8,工作空间也是UTF-8
	   	byte[] data=username.getBytes("ISO-8859-1");
		//2:再把二进制形式的数据使用UTF-8重新编码
	   	username = new String(data,"UTF-8");
	   	*/
		String password = req.getParameter("password");
		System.out.println(username + "," +password);
	}
}
