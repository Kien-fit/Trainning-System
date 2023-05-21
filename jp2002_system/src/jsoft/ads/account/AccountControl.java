package jsoft.ads.account;

import jsoft.*;
import jsoft.objects.*;
//import java.sql.*;
import java.util.*;

public class AccountControl {

	private AccountModel am;

	public AccountControl(ConnectionPool cp) {
		this.am = new AccountModel(cp);
	}

	protected void finalize() throws Throwable {
		this.am = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.am.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.am.getCP();
	}

	// **************************************************
	public boolean addAccount(AccountObject item) {
		return this.am.addAccount(item);
	}

	public boolean editAccount(AccountObject item) {
		return this.am.editAccount(item);
	}

	public boolean delAccount(AccountObject item) {
		return this.am.delAccount(item);
	}

	// **************************************************
	public AccountObject getAccountObject(short id) {
		return this.am.getAccountObject(id);
	}

	public String viewAccounts(AccountObject similar, short page, byte total) {

		ArrayList<AccountObject> items = this.am.getAccountObjects(similar, page, total);

		return AccountLibrary.viewAccounts(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tạo bộ quản lý kết nối
		//ConnectionPool cp = new ConnectionPoolImpl();

	}

}
