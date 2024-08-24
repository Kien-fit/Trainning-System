package jsoft.ads.order;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class OrderControl {

	private OrderModel om;

	public OrderControl(ConnectionPool cp) {
		this.om = new OrderModel(cp);
	}

	protected void finalize() throws Throwable {
		this.om = null;
		super.finalize();
	}
	
	public ConnectionPool getCP() {
		return this.om.getCP();
	}

	public void releaseConnection() {
		this.om.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addOrder(OrderObject item) {
		return this.om.addOrder(item);
	}

	public boolean editOrder(OrderObject item) {
		return this.om.editOrder(item);
	}

	public boolean delOrder(OrderObject item) {
		return this.om.delOrder(item);
	}

	// ------------------------------------------------
	public OrderObject getOrderObject(int id) {
		return this.om.getOrderObject(id);
	}

	public String viewOrders(OrderObject similar, short page, byte total) {

		ArrayList<OrderObject> items = new ArrayList<OrderObject>();

		return OrderLibrary.viewOrders(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
