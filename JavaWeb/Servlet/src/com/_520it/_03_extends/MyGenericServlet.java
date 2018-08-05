package com._520it._03_extends;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

//在网络上传输还要实现Serializable虚拟化接口
abstract public class MyGenericServlet implements Serializable, Servlet, ServletConfig {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;

	// -----------Servlet中的方法-----------
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.init();
	}
	
	//专门暴露给子类,让子类编写自身的初始化代码
	public void init() {
		//NOOP空实现
	}
	// 要求子类必须覆盖service方法,必须处理请求
	abstract public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

	// 把ServletConfig对象暴露给子类访问
	public ServletConfig getServletConfig() {
		return this.config;
	}

	public String getServletInfo() {
		return null;
	}

	public void destroy() {

	}

	// -------------ServletConfig中的方法-----------------
	public String getServletName() {
		return config.getServletName();
	}

	public ServletContext getServletContext() {
		return config.getServletContext();
	}

	public String getInitParameter(String name) {
		return config.getInitParameter(name);
	}

	public Enumeration<String> getInitParameterNames() {
		return config.getInitParameterNames();
	}

}
