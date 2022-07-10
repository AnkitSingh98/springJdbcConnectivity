package com.courseTheory.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.courseTheory.helper.ProductRowMapper;
import com.courseTheory.models.Product;

@Repository
public class ProductRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// Create  ************************************************************************************
		public Product createProduct(Product p) {
			
			String query = "insert into product(productId,productName,productDesc,productPrice,stock) values(?,?,?,?,?)";
			int x = jdbcTemplate.update(query,p.getProductId(),p.getProductName(),p.getProductDesc(),p.getProductPrice(),p.isStock());
			System.out.println("Rows affected = " + x);
			return p;
		}
		
		
		// Update  **********************************************************************************
		public Product updateProduct(Product p, int pid) {
			
			
			String query = "update product set productName=?,productDesc=?,productPrice=?,stock=?  where productId=?";
			jdbcTemplate.update(query, p.getProductName(),p.getProductDesc(),p.getProductPrice(),p.isStock(),pid);
			
			p.setProductId(pid);
			
			System.out.println(p);
			return p;	
		}
		
		
		// Delete by id *******************************************************************************
		public void deleteProduct(int pid) {
			
			 String query = "delete from product where productId = ?";
			 jdbcTemplate.update(query,pid);
		}
		
		
		// Get single Product  ************************************************************************
		public Product getProduct(int pid) {
			
			String query = "select * from product where productId = ?";
			
			Product p = jdbcTemplate.queryForObject(query, new RowMapper<Product>() {
						
				//NOTE: we could have used ProductRowMapper class also(as done below in Get all products) here but just for example that  we can do this also doing this  
				
				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					Product p = new Product();
					p.setProductId(rs.getInt("productId"));
					p.setProductName(rs.getString("productName"));
					p.setProductDesc(rs.getString("productDesc"));
					p.setProductPrice(rs.getDouble("productPrice"));
					p.setStock(rs.getBoolean("stock"));
					
					return p;
				}
						
			}, pid);
			
			return p;
			
		}
		
		
		// Get all Product  **************************************************************
		public List<Product> getAllProducts(){
			
			String query = "Select * from product";
			
			List<Product> list = jdbcTemplate.query(query, new ProductRowMapper());
			
			return list;
		}
		
		

}
