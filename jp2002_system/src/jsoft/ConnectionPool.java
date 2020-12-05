package jsoft;

import java.sql.*;

public interface ConnectionPool {
	
	//Xin ket noi tu he thong
	public Connection getConnection(String objectName) throws SQLException;
	
	//Tra lai ket noi sau khi dung
	public void releaseConnection(Connection con, String objectName) throws SQLException;

}
