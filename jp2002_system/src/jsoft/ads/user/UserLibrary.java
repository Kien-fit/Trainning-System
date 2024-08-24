package jsoft.ads.user;

import java.util.*;
import jsoft.objects.*;

public class UserLibrary {

	public static String viewUsers(ArrayList<UserObject> items, UserObject user) {
		String tmp = "<table cellspacing=0>";

		// Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Tên đăng nhập</th>";
		tmp += "<th>Tên đầy đủ</th>";
		tmp += "<th>Địa chỉ</th>";
		tmp += "<th>Hộp thư</th>";
		tmp += "<th>Điện thoại</th>";
		tmp += "<th>Số lần đăng nhập</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "<th></th>";
		tmp += "</tr>";

		// Dòng nội dung
		int NO = 0;
		UserObject item;
		for (int i = 0; i < items.size(); i++) {

			++NO;// Số thứ tự
			item = items.get(i);// Lấy từng đối tượng để trình bày

			tmp += (NO%2==0) ? "<tr class=\"even\">" : "<tr>";
			
			tmp += "<td class=\"NO\">" + NO + "</td>";
			tmp += "<td class=\"NAME\">" + item.getUser_name() + "</td>";
			tmp += "<td class=\"FULLNAME\">" + item.getUser_fullname() + "</td>";
			tmp += "<td class=\"ADDRESS\">" + item.getUser_address() + "</td>";
			tmp += "<td class=\"EMAIL\">" + item.getUser_email() + "</td>";
			tmp += "<td class=\"PHONE\">" + item.getUser_homephone() + "</td>";
			//tmp += "<td class=\"LOGINED\">" + item.getUser_last_logined() + "</td>";
			tmp += "<td class=\"LOGINED\">" + item.getUser_logined() + "</td>";
			
			tmp += "<td class=\"ED\"><a href=\"/adv/user/ae?id="+item.getUser_id()+"\">Sửa</a></td>";
			
			if(item.getUser_id()==user.getUser_id()) {
				tmp += "<td class=\"ED\">...</td>";								
			}else {
				tmp += "<td class=\"ED\"><a href=\"javascript:confirmDel('/adv/user/del?id="+item.getUser_id()+"'); void(0);\">Xóa</a></td>";				
			}
			
			tmp += "<td class=\"ID\">" + item.getUser_id() + "</td>";
			tmp += "</tr>";
		}

		tmp += "</table>";

		return tmp;
	}

}
