package jsoft.ads.label;

import java.util.*;

import jsoft.objects.*;

public class LabelLibrary {

	public static String viewLabels(ArrayList<LabelObject> items) {
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
		for (LabelObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getLabel_title() + "</td>";
			tmp += "<td>" + item.getLabel_notes() + "</td>";
			tmp += "<td>" + item.getLabel_infors() + "</td>";
			tmp += "<td>" + item.getLabel_infors_en() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getLabel_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
