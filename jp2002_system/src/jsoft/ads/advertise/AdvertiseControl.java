package jsoft.ads.advertise;

import jsoft.*;
import jsoft.objects.*;
//import java.sql.*;
import java.util.*;

public class AdvertiseControl {

	private AdvertiseModel adv;

	public AdvertiseControl(ConnectionPool cp) {
		this.adv = new AdvertiseModel(cp);
	}

	protected void finalize() throws Throwable {
		this.adv = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.adv.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.adv.getCP();
	}

	
	// ------------------------------------------------
		public boolean addAdvertise(AdvertiseObject item) {
			return this.adv.addAdvertise(item);
		}

		public boolean editAdvertise(AdvertiseObject item) {
			return this.adv.editAdvertise(item);
		}

		public boolean delAdvertise(AdvertiseObject item) {
			return this.adv.delAdvertise(item);
		}

		// ------------------------------------------------
		public AdvertiseObject getAdvertiseObject(short id) {
			return this.adv.getAdvertiseObject(id);
		}

		public String viewAdvertises(AdvertiseObject similar, short page, byte total) {

			ArrayList<AdvertiseObject> items = this.adv.getAdvertiseObjects(similar, page, total);

			return AdvertiseLibrary.viewAdvertises(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
