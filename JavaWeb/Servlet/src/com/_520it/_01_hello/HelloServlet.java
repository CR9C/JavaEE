package com._520it._01_hello;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements javax.servlet.Servlet {
	
	public HelloServlet() {
		System.out.println("创建Servlet对象...");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化");
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("服务...");
	}
	
	public void destroy() {
		System.out.println("销毁");
	}
	public ServletConfig getServletConfig() {
		return null;
	}


	public String getServletInfo() {
		return null;
	}


}
