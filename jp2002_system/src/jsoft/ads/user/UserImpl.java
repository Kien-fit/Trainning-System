package jsoft.ads.user;

import java.sql.*;

import jsoft.objects.UserObject;

import jsoft.*;
import jsoft.ads.basic.*;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
	}

	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub

		// Kiểm tra tài khoản tồn tại chưa
		if (this.isExisting(item)) {
			return false;
		}

		String sql = "INSERT INTO tbluser(";
		sql += "user_name, ";
		sql += "user_pass, ";
		sql += "user_fullname, ";
		sql += "user_birthday, ";
		sql += "user_mobilephone, ";
		sql += "user_homephone, ";
		sql += "user_officephone, ";
		sql += "user_email, ";
		sql += "user_address, ";
		sql += "user_jobarea, ";
		sql += "user_job, ";
		sql += "user_position, ";
		sql += "user_applyyear, ";
		sql += "user_permission, ";
		sql += "user_notes, ";
		sql += "user_roles, ";
		sql += "user_logined, ";
		sql += "user_created_date, ";
		sql += "user_last_modified, ";
		sql += "user_last_logined, ";
		sql += "user_parent_id, ";
		sql += "user_actions";
		sql += ") ";
		sql += "VALUES(?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		// Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyền giá trị cho các tham số
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setString(4, item.getUser_birthday());
			pre.setString(5, item.getUser_mobilephone());
			pre.setString(6, item.getUser_homephone());
			pre.setString(7, item.getUser_officephone());
			pre.setString(8, item.getUser_email());
			pre.setString(9, item.getUser_address());
			pre.setString(10, item.getUser_jobarea());
			pre.setString(11, item.getUser_job());
			pre.setString(12, item.getUser_position());
			pre.setShort(13, item.getUser_applyyear());
			pre.setByte(14, item.getUser_permission());
			pre.setString(15, item.getUser_notes());
			pre.setString(16, item.getUser_roles());
			pre.setShort(17, item.getUser_logined());
			pre.setString(18, item.getUser_created_date());
			pre.setString(19, item.getUser_last_modified());
			pre.setString(20, item.getUser_last_logined());
			pre.setInt(21, item.getUser_parent_id());
			pre.setByte(22, item.getUser_actions());

			//
			return this.add(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// Trở lại trang thái an toàn kết nối
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return false;
	}

	/**
	 * kiem tra tài khoản đã tồn tại chưa
	 * 
	 * @param item
	 * @return
	 */
	private boolean isExisting(UserObject item) {
		boolean flag = false;

		String sql = "SELECT user_id FROM tbluser WHERE user_name='" + item.getUser_name() + "' ";

		ResultSet rs = this.gets(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public boolean editUser(UserObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tbluser SET ";

		sql += "user_pass=md5(?), ";
		sql += "user_fullname=?, ";
		sql += "user_birthday=?, ";
		sql += "user_mobilephone=?, ";
		sql += "user_homephone=?, ";
		sql += "user_officephone=?, ";
		sql += "user_email=?, ";
		sql += "user_address=?, ";
		sql += "user_jobarea=?, ";
		sql += "user_job=?, ";
		sql += "user_position=?, ";
		sql += "user_applyyear=?, ";
		sql += "user_permission=?, ";
		sql += "user_notes=?, ";
		sql += "user_roles=?, ";

		sql += "user_last_modified=?, ";
		sql += "user_last_logined=?, ";
		sql += "user_parent_id=?, ";
		sql += "user_actions=? ";

		sql += "WHERE user_id=?";

		// Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			// Truyền giá trị cho các tham số

			pre.setString(1, item.getUser_pass());
			pre.setString(2, item.getUser_fullname());
			pre.setString(3, item.getUser_birthday());
			pre.setString(4, item.getUser_mobilephone());
			pre.setString(5, item.getUser_homephone());
			pre.setString(6, item.getUser_officephone());
			pre.setString(7, item.getUser_email());
			pre.setString(8, item.getUser_address());
			pre.setString(9, item.getUser_jobarea());
			pre.setString(10, item.getUser_job());
			pre.setString(11, item.getUser_position());
			pre.setShort(12, item.getUser_applyyear());
			pre.setByte(13, item.getUser_permission());
			pre.setString(14, item.getUser_notes());
			pre.setString(15, item.getUser_roles());

			pre.setString(16, item.getUser_last_modified());
			pre.setString(17, item.getUser_last_logined());
			pre.setInt(18, item.getUser_parent_id());
			pre.setByte(19, item.getUser_actions());

			pre.setInt(20, item.getUser_id());

			//
			return this.edit(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// Trở lại trang thái an toàn kết nối
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
	public boolean delUser(UserObject item) {
		// TODO Auto-generated method stub

		// Kiểm tra sự liên quan tới các thông tin khác
		if (!this.isEmpty(item)) {
			return false;
		}

		String sql = "DELETE FROM tbluser WHERE user_id=?";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);

			pre.setInt(1, item.getUser_id());

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

	private boolean isEmpty(UserObject item) {
		boolean flag = true;

		String sql = "SELECT section_id FROM tblsection ";
		sql += "WHERE (section_manager_id=" + item.getUser_id() + ") OR (section_created_author_id=" + item.getUser_id()
				+ ")";

		ResultSet rs = this.gets(sql);
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
		}

		return flag;
	}

	@Override
	public ResultSet getUser(int id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tbluser WHERE user_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tbluser WHERE (user_name=?) AND (user_pass=md5(?))";

		return this.get(sql, username, userpass);
	}

	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		//
		String conds = "";
		if (similar != null) {
			int id = similar.getUser_id();
			byte permis = similar.getUser_permission();

			conds = "(user_permission<=" + permis + ")";
			conds += " AND ((user_parent_id = " + id + ") OR (user_id=" + id + "))";
		}

		String sql = "SELECT * FROM tbluser ";
		if (!conds.equalsIgnoreCase("")) {
			sql += "WHERE " + conds + " ";
		}
		sql += "ORDER BY user_name ASC ";
//		sql += "ORDER BY user_name DESC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	public static void main(String[] args) {
		// Tạo đối tượng quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng vào CSDL mức Giao tiếp (interface)
		User u = new UserImpl(cp);

		// Tạo đối tượng lưu trữ thông tin
		UserObject nUser = new UserObject();
		nUser.setUser_id(60);
		nUser.setUser_name("anhkien");
		nUser.setUser_fullname("Lưu Văn Kiên");
		nUser.setUser_pass("123456789");
		nUser.setUser_email("vankkientl99@gmail.com");
		nUser.setUser_parent_id(21);
		nUser.setUser_created_date("21/09/2020");

		// Thực hiện cập nhật
		boolean result;

//		result = u.addUser(nUser);
		result = u.editUser(nUser);
//		result = u.delUser(nUser);

		if (!result) {
			System.out.println("\n\nKHÔNG THÀNH CÔNG\n");
		}

		// Lấy tập kết quả
		ResultSet rs = u.getUsers(null, 0, (byte) 10);

		// Trả lại kết nối
		u.releaseConnection();

		// duyệt và hiển thị kết quả
		String row;
		if (rs != null) {
			try {
				while (rs.next()) {
					row = "ID: " + rs.getInt("user_id");
					row += "\tNAME: " + rs.getString("user_name");
					row += "\tPASS: " + rs.getString("user_pass");
					row += "\tFULLNAME: " + rs.getString("user_fullname");
					row += "\tEMAIL: " + rs.getString("user_email");

					System.out.println(row);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
