package jsoft.ads.pattern;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class PatternControl {

	private PatternModel pm;

	public PatternControl(ConnectionPool cp) {
		this.pm = new PatternModel(cp);
	}

	protected void finalize() throws Throwable {
		this.pm = null;
		super.finalize();
	}
	
	public ConnectionPool getCP() {
		return this.pm.getCP();
	}

	public void releaseConnection() {
		this.pm.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addPattern(PatternObject item) {
		return this.pm.addPattern(item);
	}

	public boolean editPattern(PatternObject item) {
		return this.pm.editPattern(item);
	}

	public boolean delPattern(PatternObject item) {
		return this.pm.delPattern(item);
	}

	// ------------------------------------------------
	public PatternObject getPatternObject(int id) {
		return this.pm.getPatternObject(id);
	}

	public String viewPatterns(PatternObject similar, short page, byte total) {
		// Lấy danh sách đối tượng
		ArrayList<PatternObject> items = this.pm.getPatternObjects(similar, page, total);

		// Trả về cấu trúc HTML
		return PatternLibrary.viewPatterns(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
