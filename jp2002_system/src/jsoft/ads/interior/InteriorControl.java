package jsoft.ads.interior;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class InteriorControl {

	private InteriorModel im;

	public InteriorControl(ConnectionPool cp) {
		this.im = new InteriorModel(cp);
	}

	protected void finalize() throws Throwable {
		this.im = null;
		super.finalize();
	}
	
	public ConnectionPool getCP() {
		return this.im.getCP();
	}

	public void releaseConnection() {
		this.im.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addInterior(InteriorObject item) {
		return this.im.addInterior(item);
	}

	public boolean editInterior(InteriorObject item) {
		return this.im.editInterior(item);
	}

	public boolean delInterior(InteriorObject item) {
		return this.im.delInterior(item);
	}

	// ------------------------------------------------
	public InteriorObject getInteriorObject(short id) {
		return this.im.getInteriorObject(id);
	}

	public String ViewInteriors(InteriorObject similar, short page, byte total) {

			ArrayList<InteriorObject> items = new ArrayList<InteriorObject>();

			return InteriorLibrary.viewInteriors(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
