package jsoft.ads.feedback;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class FeedbackControl {

	private FeedbackModel fm;

	public FeedbackControl(ConnectionPool cp) {
		this.fm = new FeedbackModel(cp);
	}

	protected void finalize() throws Throwable {
		this.fm = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.fm.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.fm.getCP();
	}

	// ------------------------------------------------
		public boolean addFeedback(FeedbackObject item) {
			return this.fm.addFeedback(item);
		}

		public boolean editFeedback(FeedbackObject item) {
			return this.fm.editFeedback(item);
		}

		public boolean delFeedback(FeedbackObject item) {
			return this.fm.delFeedback(item);
		}

		// ------------------------------------------------
		public FeedbackObject getFeedbackObject(int id) {
			return this.fm.getFeedbackObject(id);
			
		}

		public String getFeedbackObject(FeedbackObject similar, short page, byte total) {

			ArrayList<FeedbackObject> items = new ArrayList<FeedbackObject>();

			return FeedbackLibrary.viewFeedbacks(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
