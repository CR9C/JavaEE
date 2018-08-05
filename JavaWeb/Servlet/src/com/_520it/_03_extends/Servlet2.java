package com._520it._03_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet2 extends MyGenericServlet{

	/*public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		//super也可以省略
		String xx = getInitParameter("xx");
*/		
	public void init() {
			System.out.println("子类的初始化操作 ");
		}
		public void service(ServletRequest req, ServletResponse res) 
				throws ServletException, IOException {
			String encoding = super.getInitParameter("encoding");
			System.out.println(encoding);
		}
		
	}
	
	


