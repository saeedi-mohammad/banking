package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionMB;

public class VamDao {
	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long vamid;
	private long memberid;
	private Date tarikhDarkhast;
	private Date tarikhTakhsis;
	private long hesabid;
	private long mablaghvam;
	private long noevamid;
	private int isAccepted;// 0 No / 1 Yes / 2 Reject

	public void RequestVam() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhDarkhast = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Vam(TarikhDarkhast,HesabId,MablaghVam,NoeVamId,isAccepted) " + "VALUES(?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setDate(1, this.tarikhDarkhast);
		pstmt.setLong(2, this.hesabid);
		pstmt.setLong(3, this.mablaghvam);
		pstmt.setLong(4, this.noevamid);
		pstmt.setInt(5, 0);

		pstmt.executeUpdate();

	}

	public void AcceptVam(long vamid) throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhTakhsis = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "UPDATE Vam SET isAccepted=?,TarikhTakhsis=? WHERE VamId=? ";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, 1);
		pstmt.setDate(2, this.tarikhTakhsis);
		pstmt.setLong(3, vamid);

		pstmt.executeUpdate();

	}

	public void RejectVam(long vamid) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "UPDATE Vam SET isAccepted=? WHERE VamId=? ";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, 2);// 2 is rejected
		pstmt.setLong(2, vamid);

		pstmt.executeUpdate();

	}

	public ResultSet SelectByHesabId(long hesabid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Vam WHERE HesabId=? AND isAccepted=1";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public ResultSet GetAllRequesteds() throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Vam WHERE isAccepted =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public ResultSet SelectByVamId(long vamid) throws SQLException, ClassNotFoundException {
		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Vam WHERE VamId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, vamid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public long getVamid() {
		return vamid;
	}

	public void setVamid(long vamid) {
		this.vamid = vamid;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public Date getTarikhDarkhast() {
		return tarikhDarkhast;
	}

	public void setTarikhDarkhast(Date tarikhDarkhast) {
		this.tarikhDarkhast = tarikhDarkhast;
	}

	public Date getTarikhTakhsis() {
		return tarikhTakhsis;
	}

	public void setTarikhTakhsis(Date tarikhTakhsis) {
		this.tarikhTakhsis = tarikhTakhsis;
	}

	public long getHesabid() {
		return hesabid;
	}

	public void setHesabid(long hesabid) {
		this.hesabid = hesabid;
	}

	public long getMablaghvam() {
		return mablaghvam;
	}

	public void setMablaghvam(long mablaghvam) {
		this.mablaghvam = mablaghvam;
	}

	public long getNoevamid() {
		return noevamid;
	}

	public void setNoevamid(long noevamid) {
		this.noevamid = noevamid;
	}

	public int getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}

}
