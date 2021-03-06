package com._520it._01_upload;

import lombok.Data;

//用户
@Data
public class User {
	private String username;
	private String email;
	private String imageUrl;//图片保存的路径:/upload/123.png JSP: <img src="${user.imageUrl}"/>
	private String imageName;//图片的原始名称
}
