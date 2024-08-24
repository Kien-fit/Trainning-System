package jsoft.ads.product.pc;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.product.pg.*;


public class ProductCategoryImpl extends ProductGroupImpl implements ProductCategory {
	
	public ProductCategoryImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addProductCategory(ProductCategoryObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblpc (";
		sql += "pc_name, ";
		sql += "pc_pg_id, ";
		sql += "pc_ps_id, ";
		sql += "pc_manager_id, ";
		sql += "pc_notes, ";
//		sql += "pc_delete, ";
		sql += "pc_deleted_date, ";
		sql += "pc_deleted_author, ";
		sql += "pc_modified_date, ";
		sql += "pc_created_date, ";
		sql += "pc_image, ";
//		sql += "pc_enable, ";
		sql += "pc_name_en, ";
		sql += "pc_created_author_id, ";
		sql += "pc_language ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,0,?,?,?,?,?,1,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPc_name());
			pre.setInt(2, item.getPc_pg_id());
			pre.setShort(3, item.getPc_ps_id());
			pre.setInt(4, item.getPc_manager_id());
			pre.setString(5, item.getPc_notes());

			pre.setString(6, item.getPc_deleted_date());
			pre.setString(7, item.getPc_deleted_author());
			pre.setString(8, item.getPc_modified_date());
			pre.setString(9, item.getPc_created_date());
			pre.setString(10, item.getPc_image());

			pre.setString(11, item.getPc_name_en());
			pre.setInt(12, item.getPc_created_author_id());
			pre.setByte(13, item.getPc_language());
			
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
	public boolean editProductCategory(ProductCategoryObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblpc SET ";
		sql += "pc_name=?, ";
		sql += "pc_pg_id=?, ";
		sql += "pc_ps_id=?, ";
		sql += "pc_manager_id=?, ";
		sql += "pc_notes=?, ";

		sql += "pc_modified_date=?, ";

		sql += "pc_image=?, ";
		sql += "pc_enable=?, ";
		sql += "pc_name_en=?, ";

		sql += "pc_language=? ";
		
		sql += "WHERE pc_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPc_name());
			pre.setInt(2, item.getPc_pg_id());
			pre.setShort(3, item.getPc_ps_id());
			pre.setInt(4, item.getPc_manager_id());
			pre.setString(5, item.getPc_notes());

			pre.setString(6, item.getPc_modified_date());

			pre.setString(7, item.getPc_image());
			pre.setBoolean(8, item.isPc_enable());
			pre.setString(9, item.getPc_name_en());

			pre.setByte(10, item.getPc_language());

			pre.setInt(11, item.getPc_id());
			
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
	public boolean delProductCategory(ProductCategoryObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "UPDATE tblpc SET ";
		sql += "pc_delete=1, ";
		sql += "pc_deleted_date=?, ";
		sql += "pc_deleted_author=? ";	
		sql += "WHERE pc_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getPc_deleted_date());
			pre.setString(2, item.getPc_deleted_author());
			pre.setInt(3, item.getPc_id());
			
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
	
	private boolean isEmpty(ProductCategoryObject item) {
		boolean flag = true;
		
		String sql = "SELECT product_id FROM tblproduct ";
		sql += "WHERE (product_pc_id="+item.getPc_id()+") AND (product_enable=1) AND (product_delete=0)";
		
		ResultSet rs = this.gets(sql);
		if(rs!=null) {
			try {
				if(rs.next()) {
					flag = false;
				}
				
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}


	@Override
	public ResultSet getProductCategory(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblpc ";
		sql += "LEFT JOIN tblpg ON pc_pg_id=pg_id ";
		sql += "LEFT JOIN tblps ON pg_ps_id=ps_id ";
		sql += "WHERE (pc_id=?) AND (pc_enable=1) AND (pc_delete=0)";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getProductCategories(ProductCategoryObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblpc ";
		sql += "LEFT JOIN tblpg ON pc_pg_id=pg_id ";
		sql += "LEFT JOIN tblps ON pg_ps_id=ps_id ";
		sql += "WHERE (pc_delete=0) ";
//		sql += "AND (pc_enable=1) ";
		sql += "ORDER BY pc_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	@Override
	public ResultSet getProductGroups(ProductGroupObject similar) {
		String sql = "SELECT pg_id, pg_name FROM tblpg ";
		sql += "WHERE (pg_delete=0) ";
//		sql += "AND (pg_enable=1) ";
		sql += "ORDER BY pg_name ASC ";
		return this.gets(sql);
	}

	public static void main(String[] args) {
		// Tạo đối tượng quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng vào CSDL mức giao tiếp (interface)
		ProductCategory pc = new ProductCategoryImpl(cp, "ProductCategory");

		// Lấy tập kết quả
		ResultSet rs = pc.getProductCategories(null, 0, (byte) 10);
		
		//Trả lại kết nối
		pc.releaseConnection();

		// Duyệt và hiển thị kết quả
		String row;
		if (rs != null) {
			try {
				while(rs.next()) {
					row = "ID: " + rs.getInt("pc_id");
					row += "\t\tNAME: " + rs.getString("pc_name");
					
					System.out.println(row);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
