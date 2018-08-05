package com._520it._08_cal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//在线版的简易计算器
@WebServlet("/cal")
public class CalServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//要做输出,就要拿到一个输出流对象
		PrintWriter out = resp.getWriter();
		//============================================
		//2:接收表单中的数据
		String op = req.getParameter("op");
		String sNum1 = req.getParameter("num1");
		String sNum2 = req.getParameter("num2");
		String result ="";
		if (haslength(sNum1) && haslength(sNum2)) {
			Integer num1 = Integer.valueOf(sNum1);
			Integer num2 = Integer.valueOf(sNum2);
			if ("+".equals(op)) {
				result = num1+num2+"";
			} else if ("-".equals(op)) {
				result = num1-num2+"";
			}
		}
		//============================================
		//1:输出一个计算机的界面
		//要不要br都无所谓,因为网页中是<br>换行
		//双引号和双引号冲突,网页中单引号和双引号无所谓,
		//所以把双引号替换为单引号,java中没有单引号的概念
		out.print("<form action='/day3/cal' method='post'>");
		out.print("<input type='number' name='num1' value='"+sNum1+"'>");
		out.print("<select name='op'>");
		out.print("<option>+</option>");
		out.print("<option>-</option>");
		out.print("<option>*</option>");
		out.print("<option>/</option>");
		out.print("</select>");
		out.print("<input type='number' name='num2'  value='"+sNum2+"'>");
		out.print("<input type='submit' value=' = '>");
		out.print("<input type='text' value='"+ result +"' disabled>");
		out.print("</form>");
	}		
		//判断字符串是否为空
		private boolean haslength(String str) {
			return str != null && !"".equals(str.trim());
		}
	}

