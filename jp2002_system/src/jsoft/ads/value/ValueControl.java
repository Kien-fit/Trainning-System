package jsoft.ads.value;

import jsoft.*;
import jsoft.objects.*;
//import java.sql.*;
import java.util.*;

public class ValueControl {

	private ValueModel vm;

	public ValueControl(ConnectionPool cp) {
		this.vm = new ValueModel(cp);
	}

	protected void finalize() throws Throwable {
		this.vm = null;
		super.finalize();
	}

	public ConnectionPool getCP() {
		return this.vm.getCP();
	}

	public void releaseConnection() {
		this.vm.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addValue(ValueObject item) {
		return this.vm.addValue(item);
	}

	public boolean editValue(ValueObject item) {
		return this.vm.editValue(item);
	}

	public boolean delValue(ValueObject item) {
		return this.vm.delValue(item);
	}

	// ------------------------------------------------
	public ValueObject getValueObject(int id) {
		return this.vm.getValueObject(id);
	}

	public String viewValues(ValueObject similar, short page, byte total) {

		ArrayList<ValueObject> items = this.vm.getValueObjects(similar, page, total);

		return ValueLibrary.viewValues(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
