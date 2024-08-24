package jsoft.ads.product.pg;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ProductGroupModel {

	private ProductGroup pg;

	public ProductGroupModel(ConnectionPool cp) {
		this.pg = new ProductGroupImpl(cp, "ProductGroup");
	}

	protected void finalize() throws Throwable {
		this.pg = null;
		super.finalize();
	}

	public void  releaseConnection() {
		this.pg.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.pg.getCP();
	}
	
	// ------------------------------------------------
		public boolean addProductGroup(ProductGroupObject item) {
			return this.pg.addProductGroup(item);
		}

		public boolean editProductGroup(ProductGroupObject item) {
			return this.pg.editProductGroup(item);
		}

		public boolean delProductGroup(ProductGroupObject item) {
			return this.pg.delProductGroup(item);
		}

		// ------------------------------------------------
		public ProductGroupObject getProductGroupObject(int id) {
			ProductGroupObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.pg.getProductGroup(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new ProductGroupObject();
						item.setPg_id(rs.getInt("pg_id"));
						item.setPg_name(rs.getString("pg_name"));
						item.setPg_notes(rs.getString("pg_notes"));
						item.setPg_created_date(rs.getString("pg_created_date"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<ProductGroupObject> getProductGroupObjects(ProductGroupObject similar, short page, byte total) {

			ArrayList<ProductGroupObject> items = new ArrayList<ProductGroupObject>();

			ProductGroupObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.pg.getProductGroups(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new ProductGroupObject();
						item.setPg_id(rs.getInt("pg_id"));
						item.setPg_name(rs.getString("pg_name"));
						item.setPs_name(rs.getString("ps_name"));
						item.setPg_notes(rs.getString("pg_notes"));
						item.setPg_created_date(rs.getString("pg_created_date"));
//						pg_manager_id;
//						pg_notes;
//						pg_delete;
//						pg_deleted_date;
//						pg_deleted_author;
//						pg_modified_date;
//						pg_created_date;
//						pg_enable;//Hien thi hay khong
//						pg_name_en;//Ten Nhom san pham tieng Anh
//						pg_created_author_id;
//						pg_language;
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
		public ArrayList<ProductSystemObject> getProductSystemObjects(ProductSystemObject similar) {

			ArrayList<ProductSystemObject> items = new ArrayList<>();

			ProductSystemObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.pg.getProductSystems(similar);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new ProductSystemObject();
						item.setPs_id(rs.getInt("ps_id"));
						item.setPs_name(rs.getString("ps_name"));

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
