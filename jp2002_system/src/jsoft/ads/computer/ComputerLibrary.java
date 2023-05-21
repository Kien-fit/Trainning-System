package jsoft.ads.computer;

import java.util.*;

import jsoft.objects.*;

public class ComputerLibrary {

	public static String viewComputers(ArrayList<ComputerObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Mã sản phẩm</th>";
//		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		for (ComputerObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getComputer_product_code() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getComputer_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
