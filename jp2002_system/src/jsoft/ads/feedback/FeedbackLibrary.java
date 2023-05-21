package jsoft.ads.feedback;

import java.util.*;
import jsoft.objects.*;

public class FeedbackLibrary {

	public static String viewFeedbacks(ArrayList<FeedbackObject> items) {
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
		for (FeedbackObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getFeedback_email() + "</td>";
			tmp += "<td>" + item.getFeedback_fullname() + "</td>";
			tmp += "<td>" + item.getFeedback_phone() + "</td>";
			tmp += "<td>" + item.getFeedback_title() + "</td>";
			tmp += "<td>" + item.getFeedback_content() + "</td>";
			tmp += "<td>" + item.getFeedback_created_date() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getFeedback_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
