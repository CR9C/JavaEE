package com._520it._02_initparam;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//获取Servlet的初始化参数
public class InitParamServlet implements Servlet{
	
	private ServletConfig config;
	//做初始化
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//获取参数名为encoding的初始化参数
		String encoding = config.getInitParameter("encoding");
		System.out.println(encoding);
		//获取所有参数的名字和值
		Enumeration<String> en = config.getInitParameterNames();
		while (en.hasMoreElements()) {
			String paramName = en.nextElement();
			System.out.println(paramName + "," + config.getInitParameter(paramName));
		}
		if ("GBK".equals(encoding)) {
			System.out.println("你好世界");
		}else {
			System.out.println("Hello World");
		}
	}
	
	
	
	
	
	
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	public void destroy() {
		
	}

}
