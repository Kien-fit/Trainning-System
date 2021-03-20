package jsoft.ads.article.section;

import java.sql.*;

import jsoft.objects.*;
import jsoft.*;
import jsoft.ads.basic.*;

public class SectionImpl extends BasicImpl implements Section {

	public SectionImpl(ConnectionPool cp, String objectName) {
		// TODO Auto-generated constructor stub
		super(cp, objectName);
	}

	@Override
	public boolean addSection(SectionObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblsection (";
		sql += "section_name, ";
		sql += "section_notes, ";
		sql += "section_created_date, ";
		sql += "section_manager_id, ";
		sql += "section_enable, ";
		sql += "section_delete, ";
		sql += "section_last_modified, ";
		sql += "section_created_author_id, ";
		sql += "section_name_en, ";
		sql += "section_language ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		//Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			//Truyền giá trị cho các tham số
			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			pre.setString(3, item.getSection_created_date());
			pre.setInt(4, item.getSection_manager_id());
			pre.setBoolean(5, item.isSection_enable());
			pre.setBoolean(6, item.isSection_delete());
			pre.setString(7, item.getSection_last_modified());
			pre.setInt(8, item.getSection_created_author_id());
			pre.setString(9, item.getSection_name_en());
			pre.setByte(10, item.getSection_language());
			
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
	public boolean editSection(SectionObject item) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE tblsection SET ";
		sql += "section_name=?, ";
		sql += "section_notes=?, ";
		
		sql += "section_manager_id=?, ";
		sql += "section_enable=?, ";
		sql += "section_delete=?, ";
		sql += "section_last_modified=?, ";
		
		sql += "section_name_en=?, ";
		sql += "section_language=? ";
		
		sql += "WHERE section_id=?";
		
		//Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			//Truyền giá trị cho các tham số
			pre.setString(1, item.getSection_name());
			pre.setString(2, item.getSection_notes());
			
			pre.setInt(3, item.getSection_manager_id());
			pre.setBoolean(4, item.isSection_enable());
			pre.setBoolean(5, item.isSection_delete());
			pre.setString(6, item.getSection_last_modified());
			
			pre.setString(7, item.getSection_name_en());
			pre.setByte(8, item.getSection_language());
			
			pre.setShort(9, item.getSection_id());
			
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
	public boolean delSection(SectionObject item) {
		// TODO Auto-generated method stub
		
		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblsection WHERE section_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setShort(1, item.getSection_id());
			
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
	
	private boolean isEmpty(SectionObject item) {
		boolean flag = true;
		
		String sql = "SELECT category_id FROM tblcategory ";
		sql += "WHERE (category_manager_id="+item.getSection_id()+")";
		
		ResultSet rs = this.gets(sql);
		if(rs!=null) {
			try {
				if(rs.next()) {
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
	public ResultSet getSection(short id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblsection WHERE section_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getSections(SectionObject similar, int at, byte total) {
		// TODO Auto-generated method stub

/*		//
		String conds = "";
		if (similar != null) {
			int id = similar.getUser_id();
			byte permis = similar.getUser_permission();

			conds = "(user_permission<=" + permis + ")";
			conds += " AND ((user_parent_id = " + id + ") OR (user_id=" + id + "))";
			
			//Lấy từ khóa tìm kiếm
			String key = similar.getUser_name();
			if(key!=null && !key.equalsIgnoreCase("")) {
				conds += " AND (";
				conds += "(user_name LIKE '%"+key+"%' ) OR ";
				conds += "(user_fullname LIKE '%"+key+"%' ) OR ";
				conds += "(user_email LIKE '%"+key+"%' ) OR ";
				conds += "(user_address LIKE '%"+key+"%' ) OR ";
				conds += "(user_notes LIKE '%"+key+"%' )";
				conds += ")";
			}
		}
*/		
		String sql = "SELECT *FROM tblsection ";
		
		sql += "";
		sql += "ORDER BY section_name ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

	public static void main(String[] args) {
		// Tạo đối tượng quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng vào CSDL mức Giao tiếp (interface)
		Section sec = new SectionImpl(cp, "Section");

		// Lấy tập kết quả
		ResultSet rs = sec.getSections(null, 0, (byte) 10);

		// duyệt và hiển thị kết quả
		String row;
		if (rs != null) {
			try {
				while (rs.next()) {
					row = "ID: " + rs.getInt("section_id");
					row += "\t\tNAME: " + rs.getString("section_name");
					row += "\t\tNOTES: " + rs.getString("section_notes");
					row += "\t\tCREATED DATE: " + rs.getString("section_created_date");

					System.out.println(row);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ResultSet getUsers(UserObject similar) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT user_id, user_name, user_fullname FROM tbluser WHERE ((user_parent_id=?) OR (user_id="+similar.getUser_id()+"))";
		
		
		return this.get(sql, similar.getUser_id());
	}

}
