package jsoft.ads.statistic;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class StatisticControl {

	private StatisticModel sm;

	public StatisticControl(ConnectionPool cp) {
		this.sm = new StatisticModel(cp);
	}

	protected void finalize() throws Throwable {
		this.sm = null;
		super.finalize();
	}

	public ConnectionPool getCP() {
		return this.sm.getCP();
	}

	public void relaeseConnection() {
		this.sm.releaseConnection();
	}

	// ------------------------------------------------
	public boolean addStatistic(StatisticObject item) {
		return this.sm.addStatistic(item);
	}

	public boolean editStatistic(StatisticObject item) {
		return this.sm.editStatistic(item);
	}

	public boolean delStatistic(StatisticObject item) {
		return this.sm.delStatistic(item);
	}

	// ------------------------------------------------
	public StatisticObject getStatisticObject(int id) {
		return this.sm.getStatisticObject(id);
	}

	public String viewStatistics(StatisticObject similar, short page, byte total) {

		ArrayList<StatisticObject> items = new ArrayList<StatisticObject>();

		return StatisticLibrary.viewStatistics(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
