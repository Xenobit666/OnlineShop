package ru.ncedu.dunko.model.DAO;

import java.sql.*;

import org.apache.log4j.Logger;

import ru.ncedu.dunko.model.DAO.DBA;
import ru.ncedu.dunko.model.POJO.Product;

public class ProductDAO {
	private static final Logger logger = Logger.getLogger(ProductDAO.class);
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public Product getProductByID(int product_id) {
		Product product = new Product();
		try {
			preparedStatement = DBA.connection.prepareStatement(
					"SELECT * FROM products WHERE product_id  = ?");
			preparedStatement.setInt(1, product_id);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			product.setProduct_id(product_id);
            product.setProduct_name(resultSet.getString("product_name"));
            product.setCategory_id(resultSet.getInt("category_id"));
            product.setPrice(resultSet.getInt("price"));
		} catch (SQLException e) {
			logger.error("No such product, id=" + product_id,e);
			e.printStackTrace();
		}
		return product;
	}

}
