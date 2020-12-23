package jsoft.ads.user;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class UserControl {

	private UserModel um;

	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	protected void finalize() throws Throwable {
		this.um = null;
		super.finalize();
	}

	public ConnectionPool getCP() {
		return this.um.getCP();
	}
	
	public void releaseConnection() {
		this.um.releaseConnection();
	}

	// **************************************************
	public boolean addUser(UserObject item) {
		return this.um.addUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.um.editUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.um.delUser(item);
	}

	// **************************************************
	public UserObject getUserObject(int id) {
		return this.um.getUserObject(id);
	}

	public UserObject getUserObject(String username, String userpass) {
		return this.um.getUserObject(username, userpass);
	}
	
	// **************************************************
	public String viewUsers(UserObject similar, short page, byte total,UserObject user) {
		// Lấy danh sách đối tượng
		ArrayList<UserObject> items = this.um.getUserObjects(similar, page, total);
		
		// Trả về cấu trúc HTML
		return UserLibrary.viewUsers(items,user);
	}
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionPool cp = new ConnectionPoolImpl();

		UserControl um = new UserControl(cp);

		// Lấy cấu trúc trình bày
		String view = um.viewUsers(null, (short) 1, (byte) 10);
		um.releaseConnection();

		System.out.print(view);
	}
*/
}
