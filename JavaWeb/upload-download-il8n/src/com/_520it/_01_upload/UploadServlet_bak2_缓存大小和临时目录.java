package com._520it._01_upload;

import java.io.IOException;
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
public class UploadServlet_bak2_缓存大小和临时目录 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//解析和检查请求:请求方式是否是POST,请求编码是否是multipart/form-data
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			//FileItemFactory factory = new DiskFileItemFactory();
			//factory对象中没有该方法,说明该方法可能没有在FileItemFactory类中,而在DiskFileItemFactory中,在编译的时候就调用不了
			//方式一:
			//FileItemFactory factory = new DiskFileItemFactory(sizeThreshold, repository);
			//方式二:
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置缓存大小
			factory.setSizeThreshold(20 * 1024);//20KB
			//设置临时目录
			//factory.setRepository(repository);//repository仓库
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
					System.out.println(fieldName + "-" +FilenameUtils.getName(item.getName()));
					
					String fileName = UUID.randomUUID().toString() + "." 
							+ FilenameUtils.getExtension(item.getName());
					String dir = super.getServletContext().getRealPath("/upload");//返回绝对路径
					System.out.println(dir);
					//item.write(new File(dir,fileName));//把二进制数据写到哪一个文件中
					
					//是否存储在内存中
					System.out.println(item.isInMemory());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
