package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import Connection.ConnectionMB;

public class VarizDao {
	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long varizid;
	private long memberid;
	private Date tarikh;
	private long operatorid;
	private long hesabid;
	private long mablaghvariz;

	public void RequestVariz() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikh = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Variz(Tarikh,MemberId,HesabId,MablaghVariz,isSet,time) " + "VALUES(?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setDate(1, this.tarikh);
		pstmt.setLong(2, this.memberid);
		pstmt.setLong(3, this.hesabid);
		pstmt.setLong(4, this.mablaghvariz);
		pstmt.setInt(5, 0);
		pstmt.setTime(6, new Time(tarikh.getTime()));

		pstmt.executeUpdate();

	}

	public ResultSet GetAllRequesteds() throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Variz WHERE isSet =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void SetVariz() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikh = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "UPDATE Variz SET isSet=?, OperatorId=?, Tarikh=?,time=? WHERE VarizId=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, 1);
		pstmt.setLong(2, this.operatorid);
		pstmt.setDate(3, this.tarikh);
		pstmt.setLong(4, this.varizid);
		pstmt.setTime(5, new Time(tarikh.getTime()));

		pstmt.executeUpdate();

		// this.setBardashtid(pstmt.executeUpdate());

	}

	public Boolean isPenalty(long hesabid, long memberid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Variz WHERE HesabId =? AND MemberId=? AND isSet=0";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);
		pstmt.setLong(2, memberid);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			System.out.println("ssssssss");
			return true;
		}
		return false;

	}

	public void ForceVariz() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikh = sqlDate;

		Connection conn = connection.StartConnection();

		if (this.operatorid == (long) 0) {
			String sql = "INSERT INTO Variz(Tarikh,MemberId,HesabId,MablaghVariz,isSet,time) " + "VALUES(?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikh);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghvariz);
			pstmt.setInt(5, 1);
			pstmt.setTime(6, new Time(tarikh.getTime()));
		}

		else {

			String sql = "INSERT INTO Variz(Tarikh,MemberId,HesabId,MablaghVariz,isSet,OperatorId,time) "
					+ "VALUES(?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikh);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghvariz);
			pstmt.setInt(5, 1);
			pstmt.setLong(6, this.operatorid);
			pstmt.setTime(7, new Time(tarikh.getTime()));
		}
		pstmt.executeUpdate();

	}

	public void Remove(long varizid) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "DELETE FROM Variz WHERE VarizId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, varizid);

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

	public long getMablaghvariz() {
		return mablaghvariz;
	}

	public void setMablaghvariz(long mablaghvariz) {
		this.mablaghvariz = mablaghvariz;
	}

	public long getVarizid() {
		return varizid;
	}

	public void setVarizid(long varizid) {
		this.varizid = varizid;
	}

}
