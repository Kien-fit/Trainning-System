package jsoft.ads.statistic;

import java.util.*;

import jsoft.objects.*;

public class StatisticLibrary {

	public static String viewStatistics(ArrayList<StatisticObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
//		tmp += "<th></th>";
//		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		for (StatisticObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getStatistic_visited() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getStatistic_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
