package jsoft.ads.product.pc;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ProductCategoryModel {

	private ProductCategory pc;

	public ProductCategoryModel(ConnectionPool cp, String objectname) {
		this.pc = new ProductCategoryImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.pc = null;
		super.finalize();
	}
	
	public void  releaseConnection() {
		this.pc.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.pc.getCP();
	}
	
	// ------------------------------------------------
		public boolean addProductCategory(ProductCategoryObject item) {
			return this.pc.addProductCategory(item);
		}

		public boolean editProductCategory(ProductCategoryObject item) {
			return this.pc.editProductCategory(item);
		}

		public boolean delProductCategory(ProductCategoryObject item) {
			return this.pc.delProductCategory(item);
		}

		// ------------------------------------------------
		public ProductCategoryObject getProductCategoryObject(int id) {
			ProductCategoryObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.pc.getProductCategory(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new ProductCategoryObject();
						item.setPc_id(rs.getShort("pc_id"));
						item.setPc_name(rs.getString("pc_name"));
						item.setPc_notes(rs.getString("pc_notes"));
						item.setPc_created_date(rs.getString("pc_created_date"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<ProductCategoryObject> getProductCategoryObjects(ProductCategoryObject similar, short page, byte total) {

			ArrayList<ProductCategoryObject> items = new ArrayList<ProductCategoryObject>();

			ProductCategoryObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.pc.getProductCategorys(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new ProductCategoryObject();
						item.setPc_id(rs.getShort("pc_id"));
						item.setPs_name(rs.getString("ps_name"));
						item.setPg_name(rs.getString("pg_name"));
						item.setPc_name(rs.getString("pc_name"));
						item.setPc_manager_id(rs.getInt("pc_manager_id"));
						item.setPc_notes(rs.getString("pc_notes"));
						item.setPc_created_date(rs.getString("pc_created_date"));
						item.setPc_image(rs.getString("pc_image"));
//						pc_pg_id
//						pc_ps_id
//						pc_delete
//						pc_deleted_date;
//						pc_deleted_author;
//						pc_modified_date;
//						
//						pc_image //Anh minh hoa cho the loai
//						pc_enable //Hien thi hay khong
//						pc_name_en //Ten The loai san pham tieng Anh
//						pc_created_author_id
//						pc_language
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
