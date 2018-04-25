package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DRIVER = "org.hsqldb.jdbcDriver";
	private static final String URL = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PASSWORD = "";

	static {

		try {
			Class.forName(DRIVER);
		}catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);

			connection.setAutoCommit(false);

			return connection;
		}catch(SQLException e) {
			throw new SQLRuntimeException(e);
		}
	}

	public static void commit(Connection connection) {

		try {
			connection.commit();
		}catch(SQLException e) {
			throw new SQLRuntimeException(e);
		}
	}

	public static void rollback(Connection connection) {

		try {
			connection.rollback();
		}catch(SQLException e) {
			throw new SQLRuntimeException(e);
		}
	}

}
