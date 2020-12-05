package jsoft.ads.basic;

import java.sql.*;
import jsoft.*;

public interface Basic extends ShareControl {
//	Cac chuc nang cap nhat
	// public boolean add();
	public boolean add(PreparedStatement pre);//Pre - đã được biên dịch và truyền giá trị
	public boolean edit(PreparedStatement pre);
	public boolean del(PreparedStatement pre);

//	Cac chuc nang lay du lieu
	//public Object get(int value);
	public ResultSet get(String sql, int value);//value thường là id
	//public Object get(String name, String pass);
	public ResultSet get(String sql, String name, String pass);
	//public Object[] gets();
	public ResultSet gets(String sql);
	public ResultSet[] gets(String[] sqls);

//chuyển sang interface ShareControl
//	//Các chức năng điều khiển chia sẻ bộ quản lý kết nối giữa các Basic 
//	public ConnectionPool getCP();
//	public void releaseConnection();

}
