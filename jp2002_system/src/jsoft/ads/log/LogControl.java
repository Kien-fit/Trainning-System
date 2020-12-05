package jsoft.ads.log;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class LogControl {

	private Log log;

	public LogControl(ConnectionPool cp, String objectname) {
		this.log = new LogImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.log = null;
		super.finalize();
	}

	public void relaeseConnection() {
		this.log.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.log.getCP();
	}
	
	// ------------------------------------------------
		public boolean addLog(LogObject item) {
			return this.log.addLog(item);
		}

		public boolean editLog(LogObject item) {
			return this.log.editLog(item);
		}

		public boolean delLog(LogObject item) {
			return this.log.delLog(item);
		}

		// ------------------------------------------------
		public LogObject getLogObject(short id) {
			LogObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.log.getLog(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new LogObject();
						item.setLog_id(rs.getShort("log_id"));
						item.setLog_name(rs.getString("log_name"));
						item.setLog_user_name(rs.getString("log_user_name"));
						item.setLog_user_permission(rs.getShort("log_user_permission"));
						item.setLog_date(rs.getString("log_date"));
						item.setLog_action(rs.getShort("log_action"));
						item.setLog_position(rs.getShort("log_posstion"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<LogObject> getLogObject(LogObject similar, short page, byte total) {

			ArrayList<LogObject> items = new ArrayList<LogObject>();

			LogObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.log.getLogs(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new LogObject();
						item.setLog_id(rs.getShort("log_id"));
						item.setLog_name(rs.getString("log_name"));
						item.setLog_user_name(rs.getString("log_user_name"));
						item.setLog_user_permission(rs.getShort("log_user_permission"));
						item.setLog_date(rs.getString("log_date"));
						item.setLog_action(rs.getShort("log_action"));
						item.setLog_position(rs.getShort("log_posstion"));
						
						items.add(item);
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return items;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
