package jsoft.ads.value;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ValueControl {

	private ValueModel vl;

	public ValueControl(ConnectionPool cp, String objectname) {
		this.vl = new ValueModel(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.vl = null;
		super.finalize();
	}

	public ConnectionPool getCP() {
		return this.vl.getCP();
	}

	public void releaseConnection() {
		this.vl.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addValue(ValueObject item) {
		return this.vl.addValue(item);
	}

	public boolean editValue(ValueObject item) {
		return this.vl.editValue(item);
	}

	public boolean delValue(ValueObject item) {
		return this.vl.delValue(item);
	}

	// ------------------------------------------------
	public ValueObject getValueObject(int id) {
		return this.vl.getValueObject(id);
	}

	public String viewValues(ValueObject similar, short page, byte total) {

		ArrayList<ValueObject> items = this.vl.getValueObjects(similar, page, total);

		return ValueLibrary.viewValues(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
