package connect;

import java.sql.Connection;

public class DBConnect {
	private final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanGiayDep;encrypt=true;trustServerCertificate=true";
	private final String USER_NAME = "sa";
	private final String PASSWORD = "123";
	
	public Connection getConnection() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return java.sql.DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
	}
}
