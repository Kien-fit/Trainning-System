package jsoft.ads.statistic;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class StatisticImpl extends BasicImpl implements Statistic {
	
	public StatisticImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addStatistic(StatisticObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblstatistic (";
		
		sql += "statistic_current_date, ";
		sql += "statistic_visited ";
		sql += "";
		sql += ") ";
		sql += "VALUES (?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getStatistic_current_date());
			pre.setInt(1, item.getStatistic_visited());
			
			return this.add(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean editStatistic(StatisticObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblstatistic SET ";
		
		sql += "statistic_current_date=?, ";
		sql += "statistic_visited=? ";
		sql += "";
		
		sql += "WHERE statistic_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getStatistic_current_date());
			pre.setInt(2, item.getStatistic_visited());

			pre.setInt(3, item.getStatistic_id());
			
			return this.edit(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean delStatistic(StatisticObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblstatistic WHERE statistic_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getStatistic_id());
			
			return this.del(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		return false;
	}
	
	private boolean isEmpty(StatisticObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getStatistic_id()+")";
		
		ResultSet rs = this.gets(sql);
		if(rs!=null) {
			try {
				if(rs.next()) {
					flag = false;
				}
				
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}


	@Override
	public ResultSet getStatistic(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblstatistic WHERE statistic_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getStatistics(StatisticObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblstatistic ";
		sql += "";
		sql += "ORDER BY statistic_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
