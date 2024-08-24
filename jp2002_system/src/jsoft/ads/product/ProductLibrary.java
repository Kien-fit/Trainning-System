package jsoft.ads.product;

import java.util.*;

import jsoft.objects.*;

public class ProductLibrary {

	public static String viewProducts(ArrayList<ProductObject> items) {
		String tmp = "<table cellspacing=0>";

		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Hình ảnh</th>";
		tmp += "<th>Mã sản phẩm</th>";
		tmp += "<th>Tên sản phẩm</th>";
		tmp += "<th>Loại sản phẩm</th>";
		tmp += "<th>Hệ sản phẩm</th>";
		tmp += "<th>Nhóm sản phẩm</th>";	
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Lượt xem</th>";
		tmp += "<th>Giá</th>";
		tmp += "<th>Số lượng</th>";
		tmp += "<th>Kích thước</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		int NO = 0;
		for (ProductObject item : items) {
			NO++;

			tmp += (NO%2==0)?"<tr class=\"even\">":"<tr>";
			tmp += "<td class=\"NO\">" + NO + "</td>";
			tmp += "<td class=\"IMAGE\"><img src=\"" + item.getProduct_image() + "\" width=\"10vw\" height=\"10vw\" alt=\""+item.getProduct_name()+"\" /></td>";
			tmp += "<td class=\"CODE\">" + item.getProduct_code() + "</td>";
			tmp += "<td class=\"NAME\">" + item.getProduct_name() + "</td>";
			tmp += "<td class=\"PC_NAME\">" + item.getPc_name() + "</td>";
			tmp += "<td class=\"PG_NAME\">" + item.getPg_name() + "</td>";
			tmp += "<td class=\"PS_NAME\">" + item.getPs_name() + "</td>";
			tmp += "<td class=\"CREATED_DATE\">" + item.getProduct_created_date() + "</td>";
			tmp += "<td class=\"VISITED\">" + item.getProduct_visited() + "</td>";
			tmp += "<td class=\"PRICE\">" + item.getProduct_price() + "</td>";
			tmp += "<td class=\"TOTAL\">" + item.getProduct_total() + "</td>";
			tmp += "<td class=\"SIZE\">" + item.getProduct_size() + "</td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/product/ae?id="+item.getProduct_id()+"\">Sửa</a></td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/product/ae?id="+item.getProduct_id()+"\">Xóa</a></td>";
			tmp += "<td class=\"ID\">" + item.getProduct_id() + "</td>";
			tmp += "</tr>";
		}
		tmp += "</table>";
		return tmp;
	}

	public static String viewProductCategoryOptions(ArrayList<ProductCategoryObject> items) {
		String tmp = "";
		
		for(ProductCategoryObject item : items) {
			tmp +="<option value=\""+item.getPg_id()+"\">";
			tmp += item.getPg_name();
			tmp += "</option>";		
		}
		return tmp;
	}
}
