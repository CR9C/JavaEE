package com._520it._01_upload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			User user = new User();
			//-------------------------------
			//封装普通表单的数据
			//key: 参数名称
			//value: 参数值
			Map<String, String> fieldMap = new HashMap<>();
			//封装上传表单的数据
			//key: 参数名称:headImg
			//value: CFile对象,CFile对象同时封装了imageUrl和imageName
			Map<String, CFile> binaryMap = new HashMap<>();
			FileUtil.upload(req, fieldMap,binaryMap);
//			FileUtil.upload(req,user);
			System.out.println(fieldMap);
			System.out.println(binaryMap);
			//再从filedMap中取出数据,再设置到User对象中
			user.setUsername(fieldMap.get("username"));
			user.setEmail(fieldMap.get("email"));
			user.setImageName(binaryMap.get("headImg").getImageName());
			user.setImageUrl(binaryMap.get("headImg").getImageUrl());
			
			req.setAttribute("u", user);
			req.getRequestDispatcher("/show.jsp").forward(req, resp);
			System.out.println(user);
		} catch (LogicException e) {
			String errorMsg = e.getMessage();//获取异常信息
			req.setAttribute("errorMsg", errorMsg);
			req.getRequestDispatcher("/input.jsp").forward(req, resp);
		}
	}
}
