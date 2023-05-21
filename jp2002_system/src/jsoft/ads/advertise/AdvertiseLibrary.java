package jsoft.ads.advertise;

import java.util.*;

import jsoft.objects.*;

public class AdvertiseLibrary {

	public static String viewAdvertises(ArrayList<AdvertiseObject> items) {
		String tmp = "<table cellspacing=0>";

		//Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Tiêu đề</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th>Kiểu</th>";
		tmp += "<th>Hiển thị</th>";
		tmp += "<th>Hình ảnh</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		//Dòng nội dung
		int NO = 0;
		for (AdvertiseObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>"+NO+"</td>";
			tmp += "<td>"+item.getAdvertise_title()+"</td>";
			tmp += "<td>"+item.getAdvertise_url()+"</td>";
			tmp += "<td>"+item.getAdvertise_notes()+"</td>";
			tmp += "<td>"+item.getAdvertise_type()+"</td>";
			tmp += "<td>"+item.isAdvertise_display()+"</td>";
			tmp += "<td>"+item.getAdvertise_image()+"</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>"+item.getAdvertise_id()+"</td>";
			tmp += "</tr>";
		}
		
		tmp += "</table>";

		return tmp;
	}
}
