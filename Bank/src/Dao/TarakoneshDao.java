package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import Connection.ConnectionMB;

public class TarakoneshDao {
	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long tarakoneshid;
	private long memberid;
	private Date tarikhdarkhast;
	private Date tarikhsabt;
	private long operatorid;
	private long hesabid;
	private long mablaghtarakonesh;
	private String noetarakonesh;

	public void RequestBardasht() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhdarkhast = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Tarakonesh(TarikhDarkhast,MemberId,HesabId,MablaghTarakonesh,isSet,ZamanTarakonesh,NoeTarakonesh) "
				+ "VALUES(?,?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setDate(1, this.tarikhdarkhast);
		pstmt.setLong(2, this.memberid);
		pstmt.setLong(3, this.hesabid);
		pstmt.setLong(4, this.mablaghtarakonesh);
		pstmt.setInt(5, 0);
		pstmt.setTime(6, new Time(tarikhdarkhast.getTime()));
		pstmt.setString(7, "برداشت");

		pstmt.executeUpdate();

	}

	public ResultSet GetAllBRequesteds() throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Tarakonesh WHERE isSet =? AND NoeTarakonesh=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setString(2, "برداشت");

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void SetBardasht() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhsabt = sqlDate;

		System.out.println(this.operatorid);
		Connection conn = connection.StartConnection();
		String sql = "UPDATE Tarakonesh SET isSet=?, OperatorId=?, TarikhSabt=?,ZamanTarakonesh=? WHERE TarakoneshId=? ";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, 1);
		pstmt.setLong(2, this.operatorid);
		pstmt.setDate(3, this.tarikhsabt);
		pstmt.setTime(4, new Time(tarikhsabt.getTime()));
		pstmt.setLong(5, this.tarakoneshid);

		pstmt.executeUpdate();

		// this.setBardashtid(pstmt.executeUpdate());

	}

	public Boolean isPenalty(long hesabid, long memberid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		System.out.println(hesabid);
		System.out.println(memberid);

		String sql = "SELECT * FROM Tarakonesh WHERE HesabId =? AND MemberId=? AND isSet=0";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);
		pstmt.setLong(2, memberid);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			return true;
		}
		return false;

	}

	public void ForceBardasht() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhsabt = sqlDate;

		Connection conn = connection.StartConnection();

		if (this.operatorid == (long) 0) {

			String sql = "INSERT INTO Tarakonesh(TarikhSabt,MemberId,HesabId,MablaghTarakonesh,isSet,ZamanTarakonesh,NoeTarakonesh) "
					+ "VALUES(?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikhsabt);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghtarakonesh);
			pstmt.setInt(5, 1);
			pstmt.setTime(6, new Time(tarikhsabt.getTime()));
			pstmt.setString(7, "برداشت");
		}

		else {
			String sql = "INSERT INTO Tarakonesh(TarikhSabt,MemberId,HesabId,MablaghTarakonesh,isSet,OperatorId,ZamanTarakonesh,NoeTarakonesh) "
					+ "VALUES(?,?,?,?,?,?,?.?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikhsabt);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghtarakonesh);
			pstmt.setInt(5, 1);
			pstmt.setLong(6, this.operatorid);
			pstmt.setTime(7, new Time(tarikhsabt.getTime()));
			pstmt.setString(7, "برداشت");

		}
		pstmt.executeUpdate();

	}

	public void Remove(long tarakoneshid) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "DELETE FROM Tarakonesh WHERE TarakoneshId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, tarakoneshid);

		pstmt.executeUpdate();
	}

	public void RequestVariz() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhdarkhast = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Tarakonesh(TarikhDarkhast,MemberId,HesabId,MablaghTarakonesh,isSet,ZamanTarakonesh,NoeTarakonesh) "
				+ "VALUES(?,?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setDate(1, this.tarikhdarkhast);
		pstmt.setLong(2, this.memberid);
		pstmt.setLong(3, this.hesabid);
		pstmt.setLong(4, this.mablaghtarakonesh);
		pstmt.setInt(5, 0);
		pstmt.setTime(6, new Time(tarikhdarkhast.getTime()));
		pstmt.setString(7, "واریز");

		pstmt.executeUpdate();

	}

	public ResultSet GetAllVRequesteds() throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Tarakonesh WHERE isSet =? AND NoeTarakonesh=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		pstmt.setString(2, "واریز");

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void SetVariz() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhsabt = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "UPDATE Tarakonesh SET isSet=?, OperatorId=?, TarikhSabt=?,ZamanTarakonesh=? WHERE TarakoneshId=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, 1);
		pstmt.setLong(2, this.operatorid);
		pstmt.setDate(3, this.tarikhsabt);
		pstmt.setTime(4, new Time(tarikhsabt.getTime()));
		pstmt.setLong(5, this.tarakoneshid);

		pstmt.executeUpdate();

		// this.setBardashtid(pstmt.executeUpdate());

	}

	public void ForceVariz() throws SQLException, ClassNotFoundException {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhsabt = sqlDate;

		Connection conn = connection.StartConnection();

		if (this.operatorid == (long) 0) {
			String sql = "INSERT INTO Tarakonesh(TarikhSabt,MemberId,HesabId,MablaghTarakonesh,isSet,ZamanTarakonesh,NoeTarakonesh) "
					+ "VALUES(?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikhsabt);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghtarakonesh);
			pstmt.setInt(5, 1);
			pstmt.setTime(6, new Time(tarikhsabt.getTime()));
			pstmt.setString(7, "واریز");
		}

		else {

			String sql = "INSERT INTO Tarakonesh(TarikhSabt,MemberId,HesabId,MablaghTarakonesh,isSet,OperatorId,ZamanTarakonesh,NoeTarakonesh) "
					+ "VALUES(?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setDate(1, this.tarikhsabt);
			pstmt.setLong(2, this.memberid);
			pstmt.setLong(3, this.hesabid);
			pstmt.setLong(4, this.mablaghtarakonesh);
			pstmt.setInt(5, 1);
			pstmt.setLong(6, this.operatorid);
			pstmt.setTime(7, new Time(tarikhsabt.getTime()));
			pstmt.setString(8, "واریز");

		}
		pstmt.executeUpdate();

	}

	public ResultSet getAllTByTarikh(Date date1, Date date2) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Tarakonesh WHERE isSet=1 AND TarikhSabt BETWEEN ? AND ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setDate(1, date1);
		pstmt.setDate(2, date2);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public ResultSet SelectTByTarikh(Date date1, Date date2, long hesabid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Tarakonesh WHERE isSet=1 AND HesabId=? AND TarikhSabt BETWEEN ? AND ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);
		pstmt.setDate(2, date1);
		pstmt.setDate(3, date2);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public ResultSet SelectTByNumber(int number, long hesabid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM (SELECT TOP (?) * FROM Tarakonesh WHERE HesabId=? ORDER BY TarakoneshId DESC) SQ ORDER BY TarakoneshId ASC";
		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, number);
		pstmt.setLong(2, hesabid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public ResultSet getAllTByNumber(int number) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM (SELECT TOP (?) * FROM Tarakonesh ORDER BY TarakoneshId DESC) SQ ORDER BY TarakoneshId ASC";
		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, number);

		ResultSet rs = pstmt.executeQuery();

		return rs;
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

	public long getHesabid() {
		return hesabid;
	}

	public void setHesabid(long hesabid) {
		this.hesabid = hesabid;
	}

	public long getMablaghtarakonesh() {
		return mablaghtarakonesh;
	}

	public void setMablaghtarakonesh(long mablaghtarakonesh) {
		this.mablaghtarakonesh = mablaghtarakonesh;
	}

	public long getTarakoneshid() {
		return tarakoneshid;
	}

	public void setTarakoneshid(long tarakoneshid) {
		this.tarakoneshid = tarakoneshid;
	}

	public Date getTarikhdarkhast() {
		return tarikhdarkhast;
	}

	public void setTarikhdarkhast(Date tarikhdarkhast) {
		this.tarikhdarkhast = tarikhdarkhast;
	}

	public Date getTarikhsabt() {
		return tarikhsabt;
	}

	public void setTarikhsabt(Date tarikhsabt) {
		this.tarikhsabt = tarikhsabt;
	}

	public String getNoetarakonesh() {
		return noetarakonesh;
	}

	public void setNoetarakonesh(String noetarakonesh) {
		this.noetarakonesh = noetarakonesh;
	}

}
