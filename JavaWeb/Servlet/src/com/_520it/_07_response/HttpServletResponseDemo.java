package com._520it._07_response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//演示HttpServletResponse接口方法
@WebServlet("/resp")
public class HttpServletResponseDemo extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//设置输出数据的MIME类型
		//resp.setContentType("text/html");
		//设置输出数据的编码方式
		//resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");//大小写都可
		
		//在浏览器中输出spring Brother,凤姐
		//要在浏览器中做输出,要先拿到输出流对象,不能从请求req中拿,请求是对程序来说是拿进来
		//现在是写出去,是向浏览器做响应resp.ServletOutputStrean是OutputStream的子类
		//OutputStream out = resp.getOutputStream();
		//out.write("Spring Brother".getBytes());
		PrintWriter out = resp.getWriter();
		out.println("Spring Brother");
		out.println("凤姐");
		out.println("你好世界");
	}
}
