package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionMB;

public class NoeHesabDao {

	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	public ResultSet GetAll() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "SELECT * FROM NoeHesab";
		stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		return rs;
	}

	public long getIdByName(String name) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();
		String sql = "SELECT * FROM NoeHesab WHERE HesabName =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);

		ResultSet rs = pstmt.executeQuery();

		long a = rs.getInt("NoeHesabId");

		return a;
	}

	public String getNameById(long id) throws ClassNotFoundException, SQLException {

		System.out.println(id);
		Connection conn = connection.StartConnection();
		String sql = "SELECT * FROM NoeHesab WHERE NoeHesabId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		String s = "";
		while (rs.next()) {
			s = rs.getString("HesabName");
		}

		return s;
	}
}
