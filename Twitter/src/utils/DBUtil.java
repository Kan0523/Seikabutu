package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/message";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";

//	static {
//
//		try {
//			Class.forName(DRIVER);
//		}catch(ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
//	}

	public Connection getConnection() throws ClassNotFoundException {

		// コネクションの変数宣言
		Connection connection = null;
		try {
			// driverの型を取得する（com.mysql.jdbc.Driver）
			Class.forName(DRIVER);
			// コネクションを取得する
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
			// 自動コミットを使用しない
			connection.setAutoCommit(false);

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void commit(Connection connection) {

		try {
			connection.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection connection) {

		try {
			connection.rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
