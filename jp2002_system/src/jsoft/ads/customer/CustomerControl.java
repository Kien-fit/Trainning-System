package jsoft.ads.customer;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class CustomerControl {

	private CustomerModel ctm;

	public CustomerControl(ConnectionPool cp) {
		this.ctm = new CustomerModel(cp);
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
			return this.ctm.getCustomerObject(id);
		}

		public String getCustomerObject(CustomerObject similar, short page, byte total) {

			ArrayList<CustomerObject> items = new ArrayList<CustomerObject>();

			return CustomerLibrary.viewCustomers(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
