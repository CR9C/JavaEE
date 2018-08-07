package com._520it.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf = null;
	
	static{
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		sf = config.buildSessionFactory();
	}
	
	public static Session getSession() {
		return sf.openSession();
		//return sf.getCurrentSession();
	}
}
