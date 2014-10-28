package ru.ncedu.dunko.model.DAO;

import java.sql.*;
import org.apache.log4j.Logger;


public class DBA {

	private static final Logger logger = Logger.getLogger(DBA.class);
	static Connection connection = null;
		
	public void EstablishConnection() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager
			          .getConnection("jdbc:mysql://localhost/online_shop?"
			              + "user=sqluser&password=sqluserpw");
			} catch(Exception e) {
				logger.fatal("DB connection problem occured", e);
			}
		} catch (Exception e) {
			logger.fatal("Driver problem occured",e);
		}
	}
}
