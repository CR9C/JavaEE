package com._520it._01_crud.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com._520it._01_crud.dao.IUserDAO;
import com._520it._01_crud.domain.User;

public class UserDAOImpl implements IUserDAO{

	public void save(User u) {
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg3.xml");
		//3:创建SessionFactory对象,好比是DateSource(连接池)
		SessionFactory sf = config.buildSessionFactory();
		//4:创建Session对象:好比是Connection
		Session session = sf.openSession();
		//----------------------------------------
		//方式一:
//		Transaction tx = session.beginTransaction();//设置事务的活动状态
//		session.save(u);
//		tx.commit();//提交事务
		//方式二:
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		//两种方式都要获取事务对象
		//----------------------------------------
		session.close();
		sf.close();
	}

	public void delete(Long id) {
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg3.xml");
		//3:创建SessionFactory对象,好比是DateSource(连接池)
		SessionFactory sf = config.buildSessionFactory();
		//4:创建Session对象:好比是Connection
		Session session = sf.openSession();
		//---------------------------------
		session.beginTransaction();
		User u = new User();
		u.setId(id);
		//如果传一个id就会报错,要传一个对象,因为才会知道是那张表
		//(delete from t_user where uid = ?)
		session.delete(u);
		session.getTransaction().commit();
		//---------------------------------
		session.close();
		sf.close();
	}

	public void update(User u) {
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg3.xml");
		//3:创建SessionFactory对象,好比是DateSource(连接池)
		SessionFactory sf = config.buildSessionFactory();
		//4:创建Session对象:好比是Connection
		Session session = sf.openSession();
		//---------------------------------
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
		//---------------------------------
		session.close();
		sf.close();
	}

	public User get(Long id) {
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg3.xml");
		//3:创建SessionFactory对象,好比是DateSource(连接池)
		SessionFactory sf = config.buildSessionFactory();
		//4:创建Session对象:好比是Connection
		Session session = sf.openSession();
		//User.class:1>通过该实体类找到对应是那张表;2>处理结果集的时候知道把每一行封装成什么类型的对象
		User u = (User) session.get(User.class, id);
		session.close();
		sf.close();
		return u;
	}

	public List<User> listAll() {
		Configuration config = new Configuration();
		config.configure("/hibernate.cfg3.xml");
		//3:创建SessionFactory对象,好比是DateSource(连接池)
		SessionFactory sf = config.buildSessionFactory();
		//4:创建Session对象:好比是Connection
		Session session = sf.openSession();
		String hql = "SELECT u FROM User u";
		Query query = session.createQuery(hql);//创建查询对象
		List<User> list = query.list();//执行查询操作
		session.close();
		sf.close();
		return list;
	}

}
