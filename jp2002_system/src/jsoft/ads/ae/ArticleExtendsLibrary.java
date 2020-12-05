package jsoft.ads.ae;

import java.util.*;

import jsoft.objects.*;

public class ArticleExtendsLibrary {

	public static String viewArticleExtends(ArrayList<ArticleExtendsObject> items) {
		String tmp = "<table cellspacing=0>";

		//Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
		tmp += "<th></th>";
//		tmp += "<th></th>";
//		tmp += "<th></th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		//Dòng nội dung
		int NO = 0;
		for (ArticleExtendsObject item : items) {
			NO++;
			tmp += "<tr>";
			tmp += "<td>"+NO+"</td>";
			tmp += "<td>"+item.getAe_text200_1()+"</td>";
			tmp += "<td>"+item.getAe_byte_1()+"</td>";
			tmp += "<td>"+item.getAe_short_1()+"</td>";
			tmp += "<td>"+item.getAe_int_1()+"</td>";
			tmp += "<td>"+item.getAe_text_1()+"</td>";
			tmp += "<td>"+item.getAe_longtext()+"</td>";
			tmp += "<td>Sửa</td>";
			tmp += "<td>Xóa</td>";
			tmp += "<td>"+item.getAe_id()+"</td>";
			tmp += "</tr>";
		}
		
		tmp += "</table>";

		return tmp;
	}
}
