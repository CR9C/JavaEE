package com._520it.shopping.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.dao.impl.ProductDAOImpl;
import com._520it.shopping.domain.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private IProductDAO dao;
	
	public void init() throws ServletException {
		dao = new ProductDAOImpl();
	}
	
	//product?cmd=请求操作名称
	//product?cmd=save------>save方法
	//product?cmd=delete------>delete方法
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//对POST有效,必须放在获取第一个参数之前
		String cmd = req.getParameter("cmd");//获取参数,不要用getAttribute是获取请求中的共享数据
		if ("save".equals(cmd)) {
			this.saveOrUpdate(req, resp);
		} else if ("edit".equals(cmd)) {
			this.edit(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		} else {
			this.list(req, resp);
		}
	}
	//显示商品列表
	protected void list(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数,封装成对象
		//2:调用业务方法处理请求
		List<Product> list = dao.list();
		//3:控制界面跳转
		req.setAttribute("products", list);
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}
	//删除指定商品
	protected void delete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
	}
	//进入编辑界面
	protected void edit(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数,封装成对象
		//2:调用业务方法处理请求
		//3:控制界面跳转
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
	}
	//新增或更新操作
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1:接收请求参数,封装成对象
		//2:调用业务方法处理请求
		//3:控制界面跳转
		
	}
}
