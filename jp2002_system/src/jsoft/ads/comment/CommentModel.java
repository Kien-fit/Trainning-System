package jsoft.ads.comment;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class CommentModel {

	private Comment cmt;

	public CommentModel(ConnectionPool cp, String objectname) {
		this.cmt = new CommentImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.cmt = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.cmt.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.cmt.getCP();
	}

	// ------------------------------------------------
		public boolean addComment(CommentObject item) {
			return this.cmt.addComment(item);
		}

		public boolean editComment(CommentObject item) {
			return this.cmt.editComment(item);
		}

		public boolean delComment(CommentObject item) {
			return this.cmt.delComment(item);
		}

		// ------------------------------------------------
		public CommentObject getCommentObject(int id) {
			CommentObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.cmt.getComment(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new CommentObject();
						item.setComment_id(rs.getShort("comment_id"));
//						item.setComment_name(rs.getString("comment_name"));
//						item.setComment_notes(rs.getString("comment_notes"));
//						item.setComment_created_date(rs.getString("comment_created_date"));
//						item.setComment_last_modified(rs.getString("comment_last_modified"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<CommentObject> getCommentObjects(CommentObject similar, short page, byte total) {

			ArrayList<CommentObject> items = new ArrayList<CommentObject>();

			CommentObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.cmt.getComments(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new CommentObject();
						item.setComment_id(rs.getShort("comment_id"));
//						item.setComment_name(rs.getString("comment_name"));
//						item.setComment_notes(rs.getString("comment_notes"));
//						item.setComment_created_date(rs.getString("comment_created_date"));
//						item.setComment_last_modified(rs.getString("comment_last_modified"));
						
						items.add(item);
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return items;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
