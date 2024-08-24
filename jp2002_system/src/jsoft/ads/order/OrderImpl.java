package jsoft.ads.order;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class OrderImpl extends BasicImpl implements Order {
	
	public OrderImpl(ConnectionPool cp) {
		super(cp, "Order");
	}

	@Override
	public boolean addOrder(OrderObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblorder (";
		sql += "order_article_id, ";
		sql += "order_customer_id, ";
		sql += "order_created_date ";
		sql += ") ";
		sql += "VALUES (?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getOrder_article_id());
			pre.setString(2, item.getOrder_customer_id());
			pre.setString(3, item.getOrder_created_date());
			
			return this.add(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean editOrder(OrderObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblorder SET ";
		sql += "order_article_id=?, ";
		sql += "order_customer_id=?, ";
		
		sql += "WHERE order_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getOrder_article_id());
			pre.setString(2, item.getOrder_customer_id());
			
			pre.setInt(3, item.getOrder_id());
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean delOrder(OrderObject item) {
		// TODO Auto-generated method stub
		
		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblorder WHERE order_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, item.getOrder_id());
			
			return this.del(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean isEmpty(OrderObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id =" + item.getOrder_id() + ")";
		
		ResultSet rs = this.gets(sql);
		if(rs != null) {
			try {
				if(rs.next()) {
					flag = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public ResultSet getOrder(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblorder WHERE order_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getOrders(OrderObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblorder ";
		sql += "";
		sql += "ORDER BY order_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
