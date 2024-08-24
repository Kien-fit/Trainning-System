package jsoft.ads.product.pg;

import java.util.*;

import jsoft.objects.*;

public class ProductGroupLibrary {

	public static String viewProductGroup(ArrayList<ProductGroupObject> items) {
		String tmp = "<table cellspacing=0>";

		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Hệ sản phẩm</th>";
		tmp += "<th>Nhóm sản phẩm</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		int NO = 0;
		for (ProductGroupObject item : items) {
			NO++;

			tmp += (NO%2==0)?"<tr class=\"even\">":"<tr>";
			tmp += "<td class=\"NO\">" + NO + "</td>";
			tmp += "<td class=\"PS_NAME\">" + item.getPs_name() + "</td>";
			tmp += "<td class=\"NAME\">" + item.getPg_name() + "</td>";
			tmp += "<td class=\"CREATED_DATE\">" + item.getPg_created_date() + "</td>";
			tmp += "<td class=\"NOTES\">" + item.getPg_notes() + "</td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/pg/ae?id="+item.getPg_id()+"\">Sửa</a></td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/pg/ae?id="+item.getPg_id()+"\">Xóa</a></td>";
			tmp += "<td class=\"ID\">" + item.getPg_id() + "</td>";
			tmp += "</tr>";
		}
		tmp += "</table>";
		return tmp;
	}

	public static String viewProductSystemOptions(ArrayList<ProductSystemObject> items) {
		String tmp = "";
		
		for(ProductSystemObject item : items) {
			tmp +="<option value=\""+item.getPs_id()+"\">";
			tmp += item.getPs_name();
			tmp += "</option>";		
		}
		return tmp;
	}
}
