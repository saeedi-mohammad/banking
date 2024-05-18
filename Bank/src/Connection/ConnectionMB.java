package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMB {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/glib2";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "1234";

	private Connection conn = null;

////////////// STEP 4: Execute a query
//			stmt = conn.createStatement();
//
////			String sql = "INSERT INTO member VALUES ('101', 'mamad', 'akba', 'nobar','099922154','2000/05/01','15')";
////			stmt.executeUpdate(sql);
//
//			String sql = "SELECT mno, name, family FROM member";
//			ResultSet rs = stmt.executeQuery(sql);
//			// STEP 5: Extract data from result set
//			while (rs.next()) {
//				// Retrieve by column name
//				String mno = rs.getString("mno");
//				String name = rs.getString("name");
//				String family = rs.getString("family");
//
	public Connection StartConnection() throws ClassNotFoundException, SQLException {

		// STEP 2: Register JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// STEP 3: Open a connection
		System.out.println("Connecting to a selected database...");
		this.conn = DriverManager.getConnection("jdbc:sqlserver://msi:1433;databaseName=test", USER, PASS);

		System.out.println("Connected database successfully...");

		return this.conn;

	}

	public void StopConnection() throws SQLException {

		this.conn = null;
		this.conn.close();
	}

}
