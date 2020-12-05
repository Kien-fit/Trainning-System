package jsoft.ads.comment;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class CommentImpl extends BasicImpl implements Comment {
	
	public CommentImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addComment(CommentObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editComment(CommentObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delComment(CommentObject item) {
		// TODO Auto-generated method stub
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
		
		String sql = "SELECT *FROM tblcomment ";
		sql += "";
		sql += "ORDER BY comment_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
