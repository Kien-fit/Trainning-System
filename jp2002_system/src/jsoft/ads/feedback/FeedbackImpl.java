package jsoft.ads.feedback;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class FeedbackImpl extends BasicImpl implements Feedback {
	
	public FeedbackImpl(ConnectionPool cp) {
		super(cp, "Feedback");
	}

	@Override
	public boolean addFeedback(FeedbackObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblfeedback (";
		sql +="feedback_title, ";
		sql +="feedback_content, ";
		sql +="feedback_fullname, ";
		sql +="feedback_address, ";
		sql +="feedback_email, ";
		sql +="feedback_phone, ";
		sql +="feedback_product_id, ";
		sql +="feedback_created_date, ";
		sql +="feedback_view, ";
		sql +="feedback_company, ";
		sql +="feedback_intro ";
		sql +=") ";
		sql +="VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getFeedback_title());
			pre.setString(2, item.getFeedback_content());
			pre.setString(3, item.getFeedback_fullname());
			pre.setString(4, item.getFeedback_address());
			pre.setString(5, item.getFeedback_email());
			pre.setString(6, item.getFeedback_phone());
			pre.setInt(7, item.getFeedback_product_id());
			pre.setString(8, item.getFeedback_created_date());
			pre.setBoolean(9, item.isFeedback_view());
			pre.setString(10, item.getFeedback_company());
			pre.setString(11, item.getFeedback_intro());
			
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
	public boolean editFeedback(FeedbackObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblfeedback SET ";
		sql +="feedback_title=?, ";
		sql +="feedback_content=?, ";
		sql +="feedback_fullname=?, ";
		sql +="feedback_address=?, ";
		sql +="feedback_email=?, ";
		sql +="feedback_phone=?, ";
		sql +="feedback_product_id=?, ";
		sql +="feedback_created_date=?, ";
		sql +="feedback_view=?, ";
		sql +="feedback_company=?, ";
		sql +="feedback_intro=? ";
		
		sql +="WHERE feedback_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getFeedback_title());
			pre.setString(2, item.getFeedback_content());
			pre.setString(3, item.getFeedback_fullname());
			pre.setString(4, item.getFeedback_address());
			pre.setString(5, item.getFeedback_email());
			pre.setString(6, item.getFeedback_phone());
			pre.setInt(7, item.getFeedback_product_id());
			pre.setString(8, item.getFeedback_created_date());
			pre.setBoolean(9, item.isFeedback_view());
			pre.setString(10, item.getFeedback_company());
			pre.setString(11, item.getFeedback_intro());

			pre.setInt(12, item.getFeedback_id());
			
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
	public boolean delFeedback(FeedbackObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblfeedback WHERE feedback_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getFeedback_id());
			
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
	
	private boolean isEmpty(FeedbackObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getFeedback_id()+")";
		
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
	public ResultSet getFeedback(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblfeedback WHERE feedback_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getFeedbacks(FeedbackObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblfeedback ";
		sql += "";
		sql += "ORDER BY feedback_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
