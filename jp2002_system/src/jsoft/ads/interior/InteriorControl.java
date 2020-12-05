package jsoft.ads.interior;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class InteriorControl {

	private Interior it;

	public InteriorControl(ConnectionPool cp, String objectname) {
		this.it = new InteriorImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.it = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.it.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.it.getCP();
	}

	// ------------------------------------------------
	public boolean addInterior(InteriorObject item) {
		return this.it.addInterior(item);
	}

	public boolean editInterior(InteriorObject item) {
		return this.it.editInterior(item);
	}

	public boolean delInterior(InteriorObject item) {
		return this.it.delInterior(item);
	}

	// ------------------------------------------------
	public InteriorObject getInteriorObject(short id) {
		InteriorObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.it.getInterior(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new InteriorObject();
					item.setInterior_id(rs.getShort("interior_id"));
					item.setInterior_product_code(rs.getString("interior_product_code"));
					item.setInterior_manufacture(rs.getString("interior_manufacture"));
					item.setInterior_model(rs.getString("interior_model"));
				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<InteriorObject> getInteriorObject(InteriorObject similar, short page, byte total) {

			ArrayList<InteriorObject> items = new ArrayList<InteriorObject>();

			InteriorObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.it.getInteriors(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new InteriorObject();
						item.setInterior_id(rs.getShort("interior_id"));
						item.setInterior_product_code(rs.getString("interior_product_code"));
						item.setInterior_manufacture(rs.getString("interior_manufacture"));
						item.setInterior_model(rs.getString("interior_model"));
						item.setInterior_size(rs.getString("interior_size"));
						item.setInterior_stuff(rs.getString("interior_stuff"));
						item.setInterior_origin(rs.getString("interior_origin"));
						item.setInterior_construct(rs.getString("interior_construct"));
						item.setInterior_color(rs.getByte("interior_color"));
						
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
