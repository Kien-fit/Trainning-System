package jsoft.ads.pattern;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class PatternImpl extends BasicImpl implements Pattern {
	
	public PatternImpl(ConnectionPool cp) {
		super(cp, "Pattern");
	}

	@Override
	public boolean addPattern(PatternObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblpattern (";
		sql += "pattern_title, ";
		sql += "pattern_summary, ";
		sql += "pattern_detail, ";
		sql += "pattern_image, ";
		sql += "pattern_image1, ";
		sql += "pattern_image2, ";
		sql += "pattern_image3, ";
		sql += "pattern_created_date, ";
		sql += "pattern_last_modified, ";
		sql += "pattern_author_name, ";
		sql += "pattern_author_name_comment, ";
		sql += "pattern_comment, ";
		sql += "pattern_star, ";
		sql += "pattern_size, ";
		sql += "pattern_ps_id, ";
		sql += "pattern_pg_id, ";
		sql += "pattern_pc_id, ";
		sql += "pattern_code, ";
		sql += "pattern_user_view, ";
		sql += "pattern_visited, ";
		sql += "pattern_approved, ";
		sql += "pattern_approved_date, ";
		sql += "pattern_approved_name, ";
		sql += "pattern_user_permis, ";
		sql += "pattern_is_new_comment, ";
		sql += "pattern_new_comment_date ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getPattern_title());
			pre.setString(2, item.getPattern_summary());
			pre.setString(3, item.getPattern_detail());
			pre.setString(4, item.getPattern_image());
			pre.setString(5, item.getPattern_image1());
			pre.setString(6, item.getPattern_image2());
			pre.setString(7, item.getPattern_image3());
			pre.setString(8, item.getPattern_created_date());
			pre.setString(9, item.getPattern_last_modified());
			pre.setString(10, item.getPattern_author_name());
			pre.setString(11, item.getPattern_author_name_comment());
			pre.setString(12, item.getPattern_comment());
			pre.setString(13, item.getPattern_star());
			pre.setString(14, item.getPattern_size());
			pre.setShort(15, item.getPattern_ps_id());
			pre.setShort(16, item.getPattern_pg_id());
			pre.setShort(17, item.getPattern_pc_id());
			pre.setString(18, item.getPattern_code());
			pre.setString(19, item.getPattern_user_view());
			pre.setShort(20, item.getPattern_visited());
			pre.setByte(21, item.getPattern_approved());
			pre.setString(22, item.getPattern_approved_date());
			pre.setString(23, item.getPattern_approved_name());
			pre.setShort(24, item.getPattern_user_permis());
			pre.setBoolean(25, item.isPattern_is_new_comment());
			pre.setString(26, item.getPattern_new_comment_date());
			
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
	public boolean editPattern(PatternObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblpattern SET ";
		sql += "pattern_title=?, ";
		sql += "pattern_summary=?, ";
		sql += "pattern_detail=?, ";
		sql += "pattern_image=?, ";
		sql += "pattern_image1=?, ";
		sql += "pattern_image2=?, ";
		sql += "pattern_image3=?, ";

		sql += "pattern_last_modified=?, ";
		sql += "pattern_author_name=?, ";
		sql += "pattern_author_name_comment=?, ";
		sql += "pattern_comment=?, ";
		sql += "pattern_star=?, ";
		sql += "pattern_size=?, ";
		sql += "pattern_ps_id=?, ";
		sql += "pattern_pg_id=?, ";
		sql += "pattern_pc_id=?, ";
		sql += "pattern_code=?, ";
		sql += "pattern_user_view=?, ";
		sql += "pattern_visited=?, ";
		sql += "pattern_approved=?, ";
		sql += "pattern_approved_date=?, ";
		sql += "pattern_approved_name=?, ";
		sql += "pattern_user_permis=?, ";
		sql += "pattern_is_new_comment=?, ";
		sql += "pattern_new_comment_date=? ";
		sql += " ";
		sql += "WHERE pattern_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getPattern_title());
			pre.setString(2, item.getPattern_summary());
			pre.setString(3, item.getPattern_detail());
			pre.setString(4, item.getPattern_image());
			pre.setString(5, item.getPattern_image1());
			pre.setString(6, item.getPattern_image2());
			pre.setString(7, item.getPattern_image3());

			pre.setString(8, item.getPattern_last_modified());
			pre.setString(9, item.getPattern_author_name());
			pre.setString(10, item.getPattern_author_name_comment());
			pre.setString(11, item.getPattern_comment());
			pre.setString(12, item.getPattern_star());
			pre.setString(13, item.getPattern_size());
			pre.setShort(14, item.getPattern_ps_id());
			pre.setShort(15, item.getPattern_pg_id());
			pre.setShort(16, item.getPattern_pc_id());
			pre.setString(17, item.getPattern_code());
			pre.setString(18, item.getPattern_user_view());
			pre.setShort(19, item.getPattern_visited());
			pre.setByte(20, item.getPattern_approved());
			pre.setString(21, item.getPattern_approved_date());
			pre.setString(22, item.getPattern_approved_name());
			pre.setShort(23, item.getPattern_user_permis());
			pre.setBoolean(24, item.isPattern_is_new_comment());
			pre.setString(25, item.getPattern_new_comment_date());
			
			pre.setInt(26, item.getPattern_id());
			
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
	public boolean delPattern(PatternObject item) {
		// TODO Auto-generated method stub
		
		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblpattern WHERE pattern_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, item.getPattern_id());
			
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

	public boolean isEmpty(PatternObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id = " + item.getPattern_id() + ") ";
		ResultSet rs = this.gets(sql);
		if(rs!=null) {
			try {
				if(rs.next()){
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
	public ResultSet getPattern(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblpattern WHERE pattern_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getPatterns(PatternObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblpattern ";
		sql += "";
		sql += "ORDER BY pattern_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

}
