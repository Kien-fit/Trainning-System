package jsoft.ads.article;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ArticleModel {

	//
	private Article art;

	public ArticleModel(ConnectionPool cp) {
		this.art = new ArticleImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.art = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.art.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.art.getCP();
	}

	// ------------------------------------------------
	public boolean addArticle(ArticleObject item) {
		return this.art.addArticle(item);
	}

	public boolean editArticle(ArticleObject item) {
		return this.art.editArticle(item);
	}

	public boolean delArticle(ArticleObject item) {
		return this.art.delArticle(item);
	}

	// ------------------------------------------------
	public ArticleObject getArticleObject(int id) {
		ArticleObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.art.getArticle(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setSection_id(rs.getShort("section_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_image(rs.getString("article_image"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_url_link(rs.getString("article_url_link"));
					item.setArticle_tag(rs.getString("article_tag"));

				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<ArticleObject> getArticleObjects(ArticleObject similar, short page, byte total) {

		ArrayList<ArticleObject> items = new ArrayList<ArticleObject>();

		ArticleObject item = null;

		// Lấy dữ liệu
		int at = (page - 1) * total;
		ResultSet rs = this.art.getArticles(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setSection_id(rs.getShort("section_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_image(rs.getString("article_image"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_url_link(rs.getString("article_url_link"));
					item.setArticle_tag(rs.getString("article_tag"));
					
					item.setArticle_fee(rs.getInt("article_fee"));
					
					item.setSection_name(rs.getString("section_name"));
					item.setCategory_name(rs.getString("category_name"));

					items.add(item);
				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
