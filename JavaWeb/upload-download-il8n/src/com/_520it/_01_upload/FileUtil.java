package com._520it._01_upload;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.jar.Attributes.Name;

import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class FileUtil{
	//允许接受的图片
	private static final String ALLOWED_IMAGE_TYPE = "png;gif;jpg;jpeg;bmp";
	
	public static void upload(HttpServletRequest req,Map<String, String> fieldMap,Map<String, CFile> binaryMap)  {
		//解析和检查请求:请求方式是否是POST,请求编码是否是multipart/form-data
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2:创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//设置单个上传文件的大小限制
			upload.setFileSizeMax(1024 * 1024 *2);//2M
			//设置该次请求总数据大小限制
			upload.setSizeMax(1024 * 1024 *3);//3M
			//3:解析请求
			List<FileItem> items = upload.parseRequest(req);
			//4:迭代出每一个FileItem
			for (FileItem item : items) {
				String fieldName = item.getFieldName();//获取表单控件的name属性值(参数名)
				if (item.isFormField()) {//判断是否是普通表单控件
					//普通表单控件
					String value = item.getString("UTF-8");//获取当前普通表单控件的参数值
					System.out.println(fieldName + "-" +value);
//					if ("username".equals(fieldName)) {
//						user.setUsername(value);
//					} else {
//						user.setEmail(value);
//					}
					fieldMap.put(fieldName, value);
				} else {
					//-----------------------------------------
					//上传文件的拓展名
					String ext = FilenameUtils.getExtension(item.getName());
					String[] allowedImageType = ALLOWED_IMAGE_TYPE.split(";");
					
					//当前上传文件的类型不在图片允许的格式之内//用List集合的方法比较简单
					if (!Arrays.asList(allowedImageType).contains(ext)) {
						throw new LogicException("亲,请上传正确的图片格式");
					}
					
					//-----------------------------------------
					
					System.out.println(fieldName + "-" +FilenameUtils.getName(item.getName()));
					
					String fileName = UUID.randomUUID().toString() + "." 
							+ FilenameUtils.getExtension(item.getName());
					String dir = req.getServletContext().getRealPath("/upload");//返回绝对路径
					System.out.println(dir);
					item.write(new File(dir,fileName));//把二进制数据写到哪一个文件中
					
					CFile cFile = new CFile();
					cFile.setImageName(FilenameUtils.getName(item.getName()));
					cFile.setImageUrl("/upload/" + fileName);
					binaryMap.put(fileName, cFile);
				}
			}
		} catch (FileSizeLimitExceededException e) {
			throw new LogicException("亲,单个文件大小不能超过2M", e);
		} catch (SizeLimitExceededException e) {
			throw new LogicException("亲,该次请求的总的大小不能超过3M", e);
		} catch (LogicException e) {
			throw e;//继续抛出异常给调用者(UploadServlet)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
