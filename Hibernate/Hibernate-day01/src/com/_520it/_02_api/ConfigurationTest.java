package com._520it._02_api;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com._520it._01_crud.domain.User;

public class ConfigurationTest {
	
	//把连接数据库信息的和映射文件信息全部存放于hibernate.cfg3.xml文件中
	//(推荐)
	@Test
	public void test1() throws Exception {
		Configuration config = new Configuration().configure("/hibernate.cfg3.xml");
		SessionFactory sf = config.buildSessionFactory();
	}
	
	//把连接数据库信息存放在hibernate.properties中
	//把关联映射文件存放在hibernate.cfg.xml中
	@Test
	public void test2() throws Exception {
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
	}
	
	//Hibernate4.1开始支持创建SessionFactory的方式
	@Test
	public void test3() throws Exception {
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
		SessionFactory sf = config.buildSessionFactory(serviceRegistry);
	}
	
	//零配置(硬编码)
	@Test
	public void test4() throws Exception {
		Configuration config = new Configuration();
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:mysql:///hibernatedemo");
		config.setProperty("hibernate.connection.username", "root");
		config.setProperty("hibernate.connection.password", "admin");
		config.addClass(User.class);
		
		SessionFactory sf = config.buildSessionFactory();
	}
}
