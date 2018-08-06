package com._520it.smis.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com._520it.smis.handler.IResultSetHandler;

//这是JDBC操作的模板
public class JdbcTemplate {
	private JdbcTemplate() {}
	
	//DQL操作模板
	//静态方法中有泛型,只能在方法上定义泛型.定义还必须满足规范:1>方法得返回值必须和泛型有关.2>方法得参数也要和返回值有关
	public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			//设置占位符参数
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			return rsh.handle(rs);//没有异常时,执行到这里结束
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, rs);
		}
		return null;//有异常时,返回空开集合
		//其实应该在上面返回异常(throw new RuntimeException(e),这里不写)
	}
	
	//DML/DDL操作模板
	public static void update(String sql,Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			//设置占位符参数
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, ps, null);
		}
	}
}
