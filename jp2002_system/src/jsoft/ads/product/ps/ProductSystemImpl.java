package jsoft.ads.product.ps;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class ProductSystemImpl extends BasicImpl implements ProductSystem {
	
	public ProductSystemImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addProductSystem(ProductSystemObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblps (";		
		sql += "ps_name";
		sql += "ps_manager_id";
		sql += "ps_notes";
		sql += "ps_delete";
		sql += "ps_deleted_date";
		sql += "ps_deleted_author";
		sql += "ps_modified_date";
		sql += "ps_created_date";
		sql += "ps_table";
		sql += "ps_enable";
		sql += "ps_name_en";
		sql += "ps_created_author_id";
		sql += "ps_language";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPs_name());
			pre.setInt(2, item.getPs_manager_id());
			pre.setString(3, item.getPs_notes());
			pre.setBoolean(4, item.isPs_delete());
			pre.setString(5, item.getPs_deleted_date());
			pre.setString(6, item.getPs_deleted_author());
			pre.setString(7, item.getPs_modified_date());
			pre.setString(8, item.getPs_created_date());
			pre.setString(9, item.getPs_table());
			pre.setBoolean(10, item.isPs_enable());
			pre.setString(11, item.getPs_name_en());
			pre.setInt(12, item.getPs_created_author_id());
			pre.setByte(13, item.getPs_language());
			
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
	public boolean editProductSystem(ProductSystemObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblps SET ";		
		sql += "ps_name=?, ";
		sql += "ps_manager_id=?, ";
		sql += "ps_notes=?, ";
		sql += "ps_delete=?, ";
//		sql += "ps_deleted_date=?, ";
//		sql += "ps_deleted_author=?, ";
		sql += "ps_modified_date=?, ";
//		sql += "ps_created_date=?, ";
		sql += "ps_table=?, ";
		sql += "ps_enable=?, ";
		sql += "ps_name_en=?, ";
		sql += "ps_created_author_id=?, ";
		sql += "ps_language=? ";
		
		sql += "WHERE ps_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPs_name());
			pre.setInt(2, item.getPs_manager_id());
			pre.setString(3, item.getPs_notes());
			pre.setBoolean(4, item.isPs_delete());
//			pre.setString(5, item.getPs_deleted_date());
//			pre.setString(6, item.getPs_deleted_author());
			pre.setString(5, item.getPs_modified_date());
//			pre.setString(8, item.getPs_created_date());
			pre.setString(6, item.getPs_table());
			pre.setBoolean(7, item.isPs_enable());
			pre.setString(8, item.getPs_name_en());
			pre.setInt(9, item.getPs_created_author_id());
			pre.setByte(10, item.getPs_language());

			pre.setInt(11, item.getPs_id());
			
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
	public boolean delProductSystem(ProductSystemObject item) {
		// TODO Auto-generated method stub
		
		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE  FROM tblps WHERE ps_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setInt(1, item.getPs_id());
			
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
	
	public boolean isEmpty(ProductSystemObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id = " + item.getPs_id() + ")";
		ResultSet rs = this.gets(sql);
		if(rs != null) {
			try {
				if(rs.next()) {
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
	public ResultSet getProductSystem(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblps WHERE ps_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getProductSystems(ProductSystemObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblps ";
		sql += "";
		sql += "ORDER BY ps_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
