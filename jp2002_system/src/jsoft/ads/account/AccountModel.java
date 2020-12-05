package jsoft.ads.account;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class AccountModel {

	private Account acc;

	public AccountModel(ConnectionPool cp) {
		this.acc = new AccountImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.acc = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.acc.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.acc.getCP();
	}

	// **************************************************
	public boolean addAccount(AccountObject item) {
		return this.acc.addAccount(item);
	}

	public boolean editAccount(AccountObject item) {
		return this.acc.editAccount(item);
	}

	public boolean delAccount(AccountObject item) {
		return this.acc.delAccount(item);
	}

	// **************************************************
	public AccountObject getAccountObject(short id) {
		AccountObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.acc.getAccount(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new AccountObject();
					item.setAccount_id(rs.getInt("account_id"));
					item.setAccount_customer_id(rs.getInt("account_customer_id"));
					item.setAccount_money(rs.getInt("account_money"));
					item.setAccount_actived_date(rs.getString("account_actived_date"));
					item.setAccount_notes(rs.getString("account_notes"));
					item.setAccount_current_money(rs.getInt("account_current_money"));
					item.setAccount_type(rs.getInt("account_type"));

				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList<AccountObject> getAccountObjects(AccountObject similar, short page, byte total) {

		ArrayList<AccountObject> items = new ArrayList<>();

		AccountObject item = null;

		// Lấy dữ liệu
		int at = (page - 1) * total;
		ResultSet rs = this.acc.getAccounts(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item.setAccount_id(rs.getInt("account_id"));
					item.setAccount_customer_id(rs.getInt("account_customer_id"));
					item.setAccount_money(rs.getInt("account_money"));
					item.setAccount_actived_date(rs.getString("account_actived_date"));
					item.setAccount_notes(rs.getString("account_notes"));
					item.setAccount_current_money(rs.getInt("account_current_money"));
					item.setAccount_type(rs.getInt("account_type"));

					// Thêm đối tượng vào danh sách
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

		// Tạo bộ quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thii chức năng mới Model
		AccountModel um = new AccountModel(cp);

		ArrayList<AccountObject> Accounts = um.getAccountObjects(null, (short) 1, (byte) 10);

		for (AccountObject Account : Accounts) {
			System.out.print("ID: " + Account.getAccount_id());
		}

	}

}
