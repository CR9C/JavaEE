package com._520it.smis.handler;

import java.sql.ResultSet;

/**
 * 定义处理结果集的规范
 * @param T 方法返回的类型
 * @author bunny
 */
public interface IResultSetHandler<T> {
	/**
	 * 处理结果集的方法
	 * @param rs 要处理的结果集
	 * @return 处理后的结果
	 * @throws Exception 
	 */
	//写了Object,一会从List中拿出的对象都要强转
	T handle(ResultSet rs) throws Exception;
}
