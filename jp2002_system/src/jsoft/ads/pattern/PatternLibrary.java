package jsoft.ads.pattern;

import java.util.*;
import jsoft.objects.*;

public class PatternLibrary {

	public static String viewPatterns(ArrayList<PatternObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Ảnh</th>";
		tmp += "<th>Tiêu đề</th>";
		tmp += "<th>Tóm tắt</th>";
		tmp += "<th>Chi tiết</th>";
		tmp += "<th>Mã</th>";
		tmp += "<th>PS_ID</th>";
		tmp += "<th>PG_ID</th>";
		tmp += "<th>PC_ID</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		for (PatternObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getPattern_image() + "</td>";
			tmp += "<td>" + item.getPattern_title() + "</td>";
			tmp += "<td>" + item.getPattern_summary() + "</td>";
			tmp += "<td>" + item.getPattern_detail() + "</td>";
			tmp += "<td>" + item.getPattern_code() + "</td>";
			tmp += "<td>" + item.getPattern_ps_id() + "</td>";
			tmp += "<td>" + item.getPattern_pg_id() + "</td>";
			tmp += "<td>" + item.getPattern_pc_id() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getPattern_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
