package jsoft.ads.comment;

import java.util.*;

import jsoft.objects.*;

public class CommentLibrary {

	public static String viewComments(ArrayList<CommentObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Tiêu đề</th>";
		tmp += "<th>Giới thiệu</th>";
		tmp += "<th>Nội dung</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Điện thoại</th>";
		tmp += "<th>Họ tên</th>";
		tmp += "<th>Email</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		for (CommentObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getComment_title() + "</td>";
			tmp += "<td>" + item.getComment_content_intro() + "</td>";
			tmp += "<td>" + item.getComment_content() + "</td>";
			tmp += "<td>" + item.getComment_created_date() + "</td>";
			tmp += "<td>" + item.getComment_user_phone() + "</td>";
			tmp += "<td>" + item.getComment_user_fullname() + "</td>";
			tmp += "<td>" + item.getComment_user_email() + "</td>";
			tmp += "<td>" + item.getComment_notes() + "</td>";
			tmp += "<td>" + item.getComment_type_id() + "</td>";
			tmp += "<td>" + item.getComment_for_name() + "</td>";
			tmp += "<td>" + item.getComment_for_id() + "</td>";
			tmp += "<td>" + item.isComment_enabled() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getComment_id() + "</td>";
			tmp += "</tr>";
		}
		tmp += "</table>";

		return tmp;
	}
}
