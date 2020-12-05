package jsoft.ads.agent;

import java.util.*;

import jsoft.objects.*;

public class AgentLibrary {

	public static String viewAgents(ArrayList<AgentObject> items) {
		String tmp = "<table cellspacing=0>";

		//Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Tên</th>";
		tmp += "<th>Địa chỉ</th>";
		tmp += "<th>Diện thoại</th>";
		tmp += "<th>Email</th>";
		tmp += "<th>Website</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th>Ngày tạo</th>";
//		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		//Dòng nội dung
		int NO = 0;
		for (AgentObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>"+NO+"</td>";
			tmp += "<td>"+item.getAgent_name()+"</td>";
			tmp += "<td>"+item.getAgent_address()+"</td>";
			tmp += "<td>"+item.getAgent_phone()+"</td>";
			tmp += "<td>"+item.getAgent_email()+"</td>";
			tmp += "<td>"+item.getAgent_website()+"</td>";
			tmp += "<td>"+item.getAgent_notes()+"</td>";
			tmp += "<td>"+item.getAgent_created_date()+"</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>"+item.getAgent_id()+"</td>";
			tmp += "</tr>";
		}
		
		tmp += "</table>";

		return tmp;
	}
}
