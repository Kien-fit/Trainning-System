package jsoft.ads.article.section;

import java.util.*;

import jsoft.objects.*;

public class SectionLibrary {
	
	public static String viewSections(ArrayList<SectionObject> items) {
		String tmp = "<table cellspacing=0>";
		
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Tên chuyên mục</th>";
		tmp += "<th>Ghi chú</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Ngày cập nhật</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>Id</th>";
		tmp += "</tr>";
		
		int NO = 0;
		
		for(SectionObject item : items) {
			NO++;
			
			tmp += (NO%2==0)?"<tr class=\"even\">":"<tr>";
			tmp += "<td class=\"NO\">"+NO+"</td>";
			tmp += "<td class=\"NAME\">"+item.getSection_name()+"</td>";
			tmp += "<td class=\"NOTES\">"+item.getSection_notes()+"</td>";
			tmp += "<td class=\"CREATED_DATE\">"+item.getSection_created_date()+"</td>";
			tmp += "<td class=\"LAST_MODIFIED\">"+item.getSection_last_modified()+"</td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/section/ae?id="+item.getSection_id()+"\">Sửa</a></td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/section/del?id="+item.getSection_id()+"\">Xóa</a></td>";
			tmp += "<td class=\"ID\">"+item.getSection_id()+"</td>";
			tmp += "</tr>";		
		}
		tmp += "</table>";		
		
		return tmp;
	}
	
	public static String viewUserOptions(ArrayList<UserObject> users) {
		String tmp = "";
		
		for(UserObject user:users) {
			tmp+= "<option value=\""+user.getUser_id()+"\">";
			tmp+= user.getUser_name() +" ("+user.getUser_fullname()+")";
			tmp+= "</option>";
		}
		
		return tmp;
	}

}
