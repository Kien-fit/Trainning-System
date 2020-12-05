package jsoft.ads.log;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class LogImpl extends BasicImpl implements Log {
	
	public LogImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addLog(LogObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tbllog (";
		sql += "log_name, ";
		sql += "log_user_permission, ";
		sql += "log_date, ";
		sql += "log_user_name, ";
		sql += "log_action, ";
		sql += "log_position ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getLog_name());
			pre.setShort(2, item.getLog_user_permission());
			pre.setString(3, item.getLog_date());
			pre.setString(4, item.getLog_user_name());
			pre.setShort(5, item.getLog_action());
			pre.setShort(6, item.getLog_position());
			
			return this.add(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean editLog(LogObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tbllog SET ";
		sql += "log_name=?, ";
		sql += "log_user_permission=?, ";
		sql += "log_date=?, ";
		sql += "log_user_name=?, ";
		sql += "log_action=?, ";
		sql += "log_position=? ";
		
		sql += "WHERE log_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getLog_name());
			pre.setShort(2, item.getLog_user_permission());
			pre.setString(3, item.getLog_date());
			pre.setString(4, item.getLog_user_name());
			pre.setShort(5, item.getLog_action());
			pre.setShort(6, item.getLog_position());
			
			pre.setInt(7, item.getLog_id());
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean delLog(LogObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tbllog WHERE log_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getLog_id());
			
			return this.del(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		return false;
	}
	
	private boolean isEmpty(LogObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getLog_id()+")";
		
		ResultSet rs = this.gets(sql);
		if(rs!=null) {
			try {
				if(rs.next()) {
					flag = false;
				}
				
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}


	@Override
	public ResultSet getLog(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tbllog WHERE log_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getLogs(LogObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tbllog ";
		sql += "";
		sql += "ORDER BY log_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
