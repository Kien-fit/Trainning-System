package jsoft.ads.calendar;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class CalendarModel {

	private Calendar cal;

	public CalendarModel(ConnectionPool cp) {
		this.cal = new CalendarImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.cal = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.cal.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.cal.getCP();
	}

	// ------------------------------------------------
		public boolean addCalendar(CalendarObject item) {
			return this.cal.addCalendar(item);
		}

		public boolean editCalendar(CalendarObject item) {
			return this.cal.editCalendar(item);
		}

		public boolean delCalendar(CalendarObject item) {
			return this.cal.delCalendar(item);
		}

		// ------------------------------------------------
		public CalendarObject getCalendarObject(int id) {
			CalendarObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.cal.getCalendar(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new CalendarObject();
						item.setCalendar_id(rs.getShort("calendar_id"));
//						item.setCalendar_name(rs.getString("calendar_name"));
//						item.setCalendar_notes(rs.getString("calendar_notes"));
//						item.setCalendar_created_date(rs.getString("calendar_created_date"));
//						item.setCalendar_last_modified(rs.getString("calendar_last_modified"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<CalendarObject> getCalendarObjects(CalendarObject similar, short page, byte total) {

			ArrayList<CalendarObject> items = new ArrayList<CalendarObject>();

			CalendarObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.cal.getCalendars(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new CalendarObject();
						item.setCalendar_id(rs.getShort("calendar_id"));
//						item.setCalendar_name(rs.getString("calendar_name"));
//						item.setCalendar_notes(rs.getString("calendar_notes"));
//						item.setCalendar_created_date(rs.getString("calendar_created_date"));
//						item.setCalendar_last_modified(rs.getString("calendar_last_modified"));
						
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
