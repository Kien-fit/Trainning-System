package jsoft.ads.article.section;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class SectionControl {

	private SectionModel sm;

	public SectionControl(ConnectionPool cp) {
		this.sm = new SectionModel(cp);
	}

	protected void finalize() throws Throwable {
		this.sm = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.sm.releaseConnection();
	}

	public ConnectionPool getCP() {
		return this.sm.getCP();
	}

	// ------------------------------------------------
	public boolean addSection(SectionObject item) {
		return this.sm.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.sm.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.sm.delSection(item);
	}

	// ------------------------------------------------
	public SectionObject getSectionObject(short id) {
		return this.sm.getSectionObject(id);
	}

	public String viewSections(SectionObject similar, short page, byte total) {
		// Lấy danh sách đối tượng
		ArrayList<SectionObject> items = this.sm.getSectionObjects(similar, page, total);

		// Trả về cấu trúc HTML
		return SectionLibrary.viewSections(items);
	}
	
	public String viewUserOptions(UserObject user) {
		ArrayList<UserObject> users = this.sm.getUsers(user);
		return SectionLibrary.viewUserOptions(users);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
