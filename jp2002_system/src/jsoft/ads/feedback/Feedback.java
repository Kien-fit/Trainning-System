package jsoft.ads.feedback;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Feedback extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addFeedback(FeedbackObject item);
	public boolean editFeedback(FeedbackObject item);
	public boolean delFeedback(FeedbackObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getFeedback(int id);
	public ResultSet getFeedbacks(FeedbackObject similar, int at, byte total);

}
