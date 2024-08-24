package jsoft.ads.product.pg;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.product.ps.*;


public class ProductGroupImpl extends ProductSystemImpl implements ProductGroup {
	
	public ProductGroupImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addProductGroup(ProductGroupObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblpg (";
		sql += "pg_name, ";
		sql += "pg_ps_id, ";
		sql += "pg_manager_id, ";
		sql += "pg_notes, ";
		sql += "pg_delete, ";
		sql += "pg_deleted_date, ";
		sql += "pg_deleted_author, ";
		sql += "pg_modified_date, ";
		sql += "pg_created_date, ";
		sql += "pg_enable, ";
		sql += "pg_name_en, ";
		sql += "pg_created_author_id, ";
		sql += "pg_language ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,0,?,?,?,?,1,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPg_name());
			pre.setInt(2, item.getPg_ps_id());
			pre.setInt(3, item.getPg_manager_id());
			pre.setString(4, item.getPg_notes());

			pre.setString(5, item.getPg_deleted_date());
			pre.setString(6, item.getPg_deleted_author());
			pre.setString(7, item.getPg_modified_date());
			pre.setString(8, item.getPg_created_date());
			
			pre.setString(9, item.getPg_name_en());
			pre.setInt(10, item.getPg_created_author_id());
			pre.setByte(11, item.getPg_language());
			
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
	public boolean editProductGroup(ProductGroupObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblpg SET ";
		sql += "pg_name=?, ";
		sql += "pg_ps_id=?, ";
		sql += "pg_manager_id=?, ";
		sql += "pg_notes=?, ";

		sql += "pg_modified_date=?, ";

		sql += "pg_enable=?, ";
		sql += "pg_name_en=?, ";
		sql += "pg_created_author_id=?, ";
		sql += "pg_language=? ";
		sql += " ";
		sql += "WHERE pg_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPg_name());
			pre.setInt(2, item.getPg_ps_id());
			pre.setInt(3, item.getPg_manager_id());
			pre.setString(4, item.getPg_notes());

			pre.setString(5, item.getPg_modified_date());

			pre.setBoolean(6, item.isPg_enable());
			pre.setString(7, item.getPg_name_en());
			pre.setInt(8, item.getPg_created_author_id());
			pre.setByte(9, item.getPg_language());

			pre.setInt(10, item.getPg_id());
			
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
	public boolean delProductGroup(ProductGroupObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "UPDATE tblpg SET ";
		sql += "pg_delete=1, ";
		sql += "pg_deleted_date=?, ";
		sql += "pg_deleted_author=? ";	
		sql += "WHERE pg_id=?";
		

		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getPg_deleted_date());
			pre.setString(1, item.getPg_deleted_author());
			pre.setInt(1, item.getPg_id());
			
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
	
	private boolean isEmpty(ProductGroupObject item) {
		boolean flag = true;
		
		String sql = "SELECT pc_id FROM tblpc ";
		sql += "WHERE (pc_pg_id="+item.getPg_id()+") AND (pc_enable=1) AND (pc_delete=0)";
		
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
	public ResultSet getProductGroup(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblpg ";
		sql += "LEFT JOIN tblps ON pg_ps_id=ps_id ";
		sql += "WHERE (pg_id=?) AND (pg_enable=1) AND (pg_delete=0)";

		return this.get(sql, id);	}

	@Override
	public ResultSet getProductGroups(ProductGroupObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblpg ";
		sql += "LEFT JOIN tblps ON pg_ps_id=ps_id ";
		sql += "WHERE (pg_delete=0) ";
//		sql += "AND (pg_enable=1) ";
		sql += "ORDER BY pg_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	
	}
	
	@Override
	public ResultSet getProductSystems(ProductSystemObject similar) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT ps_id, ps_name FROM tblps ";
		sql += "WHERE (ps_delete=0) ";
//		sql += "AND (ps_enable=1) ";
		sql += "ORDER BY ps_name ASC ";

		return this.gets(sql);	}

	
	public static void main(String[] args) {
		// Tạo đối tượng quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng vào CSDL mức giao tiếp (interface)
		ProductGroup pg = new ProductGroupImpl(cp, "ProductGroup");

		// Lấy tập kết quả
		ResultSet rs = pg.getProductGroups(null, 0, (byte) 10);
		
		//Trả lại kết nối
		pg.releaseConnection();

		// Duyệt và hiển thị kết quả
		String row;
		if (rs != null) {
			try {
				while(rs.next()) {
					row = "ID: " + rs.getInt("pg_id");
					row += "\t\tNAME: " + rs.getString("pg_name");
					row += "\t\tNOTES: " + rs.getString("pg_notes");
					
					System.out.println(row);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
