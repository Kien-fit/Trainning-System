package jsoft.ads.pattern;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class PatternControl {

	private Pattern pt;

	public PatternControl(ConnectionPool cp, String objectname) {
		this.pt = new PatternImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.pt = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.pt.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.pt.getCP();
	}
	
	
	// ------------------------------------------------
		public boolean addPattern(PatternObject item) {
			return this.pt.addPattern(item);
		}

		public boolean editPattern(PatternObject item) {
			return this.pt.editPattern(item);
		}

		public boolean delPattern(PatternObject item) {
			return this.pt.delPattern(item);
		}

		// ------------------------------------------------
		public PatternObject getPatternObject(int id) {
			PatternObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.pt.getPattern(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new PatternObject();
						item.setPattern_id(rs.getShort("pattern_id"));
						item.setPattern_title(rs.getString("pattern_title"));
						item.setPattern_summary(rs.getString("pattern_summary"));
						item.setPattern_detail(rs.getString("pattern_detail"));
						item.setPattern_image(rs.getString("pattern_image"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<PatternObject> getPatternObject(PatternObject similar, short page, byte total) {

			ArrayList<PatternObject> items = new ArrayList<PatternObject>();

			PatternObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.pt.getPatterns(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new PatternObject();
						item.setPattern_id(rs.getShort("pattern_id"));
						item.setPattern_title(rs.getString("pattern_title"));
						item.setPattern_summary(rs.getString("pattern_summary"));
						item.setPattern_detail(rs.getString("pattern_detail"));
						item.setPattern_image(rs.getString("pattern_image"));

//						pattern_image1
//						pattern_image2
//						pattern_image3
//						pattern_created_date
//						pattern_last_modified
//						pattern_author_name
//						pattern_author_name_comment
//						pattern_comment
//						pattern_star
//						pattern_size
//						pattern_ps_id
//						pattern_pg_id
//						pattern_pc_id
//						pattern_code
//						pattern_user_view
//						pattern_visited
//						pattern_approved
//						pattern_approved_date
//						pattern_approved_name
//						pattern_user_permis
//						pattern_is_new_comment
//						pattern_new_comment_date
//								
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
