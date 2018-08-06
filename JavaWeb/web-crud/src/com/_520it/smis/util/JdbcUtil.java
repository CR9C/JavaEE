package com._520it.smis.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	private JdbcUtil() {}
	
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	
	static{//只会在JVM加载时执行一次
		try {
			//先读取配置文件中的信息,再去注册驱动
			Properties p = new Properties();
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
			p.load(in);
			in.close();
			//给成员变量赋值
			driverClassName = p.getProperty("driverClassName");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			//注册驱动
			Class.forName(JdbcUtil.driverClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws Exception {
		return DriverManager.getConnection(
				url, username, password);
	}
	
	public static void close(Connection conn, Statement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
