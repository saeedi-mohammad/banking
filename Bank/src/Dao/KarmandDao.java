package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionMB;

public class KarmandDao {

	private long operatorid;
	private String name;
	private String family;
	private String phone;
	private String adress;
	private long mellicode;
	private String username;
	private String password;

	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	public ResultSet CheakKarmandLogin(String user, String pass) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Operator WHERE username = ? AND password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user);
		pstmt.setString(2, pass);

//		stmt = conn.createStatement();
//		String sql = "SELECT * FROM Operator WHERE username = ?";
//		ResultSet rs = stmt.executeQuery(sql);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	// set and gets
	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public long getMellicode() {
		return mellicode;
	}

	public void setMellicode(long mellicode) {
		this.mellicode = mellicode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
