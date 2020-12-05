package jsoft.ads.article.section;

import java.util.*;

import jsoft.objects.*;

public class SectionLibrary {
	
	public static String viewSections(ArrayList<SectionObject> items) {
		String tmp = "<table cellspacing=0>";
		
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Tên chuyên mục</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>Id</th>";
		tmp += "</tr>";
		
		int NO = 0;
		
		for(SectionObject item : items) {
			NO++;
			
			tmp += (NO%2==0)?"<tr class=\"even\">":"<tr>";
			tmp += "<td class=\"NO\">"+NO+"</td>";
			tmp += "<td class=\"CREATED_DATE\">"+item.getSection_created_date()+"</td>";
			tmp += "<td class=\"NAME\">"+item.getSection_name()+"</td>";
			tmp += "<td class=\"NOTES\">"+item.getSection_notes()+"</td>";
			tmp += "<td class=\"ED\">Sửa</td>";
			tmp += "<td class=\"ED\">Xóa</td>";
			tmp += "<td class=\"ID\">"+item.getSection_id()+"</td>";
			tmp += "";
			tmp += "</tr>";
			
		}
		tmp += "</table>";
		
		
		return tmp;
	}

}
