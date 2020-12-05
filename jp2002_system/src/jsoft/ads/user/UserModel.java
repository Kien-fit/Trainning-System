package jsoft.ads.user;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class UserModel {

	private User u;

	public UserModel(ConnectionPool cp) {
		this.u = new UserImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.u = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.u.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.u.getCP();
	}

	// **************************************************
	public boolean addUser(UserObject item) {
		return this.u.addUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.u.editUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.u.delUser(item);
	}

	// **************************************************
	public UserObject getUserObject(int id) {
		UserObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.u.getUser(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_permission(rs.getByte("user_permission"));

				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public UserObject getUserObject(String username, String userpass) {
		UserObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.u.getUser(username, userpass);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_permission(rs.getByte("user_permission"));

				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public ArrayList<UserObject> getUserObjects(UserObject similar, short page, byte total) {

		ArrayList<UserObject> items = new ArrayList<>();

		UserObject item = null;

		// Lấy dữ liệu
		int at = (page - 1) * total;
		ResultSet rs = this.u.getUsers(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_permission(rs.getByte("user_permission"));

					item.setUser_logined(rs.getShort("user_logined"));
//					item.setUser_logined(rs.getShort("user_last_logined"));

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
		UserModel um = new UserModel(cp);

		//lay danh sach
		ArrayList<UserObject> users = um.getUserObjects(null, (short) 1, (byte) 10);

		//Tra ket noi
		um.releaseConnection();
		
		//toString
		for (UserObject user : users) {
			System.out.print("ID: " + user.getUser_id());
			System.out.print("\tNAME: " + user.getUser_name());
			System.out.print("\tFULLNAME: " + user.getUser_fullname());
			System.out.print("\tPHONE: " + user.getUser_mobilephone());
			System.out.print("\tEMAIL: " + user.getUser_email() + "\n");
		}

	}

}
