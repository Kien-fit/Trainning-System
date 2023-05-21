package jsoft.ads.interior;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;

public class InteriorImpl extends BasicImpl implements Interior {

	public InteriorImpl(ConnectionPool cp) {
		super(cp, "Interior");
	}

	@Override
	public boolean addInterior(InteriorObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblinterior (";
		sql += "interior_product_code, ";
		sql += "interior_manufacture, ";
		sql += "interior_model, ";
		sql += "interior_size, ";
		sql += "interior_stuff, ";
		sql += "interior_origin, ";
		sql += "interior_construct, ";
		sql += "interior_color";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getInterior_product_code());
			pre.setString(2, item.getInterior_manufacture());
			pre.setString(3, item.getInterior_model());
			pre.setString(4, item.getInterior_size());
			pre.setString(5, item.getInterior_stuff());
			pre.setString(6, item.getInterior_origin());
			pre.setString(7, item.getInterior_construct());
			pre.setByte(8, item.getInterior_color());
			
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
	public boolean editInterior(InteriorObject item) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE tblinterior SET ";
		sql += "interior_product_code=?, ";
		sql += "interior_manufacture=?, ";
		sql += "interior_model=?, ";
		sql += "interior_size=?, ";
		sql += "interior_stuff=?, ";
		sql += "interior_origin=?, ";
		sql += "interior_construct=?, ";
		sql += "interior_color=?, ";
		
		sql += "WHERE interior_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getInterior_product_code());
			pre.setString(2, item.getInterior_manufacture());
			pre.setString(3, item.getInterior_model());
			pre.setString(4, item.getInterior_size());
			pre.setString(5, item.getInterior_stuff());
			pre.setString(6, item.getInterior_origin());
			pre.setString(7, item.getInterior_construct());
			pre.setByte(8, item.getInterior_color());
			
			pre.setInt(9, item.getInterior_id());
			
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
	public boolean delInterior(InteriorObject item) {
		// TODO Auto-generated method stub

		if (!this.isEmpty(item)) {
			return false;
		}

		String sql = "DELETE FROM tblinterior WHERE interior_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getInterior_id());

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

	private boolean isEmpty(InteriorObject item) {
		boolean flag = true;

		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id=" + item.getInterior_id() + ")";

		ResultSet rs = this.gets(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
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
	public ResultSet getInterior(int id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblinterior WHERE interior_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getInteriors(InteriorObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT *FROM tblinterior ";
		sql += "";
		sql += "ORDER BY interior_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

}
