package jsoft.ads.calendar;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class CalendarImpl extends BasicImpl implements Calendar {
	
	public CalendarImpl(ConnectionPool cp) {
		super(cp, "Calendar");
	}

	@Override
	public boolean addCalendar(CalendarObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblcalendar (";
		sql += "calendar_title, ";
		sql += "calendar_created_date, ";
		sql += "calendar_firstdateofweek, ";
		sql += "calendar_firstdateofweek_lunar, ";
		sql += "calendar_mon_1, ";
		sql += "calendar_mon_2, ";
		sql += "calendar_mon_3, ";
		sql += "calendar_tue_1, ";
		sql += "calendar_tue_2, ";
		sql += "calendar_tue_3, ";
		sql += "calendar_wed_1, ";
		sql += "calendar_wed_2, ";
		sql += "calendar_wed_3, ";
		sql += "calendar_thu_1, ";
		sql += "calendar_thu_2, ";
		sql += "calendar_thu_3, ";
		sql += "calendar_fri_1, ";
		sql += "calendar_fri_2, ";
		sql += "calendar_fri_3, ";
		sql += "calendar_sat_1, ";
		sql += "calendar_sat_2, ";
		sql += "calendar_sat_3, ";
		sql += "calendar_sun_1, ";
		sql += "calendar_sun_2, ";
		sql += "calendar_sun_3, ";
		sql += "calendar_notes_mon, ";
		sql += "calendar_notes_tue, ";
		sql += "calendar_notes_wed, ";
		sql += "calendar_notes_thu, ";
		sql += "calendar_notes_fri, ";
		sql += "calendar_notes_sat, ";
		sql += "calendar_notes_sun, ";
		sql += "calendar_notes, ";
		sql += "calendar_priority, ";
		sql += "calendar_user_name, ";
		sql += "calendar_visited ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getCalendar_title());
			pre.setString(2, item.getCalendar_created_date());
			pre.setString(3, item.getCalendar_firstdateofweek());
			pre.setString(4, item.getCalendar_firstdateofweek_lunar());
			pre.setString(5, item.getCalendar_mon_1());
			pre.setString(6, item.getCalendar_mon_2());
			pre.setString(7, item.getCalendar_mon_3());
			pre.setString(8, item.getCalendar_tue_1());
			pre.setString(9, item.getCalendar_tue_2());
			pre.setString(10, item.getCalendar_thu_3());
			pre.setString(11, item.getCalendar_wed_1());
			pre.setString(12, item.getCalendar_wed_2());
			pre.setString(13, item.getCalendar_wed_3());
			pre.setString(17, item.getCalendar_thu_1());
			pre.setString(18, item.getCalendar_thu_2());
			pre.setString(19, item.getCalendar_thu_3());
			pre.setString(14, item.getCalendar_fri_1());
			pre.setString(15, item.getCalendar_fri_2());
			pre.setString(16, item.getCalendar_fri_3());
			pre.setString(20, item.getCalendar_sat_1());
			pre.setString(21, item.getCalendar_sat_2());
			pre.setString(22, item.getCalendar_sat_3());
			pre.setString(23, item.getCalendar_sun_1());
			pre.setString(24, item.getCalendar_sun_2());
			pre.setString(25, item.getCalendar_sun_3());
			pre.setString(26, item.getCalendar_notes_mon());
			pre.setString(27, item.getCalendar_notes_tue());
			pre.setString(28, item.getCalendar_notes_wed());
			pre.setString(29, item.getCalendar_notes_thu());
			pre.setString(30, item.getCalendar_notes_fri());
			pre.setString(31, item.getCalendar_notes_sat());
			pre.setString(32, item.getCalendar_notes_mon());
			pre.setString(33, item.getCalendar_notes());
			pre.setBoolean(34, item.isCalendar_priority());
			pre.setString(35, item.getCalendar_user_name());
			pre.setInt(36, item.getCalendar_visited());
			
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
	public boolean editCalendar(CalendarObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblcalendar (";
		sql += "calendar_title=?, ";
		sql += "calendar_created_date=?, ";
		sql += "calendar_firstdateofweek=?, ";
		sql += "calendar_firstdateofweek_lunar=?, ";
		sql += "calendar_mon_1=?, ";
		sql += "calendar_mon_2=?, ";
		sql += "calendar_mon_3=?, ";
		sql += "calendar_tue_1=?, ";
		sql += "calendar_tue_2=?, ";
		sql += "calendar_tue_3=?, ";
		sql += "calendar_wed_1=?, ";
		sql += "calendar_wed_2=?, ";
		sql += "calendar_wed_3=?, ";
		sql += "calendar_thu_1=?, ";
		sql += "calendar_thu_2=?, ";
		sql += "calendar_thu_3=?, ";
		sql += "calendar_fri_1=?, ";
		sql += "calendar_fri_2=?, ";
		sql += "calendar_fri_3=?, ";
		sql += "calendar_sat_1=?, ";
		sql += "calendar_sat_2=?, ";
		sql += "calendar_sat_3=?, ";
		sql += "calendar_sun_1=?, ";
		sql += "calendar_sun_2=?, ";
		sql += "calendar_sun_3=?, ";
		sql += "calendar_notes_mon=?, ";
		sql += "calendar_notes_tue=?, ";
		sql += "calendar_notes_wed=?, ";
		sql += "calendar_notes_thu, ";
		sql += "calendar_notes_fri=?, ";
		sql += "calendar_notes_sat=?, ";
		sql += "calendar_notes_sun=?, ";
		sql += "calendar_notes=?, ";
		sql += "calendar_priority=?, ";
		sql += "calendar_user_name=?, ";
		sql += "calendar_visited=?, ";
		
		sql += "WHERE calendar_id=?";
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getCalendar_title());
			pre.setString(2, item.getCalendar_created_date());
			pre.setString(3, item.getCalendar_firstdateofweek());
			pre.setString(4, item.getCalendar_firstdateofweek_lunar());
			pre.setString(5, item.getCalendar_mon_1());
			pre.setString(6, item.getCalendar_mon_2());
			pre.setString(7, item.getCalendar_mon_3());
			pre.setString(8, item.getCalendar_tue_1());
			pre.setString(9, item.getCalendar_tue_2());
			pre.setString(10, item.getCalendar_thu_3());
			pre.setString(11, item.getCalendar_wed_1());
			pre.setString(12, item.getCalendar_wed_2());
			pre.setString(13, item.getCalendar_wed_3());
			pre.setString(17, item.getCalendar_thu_1());
			pre.setString(18, item.getCalendar_thu_2());
			pre.setString(19, item.getCalendar_thu_3());
			pre.setString(14, item.getCalendar_fri_1());
			pre.setString(15, item.getCalendar_fri_2());
			pre.setString(16, item.getCalendar_fri_3());
			pre.setString(20, item.getCalendar_sat_1());
			pre.setString(21, item.getCalendar_sat_2());
			pre.setString(22, item.getCalendar_sat_3());
			pre.setString(23, item.getCalendar_sun_1());
			pre.setString(24, item.getCalendar_sun_2());
			pre.setString(25, item.getCalendar_sun_3());
			pre.setString(26, item.getCalendar_notes_mon());
			pre.setString(27, item.getCalendar_notes_tue());
			pre.setString(28, item.getCalendar_notes_wed());
			pre.setString(29, item.getCalendar_notes_thu());
			pre.setString(30, item.getCalendar_notes_fri());
			pre.setString(31, item.getCalendar_notes_sat());
			pre.setString(32, item.getCalendar_notes_mon());
			pre.setString(33, item.getCalendar_notes());
			pre.setBoolean(34, item.isCalendar_priority());
			pre.setString(35, item.getCalendar_user_name());
			pre.setInt(36, item.getCalendar_visited());

			pre.setInt(37, item.getCalendar_id());
			
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
	public boolean delCalendar(CalendarObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}

		String sql = "DELETE FROM tblcalendar WHERE calendar_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setInt(1, item.getCalendar_id());

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

	public boolean isEmpty(CalendarObject item) {
		boolean flag = true;

		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id = " + item.getCalendar_id() + ") ";
		ResultSet rs = this.gets(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}


	@Override
	public ResultSet getCalendar(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblcalendar WHERE calendar_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getCalendars(CalendarObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblcalendar ";
		sql += "";
		sql += "ORDER BY calendar_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
