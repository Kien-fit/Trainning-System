package jsoft.ads.feedback;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class FeedbackModel {

	private Feedback fb;

	public FeedbackModel(ConnectionPool cp, String objectname) {
		this.fb = new FeedbackImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.fb = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.fb.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.fb.getCP();
	}

	// ------------------------------------------------
		public boolean addFeedback(FeedbackObject item) {
			return this.fb.addFeedback(item);
		}

		public boolean editFeedback(FeedbackObject item) {
			return this.fb.editFeedback(item);
		}

		public boolean delFeedback(FeedbackObject item) {
			return this.fb.delFeedback(item);
		}

		// ------------------------------------------------
		public FeedbackObject getFeedbackObject(int id) {
			FeedbackObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.fb.getFeedback(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new FeedbackObject();
						item.setFeedback_id(rs.getShort("feedback_id"));
						item.setFeedback_title(rs.getString("feedback_title"));
						item.setFeedback_content(rs.getString("feedback_content"));
						item.setFeedback_fullname(rs.getString("feedback_fullname"));
						item.setFeedback_address(rs.getString("feedback_address"));
						item.setFeedback_email(rs.getString("feedback_email"));
						item.setFeedback_phone(rs.getString("feedback_phone"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<FeedbackObject> getFeedbackObjects(FeedbackObject similar, short page, byte total) {

			ArrayList<FeedbackObject> items = new ArrayList<FeedbackObject>();

			FeedbackObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.fb.getFeedbacks(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new FeedbackObject();
						item.setFeedback_id(rs.getShort("feedback_id"));
						item.setFeedback_title(rs.getString("feedback_title"));
						item.setFeedback_content(rs.getString("feedback_content"));
						item.setFeedback_fullname(rs.getString("feedback_fullname"));
						item.setFeedback_address(rs.getString("feedback_address"));
						item.setFeedback_email(rs.getString("feedback_email"));
						item.setFeedback_phone(rs.getString("feedback_phone"));
						item.setFeedback_product_id(rs.getInt("feedback_product_id"));
						item.setFeedback_created_date(rs.getString("feedback_created_date"));
						item.setFeedback_view(rs.getBoolean("feedback_view"));
						item.setFeedback_company(rs.getString("feedback_company"));
						item.setFeedback_intro(rs.getString("feedback_intro"));
						
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
