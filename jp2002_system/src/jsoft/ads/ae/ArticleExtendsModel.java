package jsoft.ads.ae;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ArticleExtendsModel {

	private ArticleExtends ae;

	public ArticleExtendsModel(ConnectionPool cp, String objectname) {
		this.ae = new ArticleExtendsImpl(cp, objectname);
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
			ArticleExtendsObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.ae.getArticleExtends(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new ArticleExtendsObject();
						item.setAe_id(rs.getInt("ae_id"));
						item.setAe_text200_1(rs.getString("ae_text200_1"));
						item.setAe_text200_2(rs.getString("ae_text200_2"));
						item.setAe_text200_3(rs.getString("ae_text200_3"));
						item.setAe_text200_4(rs.getString("ae_text200_4"));
						item.setAe_text200_5(rs.getString("ae_text200_5"));
						item.setAe_byte_1(rs.getByte("ae_byte_1"));
						item.setAe_byte_2(rs.getByte("ae_byte_2"));
						item.setAe_byte_3(rs.getByte("ae_byte_3"));
						item.setAe_byte_4(rs.getByte("ae_byte_4"));
						item.setAe_byte_5(rs.getByte("ae_byte_5"));
						item.setAe_short_1(rs.getShort("ae_short_1"));
						item.setAe_short_2(rs.getShort("ae_short_1"));
						item.setAe_int_1(rs.getInt("ae_int_1"));
						item.setAe_int_2(rs.getInt("ae_int_1"));
						item.setAe_text_1(rs.getString("ae_text_1"));
						item.setAe_text_2(rs.getString("ae_text_2"));
						item.setAe_longtext(rs.getString("ae_longtext"));
						item.setAe_article_id(rs.getInt("ae_article_id"));

					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<ArticleExtendsObject> getArticleExtendsObjects(ArticleExtendsObject similar, short page, byte total) {

			ArrayList<ArticleExtendsObject> items = new ArrayList<ArticleExtendsObject>();

			ArticleExtendsObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.ae.getArticleExtends(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new ArticleExtendsObject();
						item.setAe_id(rs.getInt("ae_id"));
						item.setAe_text200_1(rs.getString("ae_text200_1"));
						item.setAe_text200_2(rs.getString("ae_text200_2"));
						item.setAe_text200_3(rs.getString("ae_text200_3"));
						item.setAe_text200_4(rs.getString("ae_text200_4"));
						item.setAe_text200_5(rs.getString("ae_text200_5"));
						item.setAe_byte_1(rs.getByte("ae_byte_1"));
						item.setAe_byte_2(rs.getByte("ae_byte_2"));
						item.setAe_byte_3(rs.getByte("ae_byte_3"));
						item.setAe_byte_4(rs.getByte("ae_byte_4"));
						item.setAe_byte_5(rs.getByte("ae_byte_5"));
						item.setAe_short_1(rs.getShort("ae_short_1"));
						item.setAe_short_2(rs.getShort("ae_short_1"));
						item.setAe_int_1(rs.getInt("ae_int_1"));
						item.setAe_int_2(rs.getInt("ae_int_1"));
						item.setAe_text_1(rs.getString("ae_text_1"));
						item.setAe_text_2(rs.getString("ae_text_2"));
						item.setAe_longtext(rs.getString("ae_longtext"));
						item.setAe_article_id(rs.getInt("ae_article_id"));
						
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
