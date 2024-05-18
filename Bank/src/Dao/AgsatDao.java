package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionMB;

public class AgsatDao {

	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long agsatid;
	private long memberid;
	private long vamid;
	private Date startdate;
	private Date enddate;
	private long mablaghhargest;
	private long tedadkolagsat;
	private long jamkolagsat;
	private long tedadpardakhti;
	private long jarimetakhirgest;

	public ResultSet SelectByVamId(long vamid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Agsat WHERE VamId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, vamid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void NewAgsat() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Agsat(TarikhShrueAgsat,TarikhPayanAgsat,MablaghHarGest,MemberId,VamId,TedadKolAgsat,JarimeTakhirGest,JamKolleAgsat,TedadPardakhti) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1, this.startdate);
		pstmt.setDate(2, this.enddate);
		pstmt.setLong(3, this.mablaghhargest);
		pstmt.setLong(4, this.memberid);
		pstmt.setLong(5, this.vamid);
		pstmt.setLong(6, this.tedadkolagsat);
		pstmt.setLong(7, this.jarimetakhirgest);
		pstmt.setLong(8, this.jamkolagsat);
		pstmt.setLong(9, 0);

		pstmt.executeUpdate();
	}

	public ResultSet SelectByMemberId(long memberid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Agsat WHERE MemberId=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, memberid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void SabtGestByVamId(long vamid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();
		String sql = "UPDATE Agsat SET TedadPardakhti = TedadPardakhti +1 WHERE VamId=? ";

		pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, vamid);

		pstmt.executeUpdate();
	}

	public long getAgsatid() {
		return agsatid;
	}

	public void setAgsatid(long agsatid) {
		this.agsatid = agsatid;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public long getVamid() {
		return vamid;
	}

	public void setVamid(long vamid) {
		this.vamid = vamid;
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

	public long getMablaghhargest() {
		return mablaghhargest;
	}

	public void setMablaghhargest(long mablaghhargest) {
		this.mablaghhargest = mablaghhargest;
	}

	public long getTedadkolagsat() {
		return tedadkolagsat;
	}

	public void setTedadkolagsat(long tedadkolagsat) {
		this.tedadkolagsat = tedadkolagsat;
	}

	public long getJamkolagsat() {
		return jamkolagsat;
	}

	public void setJamkolagsat(long jamkolagsat) {
		this.jamkolagsat = jamkolagsat;
	}

	public long getTedadpardakhti() {
		return tedadpardakhti;
	}

	public void setTedadpardakhti(long tedadpardakhti) {
		this.tedadpardakhti = tedadpardakhti;
	}

	public long getJarimetakhirgest() {
		return jarimetakhirgest;
	}

	public void setJarimetakhirgest(long jarimetakhirgest) {
		this.jarimetakhirgest = jarimetakhirgest;
	}

}
