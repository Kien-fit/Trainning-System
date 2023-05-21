package jsoft.ads.calendar;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class CalendarControl {

	private CalendarModel cm;

	public CalendarControl(ConnectionPool cp) {
		this.cm = new CalendarModel(cp);
	}

	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	// ------------------------------------------------
		public boolean addCalendar(CalendarObject item) {
			return this.cm.addCalendar(item);
		}

		public boolean editCalendar(CalendarObject item) {
			return this.cm.editCalendar(item);
		}

		public boolean delCalendar(CalendarObject item) {
			return this.cm.delCalendar(item);
		}

		// ------------------------------------------------
		public CalendarObject getCalendarObject(int id) {
			return this.cm.getCalendarObject(id);
		}

		public String getCalendarObject(CalendarObject similar, short page, byte total) {

			ArrayList<CalendarObject> items = new ArrayList<>();

			return CalendarLibrary.viewCalendars(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
