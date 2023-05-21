package jsoft.ads.ae;

import jsoft.*;
import jsoft.objects.*;
//import java.sql.*;
import java.util.*;

public class ArticleExtendsControl {

	private ArticleExtendsModel aem;

	public ArticleExtendsControl(ConnectionPool cp) {
		this.aem = new ArticleExtendsModel(cp);
	}

	protected void finalize() throws Throwable {
		this.aem = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.aem.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.aem.getCP();
	}

	// ------------------------------------------------
		public boolean addArticleExtends(ArticleExtendsObject item) {
			return this.aem.addArticleExtends(item);
		}

		public boolean editArticleExtends(ArticleExtendsObject item) {
			return this.aem.editArticleExtends(item);
		}

		public boolean delArticleExtends(ArticleExtendsObject item) {
			return this.aem.delArticleExtends(item);
		}

		// ------------------------------------------------
		public ArticleExtendsObject getArticleExtendsObject(int id) {
			return this.aem.getArticleExtendsObject(id);
		}

		public String viewArticleExtends(ArticleExtendsObject similar, short page, byte total) {

			ArrayList<ArticleExtendsObject> items = this.aem.getArticleExtendsObjects(similar, page, total);
			
			return ArticleExtendsLibrary.viewArticleExtends(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
