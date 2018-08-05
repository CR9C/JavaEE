package com._520it._03_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//方式1:
public class EmployeeServlet1 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		//自身的初始化代码
	}
	//该方法可以处理POST和GET请求
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//处理请求的代码
		System.out.println("EmployeeServlet1.service()");
	}
}
