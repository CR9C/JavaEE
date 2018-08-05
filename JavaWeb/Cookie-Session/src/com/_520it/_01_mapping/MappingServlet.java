package com._520it._01_mapping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/m")
public class MappingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//http://192.168.101.10/m?name=Will
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置响应的类型以及编码
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("你输入的名字:" + name);
	}
}
