package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionMB;

public class HesabDao {

	ConnectionMB connection = new ConnectionMB();
	PreparedStatement pstmt = null;
	Statement stmt = null;

	private long noehesabid;
	private long memberid;
	private long hesabid;
	private long mojudihesab;
	private Boolean isActive;
	private Date tarikhijad;

	public void IjadHesab() throws ClassNotFoundException, SQLException {

		this.mojudihesab = 0;
		this.isActive = false;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		this.tarikhijad = sqlDate;

		Connection conn = connection.StartConnection();
		String sql = "INSERT INTO Hesab(MemberId,NoeHesabId,MojudiHesab,isActive,TarikhIjadHesab) "
				+ "VALUES(?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, this.memberid);
		pstmt.setLong(2, this.noehesabid);
		pstmt.setLong(3, this.mojudihesab);
		pstmt.setInt(4, ConvertToInt(this.isActive));
		pstmt.setDate(5, this.tarikhijad);

		pstmt.executeUpdate();

	}

	public ResultSet GetAllRequested() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Hesab WHERE isActive=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void SetActive(long id) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "UPDATE Hesab SET isActive =1 WHERE Hesabid =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);

		pstmt.executeUpdate();
	}

	public void Bastanhesab(long hesabid) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "UPDATE Hesab SET isActive=0 WHERE HesabId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);

		pstmt.executeUpdate();
	}

	public Boolean CheckActive(long id) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT isActive FROM Hesab WHERE HesabId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
			if (ConvertToBoolean(rs.getInt("isActive")))
				return true;
		return false;
	}

	public long getMojudi(long hesabid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();
		String sql = "SELECT * FROM Hesab WHERE HesabId=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, hesabid);

		ResultSet rs = pstmt.executeQuery();

		long a = 0;
		while (rs.next()) {
			a = rs.getLong("MojudiHesab");
		}
		return a;

	}

	public ResultSet SelectByMemberId(long memid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Hesab WHERE MemberId=? AND isActive=1";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, memid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public ResultSet SelectByHesabId(long hesabid) throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Hesab WHERE HesabId=? AND isActive=1";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void CustMojudi(long hesabid, long newMojudi) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "UPDATE Hesab SET MojudiHesab=? WHERE HesabId=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, newMojudi);
		pstmt.setLong(2, hesabid);

		pstmt.executeUpdate();

		// this.setBardashtid(pstmt.executeUpdate());

	}

	public void IncreaseMojudi(long hesabid, long mablag) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();
		String sql = "UPDATE Hesab SET MojudiHesab=MojudiHesab+? WHERE HesabId=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, mablag);
		pstmt.setLong(2, hesabid);

		pstmt.executeUpdate();

		// this.setBardashtid(pstmt.executeUpdate());
	}

	public ResultSet GetAllRequesteds() throws ClassNotFoundException, SQLException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Hesab WHERE isActive =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);

		ResultSet rs = pstmt.executeQuery();

		return rs;
	}

	public void Remove(long hesabid) throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "DELETE FROM Hesab WHERE HesabId =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, hesabid);

		pstmt.executeUpdate();
	}

	public ResultSet SelectAll() throws SQLException, ClassNotFoundException {

		Connection conn = connection.StartConnection();

		String sql = "SELECT * FROM Hesab";
		stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		return rs;

	}

	private int ConvertToInt(Boolean isActive) {

		if (isActive)
			return 1;
		return 0;
	}

	private Boolean ConvertToBoolean(int isActive2) {

		if (this.isActive)
			return true;
		return false;
	}

	public Date getTarikhijad() {
		return tarikhijad;
	}

	public void setTarikhijad(Date tarikhijad) {
		this.tarikhijad = tarikhijad;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public long getMojudihesab() {
		return mojudihesab;
	}

	public void setMojudihesab(long mojudihesab) {
		this.mojudihesab = mojudihesab;
	}

	public long getHesabid() {
		return hesabid;
	}

	public void setHesabid(long hesabid) {
		this.hesabid = hesabid;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public long getNoehesabid() {
		return noehesabid;
	}

	public void setNoehesabid(long noehesabid) {
		this.noehesabid = noehesabid;
	}

}