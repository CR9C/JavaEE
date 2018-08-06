package com._520it.shopping.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.dao.impl.ProductDAOImpl;
import com._520it.shopping.domain.Product;

public class ProductDAOImplTest {
	
	private IProductDAO dao = new ProductDAOImpl();
	@Test
	public void testSave() {
		Product p = dao.get(1L);
		p.setProductName("机械键盘");
		p.setCostPrice(new BigDecimal("100"));
		p.setSalePrice(new BigDecimal("500"));
		dao.save(p);
	}

	@Test
	public void testUpdate() { 
		Product p = dao.get(1L);
		p.setProductName("小码哥鼠标");
		dao.update(p);
	}

	@Test
	public void testDelete() {
		dao.delete(21L);
	}

	@Test
	public void testGet() {
		Product p = dao.get(1L);
		System.out.println(p);
	}

	@Test
	public void testList() {
		List<Product> list = dao.list();
		for (Product p : list) {
			System.out.println(p);
		}
	}

}
