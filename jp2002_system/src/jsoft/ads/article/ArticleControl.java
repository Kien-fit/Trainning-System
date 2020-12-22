package jsoft.ads.article;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class ArticleControl {

	//
	private ArticleModel am;

	public ArticleControl(ConnectionPool cp, String objectName) {
		this.am = new ArticleModel(cp, objectName);
	}

	protected void finalize() throws Throwable {
		this.am = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.am.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.am.getCP();
	}

	// ------------------------------------------------
	public boolean addArticle(ArticleObject item) {
		return this.am.addArticle(item);
	}

	public boolean editArticle(ArticleObject item) {
		return this.am.editArticle(item);
	}

	public boolean delArticle(ArticleObject item) {
		return this.am.delArticle(item);
	}

	// ------------------------------------------------
	public ArticleObject getArticleObject(int id) {
		return this.am.getArticleObject(id);
	}

	public String viewArticles(ArticleObject similar, short page, byte total) {

		ArrayList<ArticleObject> items = this.am.getArticleObjects(similar, page, total);
		return ArticleLibrary.viewArticles(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
