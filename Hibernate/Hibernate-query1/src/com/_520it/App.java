package com._520it;

import static org.junit.Assert.*;

import org.junit.Test;

import com._520it.util.HibernateUtil;

public class App {
	@Test
	public void testName() throws Exception {
		HibernateUtil.getSession();
	}
}
