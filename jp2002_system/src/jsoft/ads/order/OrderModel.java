package jsoft.ads.order;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class OrderModel {

	private Order od;

	public OrderModel(ConnectionPool cp, String objectname) {
		this.od = new OrderImpl(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.od = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.od.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.od.getCP();
	}
	
	// ------------------------------------------------
		public boolean addOrder(OrderObject item) {
			return this.od.addOrder(item);
		}

		public boolean editOrder(OrderObject item) {
			return this.od.editOrder(item);
		}

		public boolean delOrder(OrderObject item) {
			return this.od.delOrder(item);
		}

		// ------------------------------------------------
		public OrderObject getOrderObject(int id) {
			OrderObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.od.getOrder(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new OrderObject();
						item.setOrder_id(rs.getShort("order_id"));
						item.setOrder_article_id(rs.getString("order_article_id"));
						item.setOrder_customer_id(rs.getString("order_customer_id"));
						item.setOrder_created_date(rs.getString("order_created_date"));
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<OrderObject> getOrderObjects(OrderObject similar, short page, byte total) {

			ArrayList<OrderObject> items = new ArrayList<OrderObject>();

			OrderObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.od.getOrders(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new OrderObject();
						item.setOrder_id(rs.getShort("order_id"));
						item.setOrder_article_id(rs.getString("order_article_id"));
						item.setOrder_customer_id(rs.getString("order_customer_id"));
						item.setOrder_created_date(rs.getString("order_created_date"));
						
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
