package jsoft;

import java.sql.*;
import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool {

	// Trình điều khiển làm việc với CSDL
	private String driver;

	// Đường dẫn thực thi MySQL
	private String url;

	// Tài khoản làm việc vời CSDL MySQL
	private String username;
	private String userpass;

	// Đối tượng để lưu trũ kết nối
	private Stack<Connection> pool;

	public ConnectionPoolImpl() {
		// Xác định trình điều khiển
		this.driver = "com.mysql.jdbc.Driver";

		// Nạp trình điều khiển
		this.loadDriver();

		// Xác định đường dẫn thực thi
		this.url = "jdbc:mysql://localhost:3306/jp2002_data";

		// Xác định tài khoản làm việc
		this.username = "jp2002_kien";
		this.userpass = "123456";
		
		//Khởi tạo bộ nhớ đối tượng lưu trữ
		this.pool = new Stack<Connection>();
	}

	/**
	 * Phương thức nạp trình điều khiển
	 */
	private void loadDriver() {
		try {
			Class.forName(this.driver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// TODO Auto-generated method stub

		// Kiểm tra kết nối trong ngăn xếp
		if (this.pool.isEmpty()) {
			// Tạo kết nối mới
			System.out.println(objectName + " have create a new Connection.");
			return DriverManager.getConnection(this.url, this.username, this.userpass);

		} else {
			// Lấy kết nối đã tồn tại
			System.out.println(objectName + " have poped the Connection.");
			return (Connection) this.pool.pop();
		}

	}

	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub

		// Trả lại kết nối cho hệ thống
		System.out.println(objectName + " have pushed the Connection.");
		this.pool.push(con);
	}
	
	protected void finalize() throws Throwable {
		this.driver = null;
		this.username=null;
		this.userpass=null;
		this.url=null;
		
		this.pool.clear();
		this.pool=null;
		
		//System.gc();
		super.finalize();
		
		//System.runFinalization();
		System.out.println("ConnectionPool is close!");
	}

}
