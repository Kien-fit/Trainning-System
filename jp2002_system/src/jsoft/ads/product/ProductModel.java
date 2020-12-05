package jsoft.ads.product;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ProductModel {

	private Product sp;

	public ProductModel(ConnectionPool cp) {
		this.sp = new ProductImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.sp = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.sp.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.sp.getCP();
	}
	

	// **************************************************
	public boolean addProduct(ProductObject item) {
		return this.sp.addProduct(item);
	}

	public boolean editProduct(ProductObject item) {
		return this.sp.editProduct(item);
	}

	public boolean delProduct(ProductObject item) {
		return this.sp.delProduct(item);
	}

	// **************************************************
	public ProductObject getProductObject(short id) {
		ProductObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.sp.getProduct(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getShort("product_id"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_image(rs.getString("product_image"));
					item.setProduct_price(rs.getInt("product_price"));

				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList<ProductObject> getProductObjects(ProductObject similar, short page, byte total) {

		ArrayList<ProductObject> items = new ArrayList<>();

		ProductObject item = null;

		// Lấy dữ liệu
		int at = (page - 1) * total;
		ResultSet rs = this.sp.getProducts(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getInt("product_id"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_image(rs.getString("product_image"));
					item.setProduct_price(rs.getInt("product_price"));
//					item.setProduct_discount_price(rs.getInt("product_discount_price"));
//					item.setProduct_enable(rs.getBoolean("product_enable"));
//					item.setProduct_delete(rs.getBoolean("product_delete"));
					item.setProduct_visited(rs.getShort("product_visited"));
					item.setProduct_total(rs.getShort("product_total"));
//					item.setProduct_manager_id(rs.getShort("product_manager_id"));
//					item.setProduct_intro(rs.getString("product_intro"));
					item.setProduct_notes(rs.getString("product_notes"));
					item.setProduct_code(rs.getString("product_code"));
					item.setProduct_created_date(rs.getString("product_created_date"));
//					item.setProduct_modified_date(rs.getString("product_modified_date"));
//					item.setProduct_pc_id(rs.getShort("product_pc_id"));
//					item.setProduct_pg_id(rs.getShort("product__pg_id"));
//					item.setProduct_ps_id(rs.getShort("product_ps_id"));
//					item.setProduct_is_detail(rs.getBoolean("product_is_detail"));
//					item.setProduct_deleted_date(rs.getString("product_deleted_date"));
//					item.setProduct_deleted_author(rs.getString("product_deleted_author"));
					item.setProduct_promotion_price(rs.getInt("product_promotion_price"));
					item.setProduct_sold(rs.getShort("product_sold"));
					item.setProduct_best_seller(rs.getBoolean("product_best_seller"));
					item.setProduct_promotion(rs.getBoolean("product_promotion"));
					item.setProduct_price_calc_description(rs.getByte("product_price_calc_description"));
					item.setProduct_size(rs.getString("product_size"));
					item.setProduct_name_en(rs.getString("product_name_en"));
//					item.setProduct_customer_id(rs.getInt("product_customer_id"));
					item.setProduct_perspective_id(rs.getBoolean("product_perspective_id"));
					
					item.setPc_name(rs.getString("pc_name"));
					item.setPg_name(rs.getString("pg_name"));
					item.setPs_name(rs.getString("ps_name"));
					
					// Thêm đối tượng vào danh sách
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

		// Tạo đối tượng thực thii chức năng mới Model
		ProductModel um = new ProductModel(cp);

		ArrayList<ProductObject> Products = um.getProductObjects(null, (short) 1, (byte) 10);

		for (ProductObject Product : Products) {
			System.out.print("ID: " + Product.getProduct_id());
			System.out.print("\tNAME: " + Product.getProduct_name());
			System.out.print("\tPC_NAME: " + Product.getPc_name());
			System.out.print("\tPG_NAME: " + Product.getPg_name());
			System.out.print("\tPS_NAME: " + Product.getPs_name());
			System.out.println();
		}

	}

}
