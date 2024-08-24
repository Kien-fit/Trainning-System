package jsoft.ads.product.pc;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ProductCategoryModel {

	private ProductCategory pc;

	public ProductCategoryModel(ConnectionPool cp) {
		this.pc = new ProductCategoryImpl(cp, "ProductCategory");
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
					item.setPc_pg_id(rs.getShort("pc_pg_id"));
					item.setPc_name(rs.getString("pc_name"));
					item.setPc_notes(rs.getString("pc_notes"));
					item.setPc_created_date(rs.getString("pc_created_date"));
					item.setPc_image(rs.getString("pc_image"));
					item.setPc_name_en(rs.getString("pc_name_en"));
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
		ResultSet rs = this.pc.getProductCategories(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ProductCategoryObject();
					item.setPc_id(rs.getShort("pc_id"));
					item.setPs_name(rs.getString("ps_name"));
					item.setPg_name(rs.getString("pg_name"));
					item.setPc_name(rs.getString("pc_name"));
					item.setPc_name_en(rs.getString("pc_name_en"));//Ten The loai san pham tieng Anh
					item.setPc_manager_id(rs.getInt("pc_manager_id"));
					item.setPc_notes(rs.getString("pc_notes"));
					item.setPc_created_date(rs.getString("pc_created_date"));
					item.setPc_image(rs.getString("pc_image"));//Anh minh hoa cho the loai
						
//						pc_delete
//						pc_deleted_date;
//						pc_deleted_author;
//						pc_modified_date;
//						pc_enable //Hien thi hay khong
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
	
	public ArrayList<ProductGroupObject> getProductGroupObjects(ProductGroupObject similar) {

		ArrayList<ProductGroupObject> items = new ArrayList<>();

		ProductGroupObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.pc.getProductGroups(similar);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ProductGroupObject();
					item.setPg_id(rs.getInt("pg_id"));
					item.setPg_name(rs.getString("pg_name"));
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
		// Tạo bộ quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng mới Model
		ProductCategoryModel pcm = new ProductCategoryModel(cp);

		//lay danh sach
		ArrayList<ProductCategoryObject> pcs = pcm.getProductCategoryObjects(null, (short) 1, (byte) 10);

		//Tra ket noi
		pcm.releaseConnection();
		
		//toString
		for (ProductCategoryObject pc : pcs) {
			System.out.print("ID: " + pc.getPc_id());
			System.out.print("\tNAME: " + pc.getPc_name());
		}
	}
}
