package com._520it._01_mapping;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value="/m1",loadOnStartup=1)
public class MappingServlet_0 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public MappingServlet_0() {
		System.out.println("MappingServlet.MappingServlet()");
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("MappingServlet.init()");
	}
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("MappingServlet.service()");
	}
}
