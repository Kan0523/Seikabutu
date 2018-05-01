package service;

import java.sql.Connection;

import org.apache.catalina.User;

import dao.UserDao;
import utils.CipherUtil;

public class LoginService {

	public User login(String accountOrEmail,String password) {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
			String encPassword = CipherUtil.encrypt(password);
			User user = (User) userDao.getUser(connection,accountOrEmail, encPassword);

				commit(connection);
					return user;
		}catch(RuntimeException e) {
			rollback(connection);
			throw e;
		}catch(Error e) {
			rollback(connection);
			throw e;
		}finally {
			close(connection);
		}
	}



	private void close(Connection connection) {


	}



	private void rollback(Connection connection) {


	}



	private void commit(Connection connection) {


	}



	private Connection getConnection() {

		return null;
	}



	public User getUser(int userId) {

		Connection connection = null;
		try {
			connection = getConnection();

			UserDao userDao = new UserDao();
			User user = (User) userDao.getUser(connection, userId);

			commit(connection);

			return user;
		}catch(RuntimeException e) {
			rollback(connection);
			throw e;
		}finally {
			close(connection);
		}
	}
}


