package jsoft.ads.article;

import java.util.*;

import jsoft.objects.*;

public class ArticleLibrary {

	public static String viewArticles(ArrayList<ArticleObject> items) {
		String tmp = "<table cellspacing=0>";

		//Dòng tiêu đề
		tmp += "<tr>";
		tmp += "<th>STT</th>";
		tmp += "<th>Ảnh</th>";
		tmp += "<th>Ngày tạo</th>";
		tmp += "<th>Tiêu đề</th>";
		tmp += "<th>Tên thể loại</th>";
		tmp += "<th>Tên chuyên  mục</th>";
		tmp += "<th>Tác giả</th>";
		tmp += "<th>Lượt xem</th>";
		tmp += "<th colspan=2>Thực hiện</th>";
		tmp += "<th>ID</th>";
		tmp += "</tr>";

		//Dòng nội dung
		int NO = 0;
		for (ArticleObject item : items) {
			NO++;
			tmp += (NO%2==0)?"<tr class=\"even\">":"<tr>";
			tmp += "<td class=\"NO\">"+NO+"</td>";
			tmp += "<td class=\"IMAGE\"><img src=\"" + item.getArticle_image() + "\" class=\"d-block w-100\" alt=\""+item.getArticle_title()+"\"></td>";
			tmp += "<td class=\"CREATED_DATE\">"+item.getArticle_created_date()+"</td>";
			tmp += "<td class=\"TITLE\">"+item.getArticle_title()+"</td>";
			tmp += "<td class=\"CATEGORY_NAME\">"+item.getCategory_name()+"</td>";
			tmp += "<td class=\"SECTION_NAME\">"+item.getSection_name()+"</td>";
			tmp += "<td class=\"AUTHOR\">"+item.getArticle_author_name()+"</td>";
			tmp += "<td class=\"VISITED\">"+item.getArticle_visited()+"</td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/article/ae?id="+item.getArticle_id()+"\">Sửa</a></td>";
			tmp += "<td class=\"ED\"><a href=\"/adv/article/ae?id="+item.getArticle_id()+"\">Xóa</a></td>";
			tmp += "<td class=\"ID\">"+item.getArticle_id()+"</td>";
			tmp += "</tr>";
		}
		
		tmp += "</table>";

		return tmp;
	}

	public static String viewCategoryOptions(ArrayList<CategoryObject> items) {
		String tmp = "";
		
		for(CategoryObject item:items) {
			tmp+= "<option value=\""+item.getCategory_id()+"\">";
			tmp+= item.getCategory_name();
			tmp+= "</option>";
		}
		
		return tmp;
	}
}
