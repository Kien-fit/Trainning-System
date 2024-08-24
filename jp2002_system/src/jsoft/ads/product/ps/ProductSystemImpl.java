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
		sql += "VALUES (?,?,?,0,?,?,?,?,?,1,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPs_name());
			pre.setInt(2, item.getPs_manager_id());
			pre.setString(3, item.getPs_notes());

			pre.setString(4, item.getPs_deleted_date());
			pre.setString(5, item.getPs_deleted_author());
			pre.setString(6, item.getPs_modified_date());
			pre.setString(7, item.getPs_created_date());
			pre.setString(8, item.getPs_table());

			pre.setString(9, item.getPs_name_en());
			pre.setInt(10, item.getPs_created_author_id());
			pre.setByte(11, item.getPs_language());
			
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

		sql += "ps_modified_date=?, ";

		sql += "ps_table=?, ";
		sql += "ps_enable=?, ";
		sql += "ps_name_en=?, ";

		sql += "ps_language=? ";
		
		sql += "WHERE ps_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getPs_name());
			pre.setInt(2, item.getPs_manager_id());
			pre.setString(3, item.getPs_notes());

			pre.setString(4, item.getPs_modified_date());

			pre.setString(5, item.getPs_table());
			pre.setBoolean(6, item.isPs_enable());
			pre.setString(7, item.getPs_name_en());

			pre.setByte(8, item.getPs_language());

			pre.setInt(9, item.getPs_id());
			
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
		
		String sql = "UPDATE tblps SET ";
		sql += "ps_delete=1, ";
		sql += "ps_deleted_date=?, ";
		sql += "ps_deleted_author=? ";	
		sql += "WHERE ps_id=?";
		
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
		
		String sql = "SELECT pg_id FROM tblpg ";
		sql += "WHERE (pg_ps_id = " + item.getPs_id() + ") AND (pg_enable=1) AND (pg_delete=0)";
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
		
		String sql = "SELECT * FROM tblps ";
		sql += "WHERE (ps_id=?) AND (ps_enable=1) AND (ps_delete=0)";

		return this.get(sql, id);	}

	@Override
	public ResultSet getProductSystems(ProductSystemObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblps ";
		sql += "WHERE (ps_delete=0) ";
//		sql += "AND (ps_enable=1) ";
		sql += "ORDER BY ps_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	@Override
	public ResultSet getUsers(UserObject similar) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT user_id, user_name, user_fullname FROM tbluser ";
		sql	+= "WHERE ((user_parent_id=?) OR (user_id="+similar.getUser_id()+"))";
			
		return this.get(sql, similar.getUser_id());
	}
}
