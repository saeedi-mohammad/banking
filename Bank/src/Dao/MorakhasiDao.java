package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import Connection.ConnectionMB;

public class MorakhasiDao {

	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long morakhasiid;
	private long operatorid;
	private Date startdate;
	private Date enddate;
	private Time starttime;

	private Time endtime;

	public void AddMorakhasi() throws ClassNotFoundException, SQLException

	{

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Morakhasi(OperatorId,StartDate,EndDate,StartTime,EndTime) " + "VALUES(?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, this.operatorid);
		pstmt.setDate(2, this.startdate);
		pstmt.setDate(3, this.enddate);
		pstmt.setTime(4, this.starttime);
		pstmt.setTime(5, this.endtime);

		pstmt.executeUpdate();

	}

	public ResultSet SelectAll() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Morakhasi";
		stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		return rs;

	}

	public long getMorakhasiid() {
		return morakhasiid;
	}

	public void setMorakhasiid(long morakhasiid) {
		this.morakhasiid = morakhasiid;
	}

	public long getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(long operatorid) {
		this.operatorid = operatorid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Time getStarttime() {
		return starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public Time getEndtime() {
		return endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

}
