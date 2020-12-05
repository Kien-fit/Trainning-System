package jsoft.ads.basic;

import java.sql.*;
import jsoft.*;

public class BasicImpl implements Basic {

	// Bộ quản lý kết nối mà basic sử dụng
	private ConnectionPool cp;

	// Kết nối Basic lấy ra dùng, và chia sẻ cho cấc lớp con cháu
	protected Connection con;

	// tên đối tượng làm việc với Basic
	private String objectName;

	public BasicImpl(ConnectionPool cp, String objectName) {//contrustor đầy dủ tham số vì 'con' phụ thuộc vào 'cp'
		// Xác định đối tượng làm việc với Basic
		this.objectName = objectName;

		// Xác định bộ quản lý kết nối cho Basic
		if (cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}

		// Xin kết nối để làm việc
		try {
			this.con = this.cp.getConnection(this.objectName);

			// Chấm dứt chế độ thực thi tự động của kết nối
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private synchronized boolean exe(PreparedStatement pre) {
		if (pre != null) {
			try {
				int results = pre.executeUpdate();

				// Kiểm tra kết quả
				if (results == 0) {
					this.con.rollback();
					return false;
				}

				// Thực thi câu lệnh chuẩn
				this.con.commit();
				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				// Trở về trạng thái an toàn của kết nối
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				pre = null;
			}
		}

		return false;
	}

	@Override
	public boolean add(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public boolean edit(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public boolean del(PreparedStatement pre) {
		// TODO Auto-generated method stub
		return this.exe(pre);
	}

	@Override
	public ResultSet get(String sql, int value) {
		// TODO Auto-generated method stub

		// Biên dịch câu lệch
		try {
			PreparedStatement preGet = this.con.prepareStatement(sql);

			if (value > 0) {
				preGet.setInt(1, value);
			}

			return preGet.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// Trở lại kết nối an toàn
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			sql = null;
		}

		return null;
	}

	@Override
	public ResultSet get(String sql, String name, String pass) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preGet = this.con.prepareStatement(sql);

			preGet.setString(1, name);
			preGet.setString(2, pass);

			return preGet.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// Trở lại kết nối an toàn
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public ResultSet gets(String sql) {
		// TODO Auto-generated method stub
		return this.get(sql, 0);
	}

	@Override
	public ResultSet[] gets(String[] sqls) {
		// TODO Auto-generated method stub

		ResultSet[] tmp = new ResultSet[sqls.length];

		for (int i = 0; i < sqls.length; i++) {
			tmp[i] = this.get(sqls[i], 0);
		}

		return tmp;
	}

	@Override
	public ConnectionPool getCP() {
		// TODO Auto-generated method stub
		return this.cp;
	}

	@Override
	public void releaseConnection() {
		// TODO Auto-generated method stub
		
		try {
			this.cp.releaseConnection(this.con, this.objectName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
