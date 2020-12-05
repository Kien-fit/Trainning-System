package jsoft.ads.account;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class AccountControl {

	private AccountModel acc;

	public AccountControl(ConnectionPool cp) {
		this.acc = new AccountModel(cp);
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
		return this.acc.getAccountObject(id);
	}

	public String viewAccounts(AccountObject similar, short page, byte total) {

		ArrayList<AccountObject> items = this.acc.getAccountObjects(similar, page, total);

		return AccountLibrary.viewAccounts(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tạo bộ quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

	}

}
