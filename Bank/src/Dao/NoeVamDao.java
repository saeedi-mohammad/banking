package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionMB;

public class NoeVamDao {
	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	public ResultSet GetAll() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "SELECT * FROM NoeVam";
		stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		return rs;
	}

	public String GetNameByNoeVamId(long noevamid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM NoeVam WHERE NoeVamId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, noevamid);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
			return rs.getString("VamName");
		return "";
	}
}
