package ru.ncedu.dunko.model.DAO;

import java.sql.*; 

import org.apache.log4j.Logger;

import ru.ncedu.dunko.model.POJO.Product;

public class ProductDAO {
	private static final Logger logger = Logger.getLogger(ProductDAO.class);
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public Product getProductByID(int product_id) {
		Product product = new Product();
		try {
			preparedStatement = DBA.getConnection().prepareStatement(
					"SELECT * FROM products WHERE product_id  = ?");
		} catch (SQLException e) {
			logger.error("Error during initialization of prepared statement",e);
		}
		try {
			preparedStatement.setInt(1, product_id);
		} catch (SQLException e) {
			logger.error("Error during finding product by specified id="+product_id,e);
		}
		try {
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			product.setProduct_id(product_id);
			product.setProduct_name(resultSet.getString("product_name"));
			product.setCategory_id(resultSet.getInt("category_id"));
			product.setPrice(resultSet.getInt("price"));
		} catch (SQLException e) {
			logger.error("Error during result set operation",e);
		}
		return product;
	}
}
