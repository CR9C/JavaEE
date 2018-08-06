package com._520it.smis.handler.impl;

import java.sql.ResultSet;

import com._520it.smis.handler.IResultSetHandler;

public class ScalarHandler<T> implements IResultSetHandler<T> {
	private Class<T> clz;//结果集的一行数据封装的类型
	
	public ScalarHandler(Class<T> clz) {
		super();
		this.clz = clz;
	}

	public T handle(ResultSet rs) throws Exception {
		T obj = null;
		Class<?> type = clz;
		if (rs.next()) {
			Object value = rs.getObject(1);
			if (clz == Long.class) {
				type = long.class;
			} else if (clz == Integer.class) {
				type = int.class;//共八种基本类型
			}
			obj = clz.getConstructor(type).newInstance(value);
		}
		return obj;
	}



}
