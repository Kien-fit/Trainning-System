package jsoft.ads.calendar;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Calendar extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addCalendar(CalendarObject item);
	public boolean editCalendar(CalendarObject item);
	public boolean delCalendar(CalendarObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getCalendar(int id);
	public ResultSet getCalendars(CalendarObject similar, int at, byte total);

}
