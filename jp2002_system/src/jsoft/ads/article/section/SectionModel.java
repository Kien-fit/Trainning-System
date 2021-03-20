package jsoft.ads.article.section;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class SectionModel {

	private Section sec;

	public SectionModel(ConnectionPool cp) {
		this.sec = new SectionImpl(cp, "Section");
	}

	protected void finalize() throws Throwable {
		this.sec = null;
		super.finalize();
	}
	
	public void releaseConnection() {
		this.sec.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.sec.getCP();
	}

	// ------------------------------------------------
	public boolean addSection(SectionObject item) {
		return this.sec.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.sec.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.sec.delSection(item);
	}

	// ------------------------------------------------
	public SectionObject getSectionObject(short id) {
		SectionObject item = null;

		// Lấy dữ liệu
		ResultSet rs = this.sec.getSection(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_notes(rs.getString("section_notes"));
					item.setSection_created_date(rs.getString("section_created_date"));
//					item.setSection_last_modified(rs.getString("section_last_modified"));
				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<SectionObject> getSectionObjects(SectionObject similar, short page, byte total) {

		ArrayList<SectionObject> items = new ArrayList<SectionObject>();

		SectionObject item = null;

		// Lấy dữ liệu
		int at = (page - 1) * total;
		ResultSet rs = this.sec.getSections(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new SectionObject();
					item.setSection_id(rs.getShort("section_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setSection_notes(rs.getString("section_notes"));
					item.setSection_created_date(rs.getString("section_created_date"));
					item.setSection_last_modified(rs.getString("section_last_modified"));

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

	public ArrayList<UserObject> getUsers(UserObject similar){
		ArrayList<UserObject> users= new ArrayList<>();
		
		ResultSet rs = this.sec.getUsers(similar);
		UserObject user = null;
		if(rs!=null) {
			try {
				while(rs.next()) {
					user = new UserObject();
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_fullname(rs.getString("user_fullname"));

					users.add(user);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
