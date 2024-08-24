package jsoft.ads.article.category;

import java.util.*;
import jsoft.objects.*	;

public class CategoryLibrary {

	public static String viewCategories(ArrayList<CategoryObject> items) {
		String tmp = "<table cellspacing=0>";
		
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Tên thể loại</th>";
		tmp += "<th>Tên Chuyên mục</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Ngày sửa</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";
		
		int NO = 0;
		
		for(CategoryObject item : items) {
			NO++;
			
			tmp += (NO%2==0)? "<tr  class=\"even\">" : "<tr>";
			tmp += "<td class=\"NO\">"+NO+"</td>";
			tmp += "<td class=\"NAME\">"+item.getCategory_name()+"</td>";
			tmp += "<td class=\"SECTION_NAME\">"+item.getSection_name()+"</td>";
			tmp += "<td class=\"NOTES\">"+item.getCategory_notes()+"</td>";
			tmp += "<td class=\"CREATED_DATE\">"+item.getCategory_created_date()+"</td>";
			tmp += "<td class=\"LAST_MODIFIED\">"+item.getCategory_last_modified()+"</td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/category/ae?id="+item.getCategory_id()+"\">Sửa</a></td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/category/ae?id="+item.getCategory_id()+"\">Xóa</a></td>";
			tmp += "<td class=\"ID\">"+item.getCategory_id()+"</td>";
			tmp += "<tr>";
			
		}
		tmp += "</table>";
		return tmp;
	}

	public static String viewSectionOptions(ArrayList<SectionObject> items) {
		String tmp = "";
		
		for(SectionObject item:items) {
			tmp+= "<option value=\""+item.getSection_id()+"\">";
			tmp+= item.getSection_name();
			tmp+= "</option>";
		}
		
		return tmp;
	}

}
