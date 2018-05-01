package service;

import java.sql.Connection;
import java.util.List;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import beans.UserMessage;
import dao.MessageDao;
import dao.UserMessageDao;

public class MessageService {

	public void register(Message message) {


			Connection connection = null;
			try {
				connection = getConnection();

				MessageDao messageDao = new MessageDao();
				messageDao.insert(connection, message);

				commit(connection);
			}catch(RuntimeException e) {
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

		private static final int LIMIT_NUM = 1000;
		public List<UserMessage> getMessage(){

		Connection connection = null ;
		try {
		connection = getConnection();



		UserMessageDao messageDao = new UserMessageDao();
		List<UserMessage> ret = messageDao.getUserMessages(connection,LIMIT_NUM);


		commit(connection);

		return ret;
	}catch (RuntimeException e) {
		rollback(connection);
		throw e;
	}catch (Error e) {
		rollback(connection);
		throw e;
	}finally {
		close(connection);
	}


}
		private Connection getConnection() {



			return null;
		}

		public void register(beans.Message message) {
			// TODO 自動生成されたメソッド・スタブ

		}


}



