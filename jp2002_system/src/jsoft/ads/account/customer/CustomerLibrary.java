package jsoft.ads.account.customer;

import java.util.*;

import jsoft.objects.*;

public class CustomerLibrary {

	public static String viewCustomers(ArrayList<CustomerObject> items) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
//		tmp += "<th></th>";
//		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		for (CustomerObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>" + NO + "</td>";
			tmp += "<td>" + item.getCustomer_fullname() + "</td>";
			tmp += "<td>" + item.getCustomer_address() + "</td>";
			tmp += "<td>" + item.getCustomer_phone() + "</td>";
			tmp += "<td>" + item.getCustomer_email() + "</td>";
			tmp += "<td>" + item.getCustomer_notes() + "</td>";
			tmp += "<td>" + item.getCustomer_code() + "</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>" + item.getCustomer_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}
}
