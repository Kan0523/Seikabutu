package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Message;


public class MessageDao {

	public void insert(Connection connection,Message message) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO message(");
			sql.append("id");
			sql.append(", user_id");
			sql.append(", text");
			sql.append(", insert_date");
			sql.append(", update_date");
			sql.append(") VALUE (");
			sql.append("NEXT VALUE FOR my_seq ");
			sql.append(", ?");
			sql.append(", ?");
			sql.append(", CURRENT_TIMESTART");
			sql.append(", CURRENT_TIMESTART");
			sql.append(")");

			ps = connection.prepareStatement(sql.toString());

			ps.setInt(1, message.getUserId());
			ps.setString(2, message.getText());

			ps.executeUpdate();
		}catch (SQLException e) {

		}finally {
			close(ps);
		}
	}

	private void close(PreparedStatement ps) {
		}

	public void insert(Connection connection, com.sun.corba.se.impl.protocol.giopmsgheaders.Message message) {

	}

}
