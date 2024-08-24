package jsoft.ads.label;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class LabelControl {

	private LabelModel lm;

	public LabelControl(ConnectionPool cp) {
		this.lm = new LabelModel(cp);
	}

	protected void finalize() throws Throwable {
		this.lm = null;
		super.finalize();
	}
	
	public ConnectionPool getCP() {
		return this.lm.getCP();
	}

	public void releaseConnection() {
		this.lm.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addLabel(LabelObject item) {
		return this.lm.addLabel(item);
	}

	public boolean editLabel(LabelObject item) {
		return this.lm.editLabel(item);
	}

	public boolean delLabel(LabelObject item) {
		return this.lm.delLabel(item);
	}

	// ------------------------------------------------
	public LabelObject getLabelObject(int id) {
		return this.lm.getLabelObject(id);
	}

	public String viewLabels(LabelObject similar, short page, byte total) {

		ArrayList<LabelObject> items = new ArrayList<LabelObject>();

		return LabelLibrary.viewLabels(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
