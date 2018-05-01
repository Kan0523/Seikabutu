import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtil;

public class dbtest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int request = 0;

		DBUtil dbUtils = new DBUtil();

		Connection con = dbUtils.getConnection();

		PreparedStatement ps = null;
		// 型をセット
		ps = con.prepareStatement("select * from test where id = ?");

		// パラメータを設定
		ps.setInt(1, request);

		// exequte実行
		  ResultSet rs = ps.executeQuery();

		  while(rs.next()) {
			  System.out.println(rs.getInt("id"));
		  }




	}

}
