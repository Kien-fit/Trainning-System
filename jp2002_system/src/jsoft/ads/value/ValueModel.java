package jsoft.ads.value;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ValueModel {

	private Value vl;

	public ValueModel(ConnectionPool cp) {
		this.vl = new ValueImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.vl = null;
		super.finalize();
	}
	
	public ConnectionPool getCP() {
		return this.vl.getCP();
	}
	
	public void releaseConnection() {
		this.vl.releaseConnection();
	}
	
	// ------------------------------------------------
		public boolean addValue(ValueObject item) {
			return this.vl.addValue(item);
		}

		public boolean editValue(ValueObject item) {
			return this.vl.editValue(item);
		}

		public boolean delValue(ValueObject item) {
			return this.vl.delValue(item);
		}

		// ------------------------------------------------
		public ValueObject getValueObject(int id) {
			ValueObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.vl.getValue(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new ValueObject();
						item.setValue_id(rs.getShort("value_id"));
						item.setValue_1(rs.getString("value_1"));
						item.setValue_2(rs.getString("value_2"));
						item.setValue_3(rs.getString("value_3"));
						item.setValue_4(rs.getString("value_4"));
						item.setValue_5(rs.getString("value_5"));
						item.setValue_label_id(rs.getShort("value_label_id"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<ValueObject> getValueObjects(ValueObject similar, short page, byte total) {

			ArrayList<ValueObject> items = new ArrayList<ValueObject>();

			ValueObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.vl.getValues(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new ValueObject();
						item.setValue_id(rs.getShort("value_id"));
						item.setValue_1(rs.getString("value_1"));
						item.setValue_2(rs.getString("value_2"));
						item.setValue_3(rs.getString("value_3"));
						item.setValue_4(rs.getString("value_4"));
						item.setValue_5(rs.getString("value_5"));
						item.setValue_label_id(rs.getShort("value_label_id"));
						
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
