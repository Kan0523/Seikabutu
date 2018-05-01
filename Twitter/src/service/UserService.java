package service;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;

import org.apache.catalina.User;
import org.omg.CORBA.portable.InputStream;

import dao.UserDao;
import utils.CipherUtil;
import utils.StreamUtil;

public class UserService {

	public void register(User user) {


		Connection connection = null;

	    try {
	    		connection = getConnetion();

	    		String encPassword = CipherUtil.encrypt(user.getPassword());
	    		user.setPassword(encPassword);

	    		setDefaultIcon(user);

	    		UserDao userDao = new UserDao();
	    		userDao.insert(connection,user);

	    		commit(connection);
	    	}catch(RuntimeException e) {
	    		rollback(connection);
	    		throw e;
	    	}catch (Error e) {
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

	private Connection getConnetion() {

		return null;
	}

	private void setDefaultIcon(User user) {
		InputStream is = null;
		try {
			long randomNum = System.currentTimeMillis() % 5;
			String filePath = "/duke_" + randomNum +".jpg";
			is = (InputStream) UserService.class.getResourceAsStream(filePath);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			StreamUtil.copy(is,baos);
			((beans.User) user).setIcon(baos.toByteArray());
		}finally {
			close(is);
		}
	}

	private void close(InputStream is) {

	}

	public beans.User getUser(int parseInt) {

		return null;
	}

	public void update(beans.User editUser) {

	}
}
