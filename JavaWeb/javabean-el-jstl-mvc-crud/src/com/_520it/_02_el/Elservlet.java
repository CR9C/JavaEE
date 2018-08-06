package com._520it._02_el;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//把Person对象中的数据传递到JSP中用于显示
@WebServlet("/el")
public class Elservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Person person = dao.get(1L);
		Person person = new Person();
		//把Person对象存放在request作用域中,共享给JSP
		req.setAttribute("p", person);
		req.getRequestDispatcher("/el/el.jsp").forward(req, resp);
	}
}
