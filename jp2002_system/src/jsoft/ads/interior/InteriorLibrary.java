package jsoft.ads.interior;

import java.util.*;

import jsoft.objects.*;

public class InteriorLibrary {

	public static String viewInteriors(ArrayList<InteriorObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
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
		for (InteriorObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getInterior_model() + "</td>";
			tmp += "<td>" + item.getInterior_color() + "</td>";
			tmp += "<td>" + item.getInterior_size() + "</td>";
			tmp += "<td>" + item.getInterior_product_code() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getInterior_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
