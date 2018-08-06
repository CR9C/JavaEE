package com._520it._01_upload;

import org.apache.commons.io.FilenameUtils;

public class FilenameUtilsTest {
	public static void main(String[] args) {
		String path = "C:/123/abc/outman.png";
		//文件名称的工具类
		//获取文件名称:outman.png
		System.out.println(FilenameUtils.getName(path));
		//获取文件名称,但是不包括拓展名:outman
		System.out.println(FilenameUtils.getBaseName(path));
		//获取拓展名:png
		System.out.println(FilenameUtils.getExtension(path));
	}
}
