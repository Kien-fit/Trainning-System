package jsoft.ads.computer;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ComputerModel {

	private Computer cpt;

	public ComputerModel(ConnectionPool cp, String objectname) {
		this.cpt = new ComputerImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.cpt = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.cpt.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.cpt.getCP();
	}

	// ------------------------------------------------
		public boolean addComputer(ComputerObject item) {
			return this.cpt.addComputer(item);
		}

		public boolean editComputer(ComputerObject item) {
			return this.cpt.editComputer(item);
		}

		public boolean delComputer(ComputerObject item) {
			return this.cpt.delComputer(item);
		}

		// ------------------------------------------------
		public ComputerObject getComputerObject(short id) {
			ComputerObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.cpt.getComputer(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new ComputerObject();
						item.setComputer_id(rs.getShort("computer_id"));
//						item.setComputer_name(rs.getString("computer_name"));
//						item.setComputer_notes(rs.getString("computer_notes"));
//						item.setComputer_created_date(rs.getString("computer_created_date"));
//						item.setComputer_last_modified(rs.getString("computer_last_modified"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<ComputerObject> getComputerObjects(ComputerObject similar, short page, byte total) {

			ArrayList<ComputerObject> items = new ArrayList<ComputerObject>();

			ComputerObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.cpt.getComputers(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new ComputerObject();
						item.setComputer_id(rs.getShort("computer_id"));
//						item.setComputer_name(rs.getString("computer_name"));
//						item.setComputer_notes(rs.getString("computer_notes"));
//						item.setComputer_created_date(rs.getString("computer_created_date"));
//						item.setComputer_last_modified(rs.getString("computer_last_modified"));
						
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
