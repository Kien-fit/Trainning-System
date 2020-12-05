package jsoft.ads.value;

import java.util.*;
import jsoft.objects.*;

public class ValueLibrary {

	public static String viewValues(ArrayList<ValueObject> items) {
		String tmp = "<table cellspacing=0>\n";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>1</th>";
		tmp += "<th>2</th>";
		tmp += "<th>3</th>";
		tmp += "<th>4</th>";
		tmp += "<th>5</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "<th></th>";
		tmp += "</tr>\n";

		// Dòng nội dung
		int NO = 0;
		ValueObject item;
		for (int i = 0; i < items.size(); i++) {

			++NO;// Số thứ tự
			item = items.get(i);// Lấy từng đối tượng để trình bày

			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getValue_1() + "</td>";
			tmp += "<td>" + item.getValue_2() + "</td>";
			tmp += "<td>" + item.getValue_3() + "</td>";
			tmp += "<td>" + item.getValue_4() + "</td>";
			tmp += "<td>" + item.getValue_5() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getValue_id() + "</td>";
			tmp += "</tr>\n";
		}

		tmp += "</table>";

		return tmp;
	}

}
