package jsoft.ads.computer;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ComputerControl {

	private ComputerModel cm;

	public ComputerControl(ConnectionPool cp) {
		this.cm = new ComputerModel(cp);
	}

	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	// ------------------------------------------------
		public boolean addComputer(ComputerObject item) {
			return this.cm.addComputer(item);
		}

		public boolean editComputer(ComputerObject item) {
			return this.cm.editComputer(item);
		}

		public boolean delComputer(ComputerObject item) {
			return this.cm.delComputer(item);
		}

		// ------------------------------------------------
		public ComputerObject getComputerObject(short id) {
			return this.cm.getComputerObject(id);
		}

		public String getComputerObject(ComputerObject similar, short page, byte total) {

			ArrayList<ComputerObject> items = new ArrayList<ComputerObject>();

			return ComputerLibrary.viewComputers(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
