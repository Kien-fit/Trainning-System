package jsoft.ads.pattern;

import java.util.*;

import jsoft.objects.*;

public class PatternLibrary {

	public static String viewAccounts(ArrayList<AccountObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Tài khoản khách hàng</th>";
		tmp += "<th>Tiền trong tài khoản</th>";
		tmp += "<th>Ngày kích hoạt</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th>Số tiền hiện tại</th>";
		tmp += "<th>Kiểu</th>";
//		tmp += "<th></th>";
//		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		for (AccountObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getAccount_customer_id() + "</td>";
			tmp += "<td>" + item.getAccount_money() + "</td>";
			tmp += "<td>" + item.getAccount_actived_date() + "</td>";
			tmp += "<td>" + item.getAccount_notes() + "</td>";
			tmp += "<td>" + item.getAccount_current_money() + "</td>";
			tmp += "<td>" + item.getAccount_type() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getAccount_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
