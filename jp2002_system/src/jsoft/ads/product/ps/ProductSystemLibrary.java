package jsoft.ads.product.ps;

import java.util.*;

import jsoft.objects.*;

public class ProductSystemLibrary {

	public static String viewProductSystem(ArrayList<ProductSystemObject> items) {
		String tmp = "<table cellspacing=0>";

		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Hệ sản phẩm</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		int NO = 0;
		for (ProductSystemObject item : items) {
			NO++;
			
			tmp += (NO%2==0)?"<tr class=\"even\">":"<tr>";
			tmp += "<td class=\"NO\">"+NO+"</td>";
			tmp += "<td class=\"NAME\">"+item.getPs_name()+"</td>";
			tmp += "<td class=\"CREATED_DATE\">"+item.getPs_created_date()+"</td>";
			tmp += "<td class=\"NOTES\">"+item.getPs_notes()+"</td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/ps/ae?id="+item.getPs_id()+"\">Sửa</a></td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/ps/ae?id="+item.getPs_id()+"\">Xóa</a></td>";
			tmp += "<td class=\"ID\">"+item.getPs_id()+"</td>";
			tmp += "</tr>";
		}
		tmp += "</table>";
		return tmp;
	}

}
