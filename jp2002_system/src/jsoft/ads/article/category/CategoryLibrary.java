package jsoft.ads.article.category;

import java.util.*;

import jsoft.objects.*	;

public class CategoryLibrary {

	public static String viewCategories(ArrayList<CategoryObject> items) {
		String tmp = "<table cellspacing=0>";
		
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Tên thể loại</th>";
		tmp += "<th>Tên Chuyên mục</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";
		
		int NO = 0;
		
		for(CategoryObject item : items) {
			NO++;
			
			tmp += (NO%2==0)? "<tr  class=\"even\">" : "<tr>";
			tmp += "<td class=\"NO\">"+NO+"</td>";
			tmp += "<td class=\"CREATED_DATE\">"+item.getCategory_created_date()+"</td>";
			tmp += "<td class=\"SECTION_ID\">"+item.getSection_name()+"</td>";
			tmp += "<td class=\"NAME\">"+item.getCategory_name()+"</td>";
			tmp += "<td class=\"NOTES\">"+item.getCategory_notes()+"</td>";
//			tmp += "<td>"++"</td>";
			tmp += "<td class=\"ED\">Sửa</td>";
			tmp += "<td class=\"ED\">Xóa</td>";
			tmp += "<td class=\"ID\">"+item.getCategory_id()+"</td>";
			tmp += "<tr>";
			
		}
		tmp += "</table>";
		return tmp;
	}
}
