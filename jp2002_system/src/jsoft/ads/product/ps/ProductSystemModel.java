package jsoft.ads.product.ps;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ProductSystemModel {

	private ProductSystem ps;

	public ProductSystemModel(ConnectionPool cp, String objectname) {
		this.ps = new ProductSystemImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.ps = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.ps.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.ps.getCP();
	}
	
	// ------------------------------------------------
		public boolean addProductSystem(ProductSystemObject item) {
			return this.ps.addProductSystem(item);
		}

		public boolean editProductSystem(ProductSystemObject item) {
			return this.ps.editProductSystem(item);
		}

		public boolean delProductSystem(ProductSystemObject item) {
			return this.ps.delProductSystem(item);
		}

		// ------------------------------------------------
		public ProductSystemObject getPsObject(int id) {
			ProductSystemObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.ps.getProductSystem(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new ProductSystemObject();
						item.setPs_id(rs.getShort("ps_id"));
						item.setPs_name(rs.getString("ps_name"));
						item.setPs_notes(rs.getString("ps_notes"));
						item.setPs_created_date(rs.getString("ps_created_date"));
						item.setPs_modified_date(rs.getString("ps_modified_date"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<ProductSystemObject> getProductSystemObjects(ProductSystemObject similar, short page, byte total) {

			ArrayList<ProductSystemObject> items = new ArrayList<ProductSystemObject>();

			ProductSystemObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.ps.getProductSystems(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new ProductSystemObject();
						item.setPs_id(rs.getShort("ps_id"));
						item.setPs_name(rs.getString("ps_name"));
						item.setPs_manager_id(rs.getInt("ps_manager_id"));
						item.setPs_notes(rs.getString("ps_notes"));
						item.setPs_modified_date(rs.getString("ps_modified_date"));
						item.setPs_created_date(rs.getString("ps_created_date"));
						item.setPs_table(rs.getString("ps_table"));
						item.setPs_name_en(rs.getString("ps_name_en"));
						item.setPs_created_author_id(rs.getInt("ps_created_author_id"));
						item.setPs_language(rs.getByte("ps_language"));
						
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
