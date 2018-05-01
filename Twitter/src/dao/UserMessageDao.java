package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserMessage;


public class UserMessageDao {

	private Connection connection;
	@SuppressWarnings("null")
	public Connection getConnection() throws ClassNotFoundException{

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FORM user_message ");

			sql.append("ORDER BY insert_date DESC limit " + connection);
			Connection connection = null;

			ps = connection.prepareStatement(sql.toString());

			@SuppressWarnings("unused")
			ResultSet rs = ps.executeQuery();


		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection ;

		}

	private void close(ResultSet rs) {


	}
	@SuppressWarnings("unused")
	private List<UserMessage> toUserMessageList(ResultSet rs) throws SQLException {

		List<UserMessage> ret = new ArrayList<UserMessage>();
		try {
			while(rs.next()) {
				String account = rs.getString("account");
				String name = rs.getString("name");
				int id = rs.getInt("id");
				int userId = rs.getInt("user_id");
				String text = rs.getString("text");
				java.sql.Timestamp insertDate = rs.getTimestamp("insert_date");

				UserMessage message = new UserMessage();
				message.setAccount(account);
				message.setName(name);
				message.setId(id);
				message.setUserId(userId);
				message.setText(text);
				message.setInsertDate(insertDate);

				ret.add(message);
			}
			return ret;
		}finally {
			close(rs);
		}


	}

	public List<UserMessage> getUserMessages(Connection connection2, int limitNum) {
		
		return null;
	}


}
