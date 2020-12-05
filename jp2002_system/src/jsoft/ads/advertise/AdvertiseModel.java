package jsoft.ads.advertise;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class AdvertiseModel {

	private Advertise adv;

	public AdvertiseModel(ConnectionPool cp, String objectname) {
		this.adv = new AdvertiseImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.adv = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.adv.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.adv.getCP();
	}

	
	// ------------------------------------------------
		public boolean addAdvertise(AdvertiseObject item) {
			return this.adv.addAdvertise(item);
		}

		public boolean editAdvertise(AdvertiseObject item) {
			return this.adv.editAdvertise(item);
		}

		public boolean delAdvertise(AdvertiseObject item) {
			return this.adv.delAdvertise(item);
		}

		// ------------------------------------------------
		public AdvertiseObject getAdvertiseObject(short id) {
			AdvertiseObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.adv.getAdvertise(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new AdvertiseObject();
						item.setAdvertise_id(rs.getShort("advertise_id"));
						item.setAdvertise_title(rs.getString("advertise_title"));
						item.setAdvertise_url(rs.getString("advertise_url"));
						item.setAdvertise_notes(rs.getString("advertise_notes"));
						item.setAdvertise_type(rs.getInt("advertise_type"));
						item.setAdvertise_display(rs.getBoolean("advertise_display"));
						item.setAdvertise_image(rs.getString("advertise_image"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<AdvertiseObject> getAdvertiseObjects(AdvertiseObject similar, short page, byte total) {

			ArrayList<AdvertiseObject> items = new ArrayList<AdvertiseObject>();

			AdvertiseObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.adv.getAdvertises(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new AdvertiseObject();
						item.setAdvertise_id(rs.getShort("advertise_id"));
						item.setAdvertise_title(rs.getString("advertise_title"));
						item.setAdvertise_url(rs.getString("advertise_url"));
						item.setAdvertise_notes(rs.getString("advertise_notes"));
						item.setAdvertise_type(rs.getInt("advertise_type"));
						item.setAdvertise_display(rs.getBoolean("advertise_display"));
						item.setAdvertise_image(rs.getString("advertise_image"));
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
