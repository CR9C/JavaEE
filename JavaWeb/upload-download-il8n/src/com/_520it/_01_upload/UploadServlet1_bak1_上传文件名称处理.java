package com._520it._01_upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

//@WebServlet("/upload")
public class UploadServlet1_bak1_上传文件名称处理 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//解析和检查请求:请求方式是否是POST,请求编码是否是multipart/form-data
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			//1:创建FileItemFactory对象
			//FileItemFactory是用来创建FileItem对象的
			//FileItem对象:form表单中的表单控件的封装
			FileItemFactory factory = new DiskFileItemFactory();
			//2:创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//3:解析请求
			List<FileItem> items = upload.parseRequest(req);
			//4:迭代出每一个FileItem
			for (FileItem item : items) {
				String fieldName = item.getFieldName();//获取表单控件的name属性值(参数名)
				if (item.isFormField()) {//判断是否是普通表单控件
					//普通表单控件
					String value = item.getString("UTF-8");//获取当前普通表单控件的参数值
					System.out.println(fieldName + "-" + value);
				} else {
					//表单上传控件,打印item.getName()时就表示上传文件的名称
					//System.out.println(fieldName + "-" +item.getName());
					System.out.println(fieldName + "-" +FilenameUtils.getName(item.getName()));
					
					String fileName = UUID.randomUUID().toString() + "." 
							+ FilenameUtils.getExtension(item.getName());
					//这里是文件不能是目录,不能存到文件夹中
					//item.write(new File("D:/",item.getName()));//把二进制数据写到哪一个文件中
					//item.write(new File("D:/",fileName));//把二进制数据写到哪一个文件中
					String dir = super.getServletContext().getRealPath("/upload");//返回绝对路径
					System.out.println(dir);
					item.write(new File(dir,fileName));//把二进制数据写到哪一个文件中
//					item.write(new File(dir));//没有fileName,此时dir就是一个目录
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		req.setCharacterEncoding("utf-8");
//		System.out.println(req.getParameter("username"));
//		System.out.println(req.getParameter("email"));
//		System.out.println(req.getParameter("headImg"));
		
//		Scanner sc = new Scanner(req.getInputStream());
//		while (sc.hasNextLine()) {
//			System.out.println(sc.nextLine());
//		}
	}
}
