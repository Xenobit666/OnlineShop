package ru.ncedu.dunko.model.DAO;

import java.sql.*;

import org.apache.log4j.Logger;

import ru.ncedu.dunko.model.POJO.Category;

public class CategoryDAO {
	private static final Logger logger = Logger.getLogger(CategoryDAO.class);
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public Category getCategoryByID(int category_id) {
		Category category = new Category();
		try {
			preparedStatement = DBA.getConnection().prepareStatement(
					"SELECT * FROM categories WHERE category_id  = ?");
		} catch (SQLException e) {
			logger.error("Error during initialization of prepared statement",e);
		}
		try {
			preparedStatement.setInt(1, category_id);
		} catch (SQLException e) {
			logger.error("Error during finding product by specified id="+category_id,e);
		}
		try {
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			category.setCategory_id(category_id);
			category.setCategory_name(resultSet.getString("category_name"));
			category.setMain_category_id(resultSet.getInt("main_category_id"));
		} catch (SQLException e) {
			logger.error("Error during result set operation",e);
		}
		return category;
	}
}
