package com._520it.shopping.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com._520it.shopping.dao.IProductDAO;
import com._520it.shopping.domain.Product;

//贾琏欲执事
public class ProductDAOImpl implements IProductDAO {

	public void save(Product obj) {
		String sql = "INSERT INTO product (productName,brand,supplier,salePrice,costPrice,cutoff,dir_id) VALUES (?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "admin");
			ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getProductName());
			ps.setString(2, obj.getBrand());
			ps.setString(3, obj.getSupplier());
			ps.setBigDecimal(4, obj.getSalePrice());
			ps.setBigDecimal(5, obj.getCostPrice());
			ps.setDouble(6, obj.getCutoff());
			ps.setLong(7, obj.getDir_id());
			ps.executeUpdate();
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

	public void update(Product obj) {
		String sql = "UPDATE product SET productName=?,brand=?,supplier=?,salePrice=?,costPrice=?,cutoff=?,dir_id=? WHERE id =?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "admin");
			ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getProductName());
			ps.setString(2, obj.getBrand());
			ps.setString(3, obj.getSupplier());
			ps.setBigDecimal(4, obj.getSalePrice());
			ps.setBigDecimal(5, obj.getCostPrice());
			ps.setDouble(6, obj.getCutoff());
			ps.setLong(7, obj.getDir_id());
			ps.setLong(8, obj.getId());
			ps.executeUpdate();
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

	public void delete(Long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "admin");
			ps = conn.prepareStatement(sql);
			ps.setLong(1,id);
			ps.executeUpdate();
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

	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "admin");
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				list.add(p);
				p.setId(rs.getLong("id"));
				p.setProductName(rs.getString("productName"));
				p.setBrand(rs.getString("brand"));
				p.setSupplier(rs.getString("supplier"));
				p.setSalePrice(rs.getBigDecimal("salePrice"));
				p.setCostPrice(rs.getBigDecimal("costPrice"));
				p.setCutoff(rs.getDouble("cutoff"));
				p.setDir_id(rs.getLong("dir_id"));

				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return null;
	}

	public List<Product> list() {
		String sql = "SELECT * FROM product";
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 从java6开始不需要加载注册驱动,但是在web中必须要手动加载
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "admin");
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				list.add(p);
				p.setId(rs.getLong("id"));
				p.setProductName(rs.getString("productName"));
				p.setBrand(rs.getString("brand"));
				p.setSupplier(rs.getString("supplier"));
				p.setSalePrice(rs.getBigDecimal("salePrice"));
				p.setCostPrice(rs.getBigDecimal("costPrice"));
				p.setCutoff(rs.getDouble("cutoff"));
				p.setDir_id(rs.getLong("dir_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return list;
	}

}
