package jsoft.ads.article;

import jsoft.objects.*;
import java.sql.*;

import jsoft.ads.article.category.*;

public interface Article extends Category {
	//Cac chuc nang cap nhat
	public boolean addArticle(ArticleObject item);
	public boolean editArticle(ArticleObject item);
	public boolean delArticle(ArticleObject item);
	
	//Cac chuc nang lay du lieu
	public ResultSet getArticle(int id);
	public ResultSet getArticles(ArticleObject similar, int at, byte total);	

	public ResultSet getCategories(CategoryObject similar);	
	
}
