package ru.ncedu.dunko.model.DAO;

import java.sql.*;

import org.apache.log4j.Logger;

import ru.ncedu.dunko.model.POJO.Customer;

public class CustomerDAO {
	private static final Logger logger = Logger.getLogger(CustomerDAO.class);
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public Customer getCustomerByID(int customer_id) {
		Customer customer = new Customer();
		try {
			preparedStatement = DBA.getConnection().prepareStatement(
					"SELECT * FROM customers WHERE customer_id  = ?");
		} catch (SQLException e) {
			logger.error("Error during initialization of prepared statement",e);
		}
		try {
			preparedStatement.setInt(1, customer_id);
		} catch (SQLException e) {
			logger.error("Error during finding product by specified id="+customer_id,e);
		}
		try {
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			customer.setCustomer_id(customer_id);
			customer.setName(resultSet.getString("name"));
			customer.setAddress(resultSet.getString("address"));
			customer.setPhone_number(resultSet.getInt("phone_number"));
		} catch (SQLException e) {
			logger.error("Error during result set operation",e);
		}
		return customer;
	}
}
