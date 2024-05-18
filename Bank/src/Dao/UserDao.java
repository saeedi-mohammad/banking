package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionMB;

public class UserDao {

	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long memberid;
	private String name;
	private String family;
	private long mellicode;
	private String phone;
	private String adress;
	private String username;
	private String password;
	private String date;

	public long CheakUserLogin(String user, String pass) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM member WHERE username = ? AND password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user);
		pstmt.setString(2, pass);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			this.memberid = rs.getInt("MemberId");
			this.name = rs.getString("name");
			this.family = rs.getString("family");
			this.mellicode = rs.getInt("MelliCode");
			this.adress = rs.getString("adress");
			this.phone = rs.getString("phone");
			this.username = rs.getString("username");
			this.password = rs.getString("password");

			// Display values
			System.out.println(memberid + " " + name + " " + family + " " + mellicode + " " + adress + " " + phone);

			// Last Check
			if (username.equals(user) && password.equals(pass)) {
				return memberid;
			}

		}

		return 0;
	}

	public void AddNewUser() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO member(name,family,MelliCode,adress,phone,username,password,birthdate) "
				+ "VALUES(?,?,?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, this.name);
		pstmt.setString(2, this.family);
		pstmt.setLong(3, this.mellicode);
		pstmt.setString(4, this.adress);
		pstmt.setString(5, this.phone);
		pstmt.setString(6, this.username);
		pstmt.setString(7, this.password);
		pstmt.setString(8, this.date);

		pstmt.executeUpdate();
	}

	public void AddNewOtherUser() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO member(name,family,MelliCode) " + "VALUES(?,?,?)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, this.name);
		pstmt.setString(2, this.family);
		pstmt.setLong(3, this.mellicode);

		pstmt.executeUpdate();
	}

	@SuppressWarnings("null")
	public long SelectByMellicode(long mellicode) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM member WHERE MelliCode = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, mellicode);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			return rs.getLong("MemberId");

		}
		return (Long) null;
	}

	public ResultSet SelectByMemberId(long memid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM member WHERE MemberId = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, memid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void Remove(long memberid) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "DELETE FROM member WHERE MemberId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, memberid);

		pstmt.executeUpdate();
	}

	public ResultSet SelectAll() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM member";
		stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		return rs;

	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getMellicode() {
		return mellicode;
	}

	public void setMellicode(long mellicode) {
		this.mellicode = mellicode;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
