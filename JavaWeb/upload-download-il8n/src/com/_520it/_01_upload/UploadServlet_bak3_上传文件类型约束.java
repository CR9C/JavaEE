package com._520it._01_upload;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

//@WebServlet("/upload")
public class UploadServlet_bak3_上传文件类型约束 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//允许接受的图片
	private static final String ALLOWED_IMAGE_TYPE = "png;gif;jpg;jpeg";
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//解析和检查请求:请求方式是否是POST,请求编码是否是multipart/form-data
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
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
				} else {
					//-----------------------------------------
					//所有图片的MIME类型都是以image打头
					//当前上传文件的MIME类型
					String mimeType = super.getServletContext().getMimeType(item.getName());
					System.out.println(mimeType);
					/*
					 * 代码未完成
					 * if (!"image".equals(mimeType)) {
						req.setAttribute("errorMsg", "亲,请上传图片文件");
						req.getRequestDispatcher("/input.jsp").forward(req, resp);
						return;//结束方法
					}*/
					//-----------------------------------------
					//上传文件的拓展名
					/*String ext = FilenameUtils.getExtension(item.getName());
					String[] allowedImageType = ALLOWED_IMAGE_TYPE.split(";");
					
					//当前上传文件的类型不在图片允许的格式之内//用List集合的方法比较简单
					if (!Arrays.asList(allowedImageType).contains(ext)) {
						req.setAttribute("errorMsg", "亲,请上传图片文件");
						req.getRequestDispatcher("/input.jsp").forward(req, resp);
						return;//结束方法
					}*/
					
					//-----------------------------------------
					
					System.out.println(fieldName + "-" +FilenameUtils.getName(item.getName()));
					
					String fileName = UUID.randomUUID().toString() + "." 
							+ FilenameUtils.getExtension(item.getName());
					String dir = super.getServletContext().getRealPath("/upload");//返回绝对路径
					System.out.println(dir);
					item.write(new File(dir,fileName));//把二进制数据写到哪一个文件中
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
