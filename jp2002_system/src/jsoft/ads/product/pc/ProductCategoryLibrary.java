package jsoft.ads.product.pc;

import java.util.*;

import jsoft.objects.*;

public class ProductCategoryLibrary {

	public static String viewProductCategory(ArrayList<ProductCategoryObject> items) {
		String tmp = "<table cellspacing=0>";

		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Hệ sản phẩm</th>";
		tmp += "<th>Nhóm sản phẩm</th>";
		tmp += "<th>Loại sản phẩm</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		int NO = 0;
		for (ProductCategoryObject item : items) {
			NO++;

			tmp += (NO%2==0)?"<tr class=\"even\">":"<tr>";
			tmp += "<td class=\"NO\">" + NO + "</td>";
			tmp += "<td class=\"PS_NAME\">" + item.getPs_name() + "</td>";
			tmp += "<td class=\"PG_NAME\">" + item.getPg_name() + "</td>";
			tmp += "<td class=\"NAME\">" + item.getPc_name() + "</td>";
			tmp += "<td class=\"CREATED_DATE\">" + item.getPc_created_date() + "</td>";
			tmp += "<td class=\"NOTES\">" + item.getPc_notes() + "</td>";
			tmp += "<td class=\"ED\">Sửa</td>";
			tmp += "<td class=\"ED\">Xóa</td>";
			tmp += "<td class=\"ID\">" + item.getPc_id() + "</td>";
			tmp += "</tr>";
		}
		tmp += "</table>";
		return tmp;
	}

}
