package com._520it._03_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends MyGenericServlet{
	//只能处理一般的请求
		public void service(ServletRequest req, ServletResponse resp) 
				throws ServletException, IOException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			service(request, response);//调用处理http请求的方法
		}
		
		//专门处理HTTP的请求
		public void service(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
			String method = req.getMethod();//获取请求方式,GET/POST
			if ("GET".equals(method)) {
				doGet(req,resp);
			} else {
				doPost(req,resp);
			}
		}
		//专门用于处理POST请求
		private void doPost(HttpServletRequest req, HttpServletResponse resp) {
			System.out.println("Servlet1.doPost()");//syst
		}
		//专门用于处理GET请求
		private void doGet(HttpServletRequest req, HttpServletResponse resp) {
			System.out.println("Servlet1.doGet()");
		}
}
