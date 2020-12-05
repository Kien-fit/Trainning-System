package jsoft.ads.label;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class LabelModel {

	private Label lb;

	public LabelModel(ConnectionPool cp, String objectname) {
		this.lb = new LabelImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.lb = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.lb.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.lb.getCP();
	}

	// ------------------------------------------------
		public boolean addLabel(LabelObject item) {
			return this.lb.addLabel(item);
		}

		public boolean editLabel(LabelObject item) {
			return this.lb.editLabel(item);
		}

		public boolean delLabel(LabelObject item) {
			return this.lb.delLabel(item);
		}

		// ------------------------------------------------
		public LabelObject getLabelObject(int id) {
			LabelObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.lb.getLabel(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new LabelObject();
						item.setLabel_id(rs.getShort("label_id"));
						item.setLabel_title(rs.getString("label_title"));
						item.setLabel_infors(rs.getString("label_infors"));
						item.setLabel_infors_en(rs.getString("label_infors_en"));
						item.setLabel_notes(rs.getString("label_notes"));
						
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<LabelObject> getLabelObjects(LabelObject similar, short page, byte total) {

			ArrayList<LabelObject> items = new ArrayList<LabelObject>();

			LabelObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.lb.getLabels(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new LabelObject();
						item.setLabel_id(rs.getShort("label_id"));
						item.setLabel_title(rs.getString("label_title"));
						item.setLabel_infors(rs.getString("label_infors"));
						item.setLabel_infors_en(rs.getString("label_infors_en"));
						item.setLabel_notes(rs.getString("label_notes"));
						
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
