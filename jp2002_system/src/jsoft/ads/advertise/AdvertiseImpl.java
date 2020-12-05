package jsoft.ads.advertise;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class AdvertiseImpl extends BasicImpl implements Advertise {
	
	public AdvertiseImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addAdvertise(AdvertiseObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tbladvertise (";
		sql += "advertise_title, ";
		sql += "advertise_url, ";
		sql += "advertise_notes, ";
		sql += "advertise_type, ";
		sql += "advertise_display, ";
		sql += "advertise_image, ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getAdvertise_title());
			pre.setString(2, item.getAdvertise_url());
			pre.setString(3, item.getAdvertise_notes());
			pre.setInt(4, item.getAdvertise_type());
			pre.setBoolean(5, item.isAdvertise_display());
			pre.setString(6, item.getAdvertise_image());
			
			return this.add(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;

	}

	@Override
	public boolean editAdvertise(AdvertiseObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tbladvertise SET ";
		sql += "advertise_title=?, ";
		sql += "advertise_url=?, ";
		sql += "advertise_notes=?, ";
		sql += "advertise_type=?, ";
		sql += "advertise_display=?, ";
		sql += "advertise_image=?, ";
		
		sql += "WHERE advertise_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getAdvertise_title());
			pre.setString(2, item.getAdvertise_url());
			pre.setString(3, item.getAdvertise_notes());
			pre.setInt(4, item.getAdvertise_type());
			pre.setBoolean(5, item.isAdvertise_display());
			pre.setString(6, item.getAdvertise_image());

			pre.setInt(7, item.getAdvertise_id());
			
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delAdvertise(AdvertiseObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tbladvertise WHERE advertise_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getAdvertise_id());
			
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
	
	private boolean isEmpty(AdvertiseObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getAdvertise_id()+")";
		
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
	public ResultSet getAdvertise(short id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tbladvertise WHERE advertise_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getAdvertises(AdvertiseObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tbladvertise ";
		sql += "";
		sql += "ORDER BY advertise_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
