package jsoft.ads.ae;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ArticleExtendsControl {

	private ArticleExtendsModel ae;

	public ArticleExtendsControl(ConnectionPool cp, String objectname) {
		this.ae = new ArticleExtendsModel(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.ae = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.ae.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.ae.getCP();
	}

	// ------------------------------------------------
		public boolean addArticleExtends(ArticleExtendsObject item) {
			return this.ae.addArticleExtends(item);
		}

		public boolean editArticleExtends(ArticleExtendsObject item) {
			return this.ae.editArticleExtends(item);
		}

		public boolean delArticleExtends(ArticleExtendsObject item) {
			return this.ae.delArticleExtends(item);
		}

		// ------------------------------------------------
		public ArticleExtendsObject getArticleExtendsObject(int id) {
			return this.ae.getArticleExtendsObject(id);
		}

		public String viewArticleExtends(ArticleExtendsObject similar, short page, byte total) {

			ArrayList<ArticleExtendsObject> items = this.ae.getArticleExtendsObjects(similar, page, total);
			
			return ArticleExtendsLibrary.viewArticleExtends(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
