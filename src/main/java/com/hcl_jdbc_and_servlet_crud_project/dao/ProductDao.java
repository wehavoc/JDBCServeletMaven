package com.hcl_jdbc_and_servlet_crud_project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hcl_jdbc_and_servlet_crud_project.connection.JdbcConnection;
import com.hcl_jdbc_and_servlet_crud_project.dto.Product;

public class ProductDao {


	// saveProductDao (Product product)
	public Product saveProductDao(Product product) {
		String insertProductQuery = "insert into product(id, name, color, price, mfd, expd) values(?,?,?,?,?,?)";

		Connection connection = JdbcConnection.getJdbcConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(insertProductQuery);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setString(3, product.getColor());
			ps.setDouble(4, product.getPrice());
			ps.setObject(5, product.getMfd());
			ps.setObject(6, product.getExpd());
			
			int a = ps.executeUpdate();
			return a != 0 ? product : null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// Delete Product by id deleteProductByIdDao(int productId)
	public boolean deleteProductByIdDao(int productId) {
		Connection connection  = JdbcConnection.getJdbcConnection();
		String deleteProductByIdQuery = "delete from product where id = ?";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(deleteProductByIdQuery);
			ps.setInt(1, productId);
			int a = ps.executeUpdate();
			return a != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}

	}

	// get Product by id
	// @return Product
	public Product DisplayProductByIdDao(int productId) {
		Connection connection = JdbcConnection.getJdbcConnection();
		if(connection == null) {
			System.out.println("Database connection failed");
			return null;
		}
		String displayProductByIdQuery = "SELECT * FROM product WHERE id = ?";
		PreparedStatement ps = null;
		ResultSet set = null;
		try {
			ps = connection.prepareStatement(displayProductByIdQuery);
			ps.setInt(1, productId);
			set = ps.executeQuery();

			if (!set.next()) {
				System.out.println("Product with ID " + productId + " does not exist");
				return null;
			}
			Product product = new Product();
			
			product.setId(set.getInt("id"));
			product.setName(set.getString("name"));
			product.setColor(set.getString("color"));
			product.setPrice(set.getDouble("price"));
			product.setMfd(set.getDate("mfd").toLocalDate());
			product.setExpd(set.getDate("expd").toLocalDate());

			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (set != null) {
				try {
					set.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	// Fetch all Product
	// @return List<Product>
	public List<Product> getAllProductDetailsDao(){
		Connection connection = JdbcConnection.getJdbcConnection();
		if(connection == null) {
			System.out.println("Database connection failed ");
			return null;
		}
		String displayAllProductQuery = "select * from product";
		PreparedStatement ps = null;
		try {	
			ps= connection.prepareStatement(displayAllProductQuery);
			ResultSet set = ps.executeQuery();
			List<Product> prods = new ArrayList<Product>();
			
			while(set.next()) {
				Product product = new Product();
				
				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				double price = set.getDouble("price");
				LocalDate mfd = set.getDate("mfd").toLocalDate();
				LocalDate expd = set.getDate("expd").toLocalDate();

				product.setId(id);
				product.setName(name);
				product.setColor(color);
				product.setPrice(price);
				product.setMfd(mfd);
				product.setExpd(expd);

				prods.add(product);
				
			}
			return prods;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	/**
	 * saveMultipleProductDao(List<Product> product)
	 * 
	 * @return List<Product>
	 */
	public List<Product> saveMultipleProductDao(List<Product> products){
		Connection connection = JdbcConnection.getJdbcConnection();
		String insertProductQuery = "INSERT INTO product(id, name, color, price, mfd, expd) VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(insertProductQuery);
			for (Product product : products) {
				ps.setInt(1, product.getId());
				ps.setString(2, product.getName());
				ps.setString(3, product.getColor());
				ps.setDouble(4, product.getPrice());
				ps.setObject(5, product.getMfd());
				ps.setObject(6, product.getExpd());

				ps.addBatch();

			}
			int a[] = ps.executeBatch();
			System.out.println(a.length);
			connection.commit();
			System.out.println("data seved");
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	/**
	 * getProductByPrice(double price)
	 * @return List<Product> 
	 */
	
	public List<Product> getMultipleProductByPriceDao(double price){
		Connection connection = JdbcConnection.getJdbcConnection();
		if(connection==null) {
			System.out.println("Please check db connection");
			return null;
		}
		
		CallableStatement cls = null;
		try {
			cls = connection.prepareCall("call getProductByPrice(?)");
			cls.setDouble(1, price);
			ResultSet set = cls.executeQuery();
			List<Product> prods = new ArrayList<Product>();
			
			while(set.next()) {
				Product product = new Product();
				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				double price1 = set.getDouble("price");
				LocalDate mfd = set.getDate("mfd").toLocalDate();
				LocalDate expd = set.getDate("expd").toLocalDate();

				product.setId(id);
				product.setName(name);
				product.setColor(color);
				product.setPrice(price1);
				product.setMfd(mfd);
				product.setExpd(expd);
				
				prods.add(product);
			}
			
			return prods;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (cls != null) {
				try {
					cls.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	//Update ProductDao
	public Product updateProductDao(Product product) {

	    String updateProductQuery =
	        "UPDATE product SET name = ?, color = ?, price = ?, mfd = ?, expd = ? WHERE id = ?";

	    try (Connection connection = JdbcConnection.getJdbcConnection();
	         PreparedStatement ps = connection.prepareStatement(updateProductQuery)) {

	        ps.setString(1, product.getName());
	        ps.setString(2, product.getColor());
	        ps.setDouble(3, product.getPrice());
	        ps.setObject(4, product.getMfd());
	        ps.setObject(5, product.getExpd());
	        ps.setInt(6, product.getId());

	        int rowsUpdated = ps.executeUpdate();
	        return rowsUpdated > 0 ? product : null;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public int getMaxProductId() {
	    int maxId = 0;
	    String sql = "SELECT MAX(id) AS maxId FROM product";
	    try (Connection con = JdbcConnection.getJdbcConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            maxId = rs.getInt("maxId");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return maxId;
	}


	
}
