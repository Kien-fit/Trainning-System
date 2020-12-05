package jsoft.ads.customer;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class CustomerControl {

	private Customer ctm;

	public CustomerControl(ConnectionPool cp, String objectname) {
		this.ctm = new CustomerImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.ctm = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.ctm.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.ctm.getCP();
	}

	// ------------------------------------------------
		public boolean addCustomer(CustomerObject item) {
			return this.ctm.addCustomer(item);
		}

		public boolean editCustomer(CustomerObject item) {
			return this.ctm.editCustomer(item);
		}

		public boolean delCustomer(CustomerObject item) {
			return this.ctm.delCustomer(item);
		}

		// ------------------------------------------------
		public CustomerObject getCustomerObject(int id) {
			CustomerObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.ctm.getCustomer(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new CustomerObject();
						item.setCustomer_id(rs.getShort("customer_id"));
						item.setCustomer_fullname(rs.getString("customer_fullname"));
						item.setCustomer_address(rs.getString("customer_address"));
						item.setCustomer_phone(rs.getString("customer_phone"));
						item.setCustomer_mobile(rs.getString("customer_mobile"));
						item.setCustomer_office(rs.getString("customer_office"));
						item.setCustomer_jobarea(rs.getString("customer_jobarea"));
						item.setCustomer_notes(rs.getString("customer_notes"));
						item.setCustomer_email(rs.getString("customer_email"));
						item.setCustomer_created_date(rs.getString("customer_created_date"));
						item.setCustomer_modified_date(rs.getString("customer_modified_date"));
						
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<CustomerObject> getCustomerObject(CustomerObject similar, short page, byte total) {

			ArrayList<CustomerObject> items = new ArrayList<CustomerObject>();

			CustomerObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.ctm.getCustomers(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new CustomerObject();
						item.setCustomer_id(rs.getShort("customer_id"));
						item.setCustomer_fullname(rs.getString("customer_fullname"));
						item.setCustomer_address(rs.getString("customer_address"));
						item.setCustomer_phone(rs.getString("customer_phone"));
						item.setCustomer_mobile(rs.getString("customer_mobile"));
						item.setCustomer_office(rs.getString("customer_office"));
						item.setCustomer_jobarea(rs.getString("customer_jobarea"));
						item.setCustomer_notes(rs.getString("customer_notes"));
						item.setCustomer_email(rs.getString("customer_email"));
						item.setCustomer_created_date(rs.getString("customer_created_date"));
						item.setCustomer_modified_date(rs.getString("customer_modified_date"));
						
//						customer_identity_card
//						customer_username
//						customer_password
//						customer_type_id
//						customer_logined
//						customer_created_date
//						customer_modified_date
//						customer_isactive
//						customer_code
//						customer_company
//						customer_product_id
//						customer_articleextends_id
//						customer_ip
						
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
