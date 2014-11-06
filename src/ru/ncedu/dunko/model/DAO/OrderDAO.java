package ru.ncedu.dunko.model.DAO;

import java.sql.*;

import org.apache.log4j.Logger;

import ru.ncedu.dunko.model.POJO.Order;

public class OrderDAO {
	private static final Logger logger = Logger.getLogger(OrderDAO.class);
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public Order getOrderByID(int order_id) {
		Order order = new Order();
		try {
			preparedStatement = DBA.getConnection().prepareStatement(
					"SELECT * FROM orders WHERE order_id  = ?");
		} catch (SQLException e) {
			logger.error("Error during initialization of prepared statement",e);
		}
		try {
			preparedStatement.setInt(1, order_id);
		} catch (SQLException e) {
			logger.error("Error during finding product by specified id="+order_id,e);
		}
		try {
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			order.setOrder_id(order_id);
			order.setCustomer_id(resultSet.getInt("customer_id"));
			order.setProduct_id(resultSet.getInt("product_id_id"));
			order.setQuantity(resultSet.getInt("quantity"));
		} catch (SQLException e) {
			logger.error("Error during result set operation",e);
		}
		return order;
	}
}
