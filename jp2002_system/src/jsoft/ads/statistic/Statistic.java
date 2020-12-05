package jsoft.ads.statistic;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Statistic extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addStatistic(StatisticObject item);
	public boolean editStatistic(StatisticObject item);
	public boolean delStatistic(StatisticObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getStatistic(int id);
	public ResultSet getStatistics(StatisticObject similar, int at, byte total);

}
