package jsoft.ads.account.customer;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;

public class CustomerImpl extends BasicImpl implements Customer {

	public CustomerImpl(ConnectionPool cp) {
		super(cp, "Customer");
	}

	@Override
	public boolean addCustomer(CustomerObject item) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO tblcustomer (";
		sql += "customer_fullname, ";
		sql += "customer_address, ";
		sql += "customer_phone, ";
		sql += "customer_mobile, ";
		sql += "customer_office, ";
		sql += "customer_jobarea, ";
		sql += "customer_notes, ";
		sql += "customer_email, ";
		sql += "customer_identity_card, ";
		sql += "customer_username, ";
		sql += "customer_password, ";
		sql += "customer_type_id, ";
		sql += "customer_logined, ";
		sql += "customer_created_date, ";
		sql += "customer_modified_date, ";
		sql += "customer_isactive, ";
		sql += "customer_code, ";
		sql += "customer_company, ";
		sql += "customer_product_id, ";
		sql += "customer_articleextends_id, ";
		sql += "customer_ip";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getCustomer_fullname());
			pre.setString(2, item.getCustomer_address());
			pre.setString(3, item.getCustomer_phone());
			pre.setString(4, item.getCustomer_mobile());
			pre.setString(5, item.getCustomer_office());
			pre.setString(6, item.getCustomer_jobarea());
			pre.setString(7, item.getCustomer_notes());
			pre.setString(8, item.getCustomer_email());
			pre.setString(9, item.getCustomer_identity_card());
			pre.setString(10, item.getCustomer_username());
			pre.setString(11, item.getCustomer_password());
			pre.setShort(12, item.getCustomer_type_id());
			pre.setInt(13, item.getCustomer_logined());
			pre.setString(14, item.getCustomer_created_date());
			pre.setString(15, item.getCustomer_modified_date());
			pre.setBoolean(16, item.isCustomer_isactive());
			pre.setString(17, item.getCustomer_code());
			pre.setString(18, item.getCustomer_company());
			pre.setInt(19, item.getCustomer_product_id());
			pre.setInt(20, item.getCustomer_articleextends_id());
			pre.setString(21, item.getCustomer_ip());

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
	public boolean editCustomer(CustomerObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblcustomer SET ";
		sql += "customer_fullname=?, ";
		sql += "customer_address=?, ";
		sql += "customer_phone=?, ";
		sql += "customer_mobile=?, ";
		sql += "customer_office=?, ";
		sql += "customer_jobarea=?, ";
		sql += "customer_notes=?, ";
		sql += "customer_email=?, ";
		sql += "customer_identity_card=?, ";
		sql += "customer_username=?, ";
		sql += "customer_password=?, ";
		sql += "customer_type_id=?, ";
		sql += "customer_logined=?, ";

		sql += "customer_modified_date=?, ";
		sql += "customer_isactive=?, ";
		sql += "customer_code=?, ";
		sql += "customer_company=?, ";
		sql += "customer_product_id=?, ";
		sql += "customer_articleextends_id=?, ";
		sql += "customer_ip=? ";

		sql += "WHERE customer_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setString(1, item.getCustomer_fullname());
			pre.setString(2, item.getCustomer_address());
			pre.setString(3, item.getCustomer_phone());
			pre.setString(4, item.getCustomer_mobile());
			pre.setString(5, item.getCustomer_office());
			pre.setString(6, item.getCustomer_jobarea());
			pre.setString(7, item.getCustomer_notes());
			pre.setString(8, item.getCustomer_email());
			pre.setString(9, item.getCustomer_identity_card());
			pre.setString(10, item.getCustomer_username());
			pre.setString(11, item.getCustomer_password());
			pre.setShort(12, item.getCustomer_type_id());
			pre.setInt(13, item.getCustomer_logined());

			pre.setString(14, item.getCustomer_modified_date());
			pre.setBoolean(15, item.isCustomer_isactive());
			pre.setString(16, item.getCustomer_code());
			pre.setString(17, item.getCustomer_company());
			pre.setInt(18, item.getCustomer_product_id());
			pre.setInt(19, item.getCustomer_articleextends_id());
			pre.setString(20, item.getCustomer_ip());

			pre.setInt(21, item.getCustomer_id());

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
	public boolean delCustomer(CustomerObject item) {
		// TODO Auto-generated method stub

		if (!this.isEmpty(item)) {
			return false;
		}

		String sql = "DELETE FROM tblcustomer WHERE customer_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getCustomer_id());

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

	private boolean isEmpty(CustomerObject item) {
		boolean flag = true;

		String sql = "SELECT account_id FROM tblaccount ";
		sql += "WHERE (account_customer_id=" + item.getCustomer_id() + ")";

		String sql2 = "SELECT order_id FROM tblorder ";
		sql2 += "WHERE (order_customer_id=" + item.getCustomer_id() + ")";
		
		ResultSet rs = this.gets(sql);
		ResultSet rs2 = this.gets(sql2);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = false;
				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (rs2 != null) {
			try {
				if (rs2.next()) {
					flag = false;
				}

				rs2.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public ResultSet getCustomer(int id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblcustomer WHERE customer_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getCustomers(CustomerObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT *FROM tblcustomer ";
		sql += "";
		sql += "ORDER BY customer_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

}
