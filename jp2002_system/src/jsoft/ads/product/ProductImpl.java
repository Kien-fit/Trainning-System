package jsoft.ads.product;

import java.sql.*;

import jsoft.*;
import jsoft.objects.*;
import jsoft.ads.product.pc.*;

public class ProductImpl extends ProductCategoryImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		// TODO Auto-generated constructor stub
		super(cp, "Product");
	}

	@Override
	public boolean addProduct(ProductObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblproduct (";
		sql += "product_name, ";
		sql += "product_image, ";
		sql += "product_price, ";
		sql += "product_discount_price, ";
		sql += "product_enable, ";
		sql += "product_delete, ";
		sql += "product_visited, ";
		sql += "product_total, ";
		sql += "product_manager_id, ";
		sql += "product_intro, ";
		sql += "product_notes, ";
		sql += "product_code, ";
		sql += "product_created_date, ";
		sql += "product_modified_date, ";
		sql += "product_pc_id, ";
		sql += "product_pg_id, ";
		sql += "product_ps_id, ";
		sql += "product_is_detail, ";
		sql += "product_deleted_date, ";
		sql += "product_deleted_author, ";
		sql += "product_promotion_price, ";
		sql += "product_sold, ";
		sql += "product_best_seller, ";
		sql += "product_promotion, ";
		sql += "product_price_calc_description, ";
		sql += "product_size, ";
		sql += "product_name_en, ";
		sql += "product_customer_id, ";
		sql += "product_perspective_id, ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getProduct_name());
			pre.setString(2, item.getProduct_image());
			pre.setInt(3, item.getProduct_price());
			pre.setInt(4, item.getProduct_discount_price());
			pre.setBoolean(5, item.isProduct_enable());
			pre.setBoolean(6, item.isProduct_delete());
			pre.setShort(7, item.getProduct_visited());
			pre.setShort(8, item.getProduct_total());
			pre.setInt(9, item.getProduct_manager_id());
			pre.setString(10, item.getProduct_intro());
			pre.setString(11, item.getProduct_notes());
			pre.setString(12, item.getProduct_code());
			pre.setString(13, item.getProduct_created_date());
			pre.setString(14, item.getProduct_modified_date());
			pre.setShort(15, item.getProduct_pc_id());
			pre.setShort(16, item.getProduct_pg_id());
			pre.setShort(17, item.getProduct_ps_id());
			pre.setBoolean(18, item.isProduct_is_detail());
			pre.setString(19, item.getProduct_deleted_date());
			pre.setString(20, item.getProduct_deleted_author());
			pre.setInt(21, item.getProduct_promotion_price());
			pre.setShort(22, item.getProduct_sold());
			pre.setBoolean(23, item.isProduct_best_seller());
			pre.setBoolean(24, item.isProduct_promotion());
			pre.setByte(25, item.getProduct_price_calc_description());
			pre.setString(26, item.getProduct_size());
			pre.setString(27, item.getProduct_name_en());
			pre.setInt(28, item.getProduct_customer_id());
			pre.setBoolean(29, item.isProduct_perspective_id());

			return this.add(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean editProduct(ProductObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblproduct SET ";
		sql += "product_name=?, ";
		sql += "product_image=?, ";
		sql += "product_price=?, ";
		sql += "product_discount_price=?, ";
		sql += "product_enable=?, ";
		sql += "product_delete=?, ";
		sql += "product_visited=?, ";
		sql += "product_total=?, ";
		sql += "product_manager_id=?, ";
		sql += "product_intro=?, ";
		sql += "product_notes=?, ";
		sql += "product_code=?, ";
//		sql += "product_created_date=?, ";
		sql += "product_modified_date=?, ";
		sql += "product_pc_id=?, ";
		sql += "product_pg_id=?, ";
		sql += "product_ps_id=?, ";
		sql += "product_is_detail=?, ";
		sql += "product_deleted_date=?, ";
		sql += "product_deleted_author=?, ";
		sql += "product_promotion_price=?, ";
		sql += "product_sold=?, ";
		sql += "product_best_seller=?, ";
		sql += "product_promotion=?, ";
		sql += "product_price_calc_description=?, ";
		sql += "product_size=?, ";
		sql += "product_name_en=?, ";
		sql += "product_customer_id=?, ";
		sql += "product_perspective_id=?, ";
		sql += ") ";
		sql += "WHERE product_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getProduct_name());
			pre.setString(2, item.getProduct_image());
			pre.setInt(3, item.getProduct_price());
			pre.setInt(4, item.getProduct_discount_price());
			pre.setBoolean(5, item.isProduct_enable());
			pre.setBoolean(6, item.isProduct_delete());
			pre.setShort(7, item.getProduct_visited());
			pre.setShort(8, item.getProduct_total());
			pre.setInt(9, item.getProduct_manager_id());
			pre.setString(10, item.getProduct_intro());
			pre.setString(11, item.getProduct_notes());
			pre.setString(12, item.getProduct_code());
//			pre.setString(13, item.getProduct_created_date());
			pre.setString(13, item.getProduct_modified_date());
			pre.setShort(14, item.getProduct_pc_id());
			pre.setShort(15, item.getProduct_pg_id());
			pre.setShort(16, item.getProduct_ps_id());
			pre.setBoolean(17, item.isProduct_is_detail());
			pre.setString(18, item.getProduct_deleted_date());
			pre.setString(19, item.getProduct_deleted_author());
			pre.setInt(20, item.getProduct_promotion_price());
			pre.setShort(21, item.getProduct_sold());
			pre.setBoolean(22, item.isProduct_best_seller());
			pre.setBoolean(23, item.isProduct_promotion());
			pre.setByte(24, item.getProduct_price_calc_description());
			pre.setString(25, item.getProduct_size());
			pre.setString(26, item.getProduct_name_en());
			pre.setInt(27, item.getProduct_customer_id());
			pre.setBoolean(28, item.isProduct_perspective_id());

			pre.setInt(29, item.getProduct_id());

			return this.edit(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean delProduct(ProductObject item) {
		// TODO Auto-generated method stub
		
		if(!this.isEmpty(item)) {
			return false;
		}

		String sql = "DELETE FROM tblproduct WHERE product_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setInt(1, item.getProduct_id());

			return this.del(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return false;
	}

	public boolean isEmpty(ProductObject item) {
		boolean flag = true;

		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id = " + item.getProduct_id() + ") ";
		ResultSet rs = this.gets(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public ResultSet getProduct(short id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblproduct ";
		sql += "LEFT JOIN tblpc ON product_pc_id=pc_id ";
		sql += "LEFT JOIN tblpg ON pc_pg_id=pg_id ";
		sql += "LEFT JOIN tblps ON pg_ps_id=ps_id ";
		sql += "";
		sql += "WHERE product_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getProducts(ProductObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblproduct ";
		sql += "LEFT JOIN tblpc ON product_pc_id=pc_id ";
		sql += "LEFT JOIN tblpg ON pc_pg_id=pg_id ";
		sql += "LEFT JOIN tblps ON pg_ps_id=ps_id ";
		sql += "";
		sql += "ORDER BY product_id DESC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);

	}
	
	public static void main(String[] args) {
		// Tạo đói tượng kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng vào CSDL mức Giao tiếp (interface)
		Product art = new ProductImpl(cp);

		// Lấy tập kết quả
		ResultSet rs = art.getProducts(null, 0, (byte) 10);
		
		//Trả lại kết nối
		art.releaseConnection();

		// Duyệt và hiển thị kết quả
		String row;
		if (rs != null) {
			try {
				while (rs.next()) {
					row = "ID: " + rs.getInt("product_id");
					row += "\t\tPC: " + rs.getString("pc_name");
					row += "\t\tPG: " + rs.getString("pg_name");
					row += "\t\tPS: " + rs.getString("ps_name");

					System.out.println(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
