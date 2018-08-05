package com._520it._03_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//方式2:
public class EmployeeServlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//该方法只能处理GET请求
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	//该方法只能处理POST请求
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			//编写处理请求的代码
		}
}
