package ru.ncedu.dunko.model.DAO;

import java.sql.*;  
import org.apache.log4j.Logger;


public class DBA {

	private static final Logger logger = Logger.getLogger(DBA.class);
	private static Connection connection = null;

	public static void establishConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to start a driver");
			logger.fatal("Driver problem occured",e);
		}
		try {
			connection = DriverManager
		          .getConnection("jdbc:mysql://localhost/online_shop",
		              "user","userpw");
		} catch(SQLException e) {
			System.out.println("Connection failure");
			logger.fatal("DB connection problem occured", e);
		}
	}
	
	public static Connection getConnection() {
		if (connection==null) {
			establishConnection();
		}
			return connection;
	}
	
	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			logger.error("Couldn't close connection",e);
		}
	}
}
