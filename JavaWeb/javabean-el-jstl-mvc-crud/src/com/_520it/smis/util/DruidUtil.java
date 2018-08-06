package com._520it.smis.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {
	private DruidUtil() {}
	
	private static DataSource ds;
	
	static{//只会在JVM加载时执行一次
		try {
			//先读取配置文件中的信息,再去注册驱动
			Properties p = new Properties();
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
			p.load(in);
			in.close();
			//ds = BasicDataSourceFactory.createDataSource(p);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws Exception {
		return ds.getConnection();
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
