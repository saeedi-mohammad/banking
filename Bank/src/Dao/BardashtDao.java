package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import Connection.ConnectionMB;

public class BardashtDao {
	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long bardashtid;
	private long memberid;
	private Date tarikh;
	private long operatorid;
	private long hesabid;
	private long mablaghbardasht;

	public void RequestBardasht() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikh = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Bardasht(Tarikh,MemberId,HesabId,MablaghBardasht,isSet,time) "
				+ "VALUES(?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setDate(1, this.tarikh);
		pstmt.setLong(2, this.memberid);
		pstmt.setLong(3, this.hesabid);
		pstmt.setLong(4, this.mablaghbardasht);
		pstmt.setInt(5, 0);
		pstmt.setTime(6, new Time(tarikh.getTime()));
		System.out.println(new Time(tarikh.getTime()));

		pstmt.executeUpdate();

	}

	public ResultSet GetAllRequesteds() throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Bardasht WHERE isSet =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void SetBardasht() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikh = sqlDate;

		System.out.println(this.operatorid);
		Connection conn = connection.StartConnection();
		String sql = "UPDATE Bardasht SET isSet=?, OperatorId=?, Tarikh=?,time=? WHERE BardashtId=? ";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, 1);
		pstmt.setLong(2, this.operatorid);
		pstmt.setDate(3, this.tarikh);
		pstmt.setLong(4, this.bardashtid);
		pstmt.setTime(5, new Time(tarikh.getTime()));

		pstmt.executeUpdate();

		// this.setBardashtid(pstmt.executeUpdate());

	}

	public Boolean isPenalty(long hesabid, long memberid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Bardasht WHERE HesabId =? AND MemberId=? AND isSet=0";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);
		pstmt.setLong(2, memberid);

		ResultSet rs = pstmt.executeQuery();

//		while (rs.next()) {
//			System.out.println("ssssss:" + rs.getLong("BardashtId"));
//		}
		while (rs.next()) {
			System.out.println("ssssssss");
			return true;
		}
		return false;

	}

	public void ForceBardasht() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikh = sqlDate;

		Connection conn = connection.StartConnection();

		if (this.operatorid == (long) 0) {

			String sql = "INSERT INTO Bardasht(Tarikh,MemberId,HesabId,MablaghBardasht,isSet,time) "
					+ "VALUES(?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikh);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghbardasht);
			pstmt.setInt(5, 1);
			pstmt.setTime(6, new Time(tarikh.getTime()));
		}

		else {
			String sql = "INSERT INTO Bardasht(Tarikh,MemberId,HesabId,MablaghBardasht,isSet,OperatorId,time) "
					+ "VALUES(?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikh);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghbardasht);
			pstmt.setInt(5, 1);
			pstmt.setLong(6, this.operatorid);
			pstmt.setTime(7, new Time(tarikh.getTime()));

		}
		pstmt.executeUpdate();

	}

	public void Remove(long bardashtid) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "DELETE FROM Bardasht WHERE BardashtId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, bardashtid);

		pstmt.executeUpdate();
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}

	public Date getTarikh() {
		return tarikh;
	}

	public void setTarikh(Date tarikh) {
		this.tarikh = tarikh;
	}

	public long getHesabid() {
		return hesabid;
	}

	public void setHesabid(long hesabid) {
		this.hesabid = hesabid;
	}

	public long getMablaghbardasht() {
		return mablaghbardasht;
	}

	public void setMablaghbardasht(long mablaghbardasht) {
		this.mablaghbardasht = mablaghbardasht;
	}

	public long getBardashtid() {
		return bardashtid;
	}

	public void setBardashtid(long bardashtid) {
		this.bardashtid = bardashtid;
	}

}
