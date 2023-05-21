package jsoft.ads.statistic;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class StatisticModel {

	private Statistic st;

	public StatisticModel(ConnectionPool cp) {
		this.st = new StatisticImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.st = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.st.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.st.getCP();
	}
	
	// ------------------------------------------------
		public boolean addStatistic(StatisticObject item) {
			return this.st.addStatistic(item);
		}

		public boolean editStatistic(StatisticObject item) {
			return this.st.editStatistic(item);
		}

		public boolean delStatistic(StatisticObject item) {
			return this.st.delStatistic(item);
		}

		// ------------------------------------------------
		public StatisticObject getStatisticObject(int id) {
			StatisticObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.st.getStatistic(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new StatisticObject();
						item.setStatistic_id(rs.getShort("statistic_id"));
						item.setStatistic_current_date(rs.getString("statistic_current_date"));
						item.setStatistic_visited(rs.getInt("statistic_visited"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<StatisticObject> getStatisticObjects(StatisticObject similar, short page, byte total) {

			ArrayList<StatisticObject> items = new ArrayList<StatisticObject>();

			StatisticObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.st.getStatistics(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new StatisticObject();
						item.setStatistic_id(rs.getShort("statistic_id"));
						item.setStatistic_current_date(rs.getString("statistic_current_date"));
						item.setStatistic_visited(rs.getInt("statistic_visited"));
						
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
