package jsoft.ads.label;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class LabelImpl extends BasicImpl implements Label {
	
	public LabelImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addLabel(LabelObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tbllabel (";
		sql += "label_title, ";
		sql += "label_infors, ";
		sql += "label_infors_en, ";
		sql += "label_notes";
		sql += ") ";
		sql += "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getLabel_title());
			pre.setString(2, item.getLabel_infors());
			pre.setString(3, item.getLabel_infors_en());
			pre.setString(4, item.getLabel_notes());
			
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
	public boolean editLabel(LabelObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tbllabel SET ";
		sql += "label_title=?, ";
		sql += "label_infors=?, ";
		sql += "label_infors_en=?, ";
		sql += "label_notes=? ";
		
		sql += "WHERE label_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getLabel_title());
			pre.setString(2, item.getLabel_infors());
			pre.setString(3, item.getLabel_infors_en());
			pre.setString(4, item.getLabel_notes());
			
			pre.setInt(5, item.getLabel_id());
			
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
	public boolean delLabel(LabelObject item) {
		// TODO Auto-generated method stub
		

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tbllabel WHERE label_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getLabel_id());
			
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
	
	private boolean isEmpty(LabelObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getLabel_id()+")";
		
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
	public ResultSet getLabel(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tbllabel WHERE label_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getLabels(LabelObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tbllabel ";
		sql += "";
		sql += "ORDER BY label_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
