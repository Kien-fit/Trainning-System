package jsoft.ads.article.category;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import  java.util.*;

public class CategoryModel {
	
	private Category cat;
	
	public CategoryModel(ConnectionPool cp, String objectName) {
		this.cat = new CategoryImpl(cp, objectName);
	}
	
	protected void finalize() throws Throwable{
		this.cat=null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.cat.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.cat.getCP();
	}
	
	// ------------------------------------------------
		public boolean addCategory(CategoryObject item) {
			return this.cat.addCategory(item);
		}

		public boolean editCategory(CategoryObject item) {
			return this.cat.editCategory(item);
		}

		public boolean delCategory(CategoryObject item) {
			return this.cat.delCategory(item);
		}

		// ------------------------------------------------
		public CategoryObject getCategoryObject(short id) {
			CategoryObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.cat.getCategory(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new CategoryObject();
						item.setCategory_id(rs.getShort("category_id"));
						item.setSection_id(rs.getShort("section_id"));
						item.setCategory_name(rs.getString("category_name"));
						item.setCategory_notes(rs.getString("category_notes"));
						item.setCategory_created_date(rs.getString("category_created_date"));
//						item.setCategory_last_modified(rs.getString("category_last_modified"));
						item.setCategory_image(rs.getString("category_image"));

						item.setCategory_section_id(rs.getInt("category_section_id"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<CategoryObject> getCategoryObjects(CategoryObject similar, short page, byte total) {

			ArrayList<CategoryObject> items = new ArrayList<CategoryObject>();

			CategoryObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.cat.getCategories(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new CategoryObject();
						item.setCategory_id(rs.getShort("category_id"));
						item.setSection_name(rs.getString("section_name"));
						item.setCategory_name(rs.getString("category_name"));
						item.setCategory_notes(rs.getString("category_notes"));
						item.setCategory_created_date(rs.getString("category_created_date"));
//						item.setCategory_last_modified(rs.getString("category_last_modified"));
						item.setCategory_image(rs.getString("category_image"));

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
