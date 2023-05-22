package jsoft.ads.comment;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class CommentImpl extends BasicImpl implements Comment {
	
	public CommentImpl(ConnectionPool cp) {
		super(cp, "Comment");
	}

	@Override
	public boolean addComment(CommentObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblcomment(";
		sql += "comment_created_date, ";
		sql += "comment_title, ";
		sql += "comment_content, ";
		sql += "comment_enabled, ";
		sql += "comment_type_id, ";
		sql += "comment_user_phone, ";
		sql += "comment_user_fullname, ";
		sql += "comment_user_email, ";
		sql += "comment_content_intro, ";
		sql += "comment_notes, ";
		sql += "comment_for_name, ";
		sql += "comment_for_id";
		sql += ") ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getComment_created_date());
			pre.setString(2, item.getComment_title());
			pre.setString(3, item.getComment_content());
			pre.setBoolean(4, item.isComment_enabled());
			pre.setInt(5, item.getComment_type_id());
			pre.setString(6, item.getComment_user_phone());
			pre.setString(7, item.getComment_user_fullname());
			pre.setString(8, item.getComment_user_email());
			pre.setString(9, item.getComment_content_intro());
			pre.setString(10, item.getComment_notes());
			pre.setString(11, item.getComment_for_name());
			pre.setString(12, item.getComment_for_id());
			
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
	public boolean editComment(CommentObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblcomment SET ";
		sql += "comment_title=?, ";
		sql += "comment_content=?, ";
		sql += "comment_enabled=?, ";
		sql += "comment_type_id=?, ";
		sql += "comment_user_phone=?, ";
		sql += "comment_user_fullname=?, ";
		sql += "comment_user_email=?, ";
		sql += "comment_content_intro=?, ";
		sql += "comment_notes=?, ";
		sql += "comment_for_name=?, ";
		sql += "comment_for_id=? ";
		sql += "WHERE comment_id=? ";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getComment_title());
			pre.setString(2, item.getComment_content());
			pre.setBoolean(3, item.isComment_enabled());
			pre.setInt(4, item.getComment_type_id());
			pre.setString(5, item.getComment_user_phone());
			pre.setString(6, item.getComment_user_fullname());
			pre.setString(7, item.getComment_user_email());
			pre.setString(8, item.getComment_content_intro());
			pre.setString(9, item.getComment_notes());
			pre.setString(10, item.getComment_for_name());
			pre.setString(11, item.getComment_for_id());
			pre.setInt(12, item.getComment_id());
			
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
	public boolean delComment(CommentObject item) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM tblcomment WHERE comment_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, item.getComment_id());
			
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

	@Override
	public ResultSet getComment(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblcomment WHERE comment_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getComments(CommentObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblcomment ";
		sql += "";
		sql += "ORDER BY comment_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
