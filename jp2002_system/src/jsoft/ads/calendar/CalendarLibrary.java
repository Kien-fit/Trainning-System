package jsoft.ads.calendar;

import java.util.*;

import jsoft.objects.*;

public class CalendarLibrary {

	public static String viewCalendars(ArrayList<CalendarObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
//		tmp += "<th></th>";
//		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		for (CalendarObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getCalendar_title() + "</td>";
			tmp += "<td>" + item.getCalendar_user_name() + "</td>";
			tmp += "<td>" + item.getCalendar_visited() + "</td>";
			tmp += "<td>" + item.getCalendar_notes() + "</td>";
//			tmp += "<td>" + item.getCalendar_() + "</td>";
//			tmp += "<td>" + item.getCalendar_() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getCalendar_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
