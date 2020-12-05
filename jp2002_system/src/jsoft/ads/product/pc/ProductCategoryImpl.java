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
		sql += "pc_delete, ";
		sql += "pc_deleted_date, ";
		sql += "pc_deleted_author, ";
		sql += "pc_modified_date, ";
		sql += "pc_created_date, ";
		sql += "pc_image, ";
		sql += "pc_enable, ";
		sql += "pc_name_en, ";
		sql += "pc_created_author_id, ";
		sql += "pc_language ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPc_name());
			pre.setInt(2, item.getPc_pg_id());
			pre.setShort(3, item.getPc_ps_id());
			pre.setInt(4, item.getPc_manager_id());
			pre.setString(5, item.getPc_notes());
			pre.setBoolean(6, item.isPc_delete());
			pre.setString(7, item.getPc_deleted_date());
			pre.setString(8, item.getPc_deleted_author());
			pre.setString(9, item.getPc_modified_date());
			pre.setString(10, item.getPc_created_date());
			pre.setString(11, item.getPc_image());
			pre.setBoolean(12, item.isPc_enable());
			pre.setString(13, item.getPc_name_en());
			pre.setInt(14, item.getPc_created_author_id());
			pre.setByte(15, item.getPc_language());
			
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
		sql += "pc_delete=?, ";
		sql += "pc_deleted_date=?, ";
		sql += "pc_deleted_author=?, ";
		sql += "pc_modified_date=?, ";
		sql += "pc_created_date=?, ";
		sql += "pc_image=?, ";
		sql += "pc_enable=?, ";
		sql += "pc_name_en=?, ";
		sql += "pc_created_author_id=?, ";
		sql += "pc_language=? ";
		sql += " ";
		sql += "WHERE pc_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPc_name());
			pre.setInt(2, item.getPc_pg_id());
			pre.setShort(3, item.getPc_ps_id());
			pre.setInt(4, item.getPc_manager_id());
			pre.setString(5, item.getPc_notes());
			pre.setBoolean(6, item.isPc_delete());
			pre.setString(7, item.getPc_deleted_date());
			pre.setString(8, item.getPc_deleted_author());
			pre.setString(9, item.getPc_modified_date());
			pre.setString(10, item.getPc_created_date());
			pre.setString(11, item.getPc_image());
			pre.setBoolean(12, item.isPc_enable());
			pre.setString(13, item.getPc_name_en());
			pre.setInt(14, item.getPc_created_author_id());
			pre.setByte(15, item.getPc_language());

			pre.setInt(16, item.getPc_id());
			
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
		
		String sql = "DELETE FROM tblpc WHERE pc_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getPc_id());
			
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
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getPc_id()+")";
		
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
		sql += "WHERE pc_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getProductCategorys(ProductCategoryObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblpc ";
		sql += "LEFT JOIN tblpg ON pc_pg_id=pg_id ";
		sql += "LEFT JOIN tblps ON pg_ps_id=ps_id ";
		sql += "";
		sql += "ORDER BY pc_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
