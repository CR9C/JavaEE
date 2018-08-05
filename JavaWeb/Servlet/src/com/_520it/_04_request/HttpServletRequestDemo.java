package com._520it._04_request;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//演示HttpServletRequest的方法
public class HttpServletRequestDemo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//01.String getMethod():返回请求方式：如GET/POST
		//都是GET请求只有表格中method=post才是POST
		System.out.println(req.getMethod());//GET
		//02.String getRequestURI():返回请求行中的资源名字部分:如/test/index.html
		System.out.println(req.getRequestURI());///day3/req
		//03.StringBuffer getRequestURL():返回浏览器地址栏中所有的信息
		System.out.println(req.getRequestURL());//http://localhost/day3/req
		//04.String getContextPath():返回当前项目的上下文路径(<Context/>元素的path属性值.)
		System.out.println(req.getContextPath());///day3
		//05.String getRemoteAddr():返回发出请求的客户机的IP地址
		System.out.println(req.getRemoteAddr());//0:0:0:0:0:0:0:1
		//06.String getHeader(String name):返回指定名称的请求头的值。
		//User-Agent:判断客户端用的是哪一种浏览器
		String userAgent = req.getHeader("User-Agent");
		//判断是否是IE
		System.out.println(userAgent.contains("MSIE"));//false
		System.out.println(userAgent);
		//Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
		
		//----------------------------------------------------
		//localhost/day3/req?username=will&age=17&hobby=java&hobby=girl浏览器中输入
		//01.String getParameter(String name):返回指定名字参数的值。
		String username = req.getParameter("username");
		System.out.println(username);//will
		//02.String[] getParameterValues(String name):返回指定名字参数的多个参数值。
		String[] hobbys = req.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbys));//[java, girl]
		//03.Enumeration<String> getParameterNames():返回所有参数名的Enumeration对象。
		Enumeration<String> names = req.getParameterNames();
		while (names.hasMoreElements()) {
			System.out.println("-->" + names.nextElement());
		}
		//-->username
		//-->age
		//-->hobby
		//04.Map<String,String[]> getParameterMap():返回所有的参数和值所组成的Map对象。
		Map<String, String[]> map = req.getParameterMap();
		System.out.println(map);
		//{username=[Ljava.lang.String;@784fe18c, age=[Ljava.lang.String;@4460ec09, hobby=[Ljava.lang.String;@372865f1}
	}
}
