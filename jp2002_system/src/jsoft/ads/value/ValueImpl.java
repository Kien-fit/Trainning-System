package jsoft.ads.value;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class ValueImpl extends BasicImpl implements Value {
	
	public ValueImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addValue(ValueObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblvalue (";
		sql += "value_1, ";
		sql += "value_2, ";
		sql += "value_3, ";
		sql += "value_4, ";
		sql += "value_5, ";
		sql += "value_6, ";
		sql += "value_7, ";
		sql += "value_8, ";
		sql += "value_9, ";
		sql += "value_10, ";
		sql += "value_11, ";
		sql += "value_12, ";
		sql += "value_13, ";
		sql += "value_14, ";
		sql += "value_15, ";
		sql += "value_16, ";
		sql += "value_17, ";
		sql += "value_18, ";
		sql += "value_19, ";
		sql += "value_20, ";
		sql += "value_lable_id ";
		sql += ") ";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getValue_1());
			pre.setString(2, item.getValue_2());
			pre.setString(3, item.getValue_3());
			pre.setString(4, item.getValue_4());
			pre.setString(5, item.getValue_5());
			pre.setString(6, item.getValue_6());
			pre.setString(7, item.getValue_7());
			pre.setString(8, item.getValue_8());
			pre.setString(9, item.getValue_9());
			pre.setString(10, item.getValue_10());
			pre.setString(11, item.getValue_11());
			pre.setString(12, item.getValue_12());
			pre.setString(13, item.getValue_13());
			pre.setString(14, item.getValue_14());
			pre.setString(15, item.getValue_15());
			pre.setString(16, item.getValue_16());
			pre.setString(17, item.getValue_17());
			pre.setString(18, item.getValue_18());
			pre.setString(19, item.getValue_19());
			pre.setString(20, item.getValue_20());
			pre.setShort(21, item.getValue_label_id());
			
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
	public boolean editValue(ValueObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblvalue SET ";
		sql += "value_1=?, ";
		sql += "value_2=?, ";
		sql += "value_3=?, ";
		sql += "value_4=?, ";
		sql += "value_5=?, ";
		sql += "value_6=?, ";
		sql += "value_7=?, ";
		sql += "value_8=?, ";
		sql += "value_9=?, ";
		sql += "value_10=?, ";
		sql += "value_11=?, ";
		sql += "value_12=?, ";
		sql += "value_13=?, ";
		sql += "value_14=?, ";
		sql += "value_15=?, ";
		sql += "value_16=?, ";
		sql += "value_17=?, ";
		sql += "value_18=?, ";
		sql += "value_19=?, ";
		sql += "value_20=?, ";
		sql += "value_lable_id=? ";
		
		sql += "WHERE value_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getValue_1());
			pre.setString(2, item.getValue_2());
			pre.setString(3, item.getValue_3());
			pre.setString(4, item.getValue_4());
			pre.setString(5, item.getValue_5());
			pre.setString(6, item.getValue_6());
			pre.setString(7, item.getValue_7());
			pre.setString(8, item.getValue_8());
			pre.setString(9, item.getValue_9());
			pre.setString(10, item.getValue_10());
			pre.setString(11, item.getValue_11());
			pre.setString(12, item.getValue_12());
			pre.setString(13, item.getValue_13());
			pre.setString(14, item.getValue_14());
			pre.setString(15, item.getValue_15());
			pre.setString(16, item.getValue_16());
			pre.setString(17, item.getValue_17());
			pre.setString(18, item.getValue_18());
			pre.setString(19, item.getValue_19());
			pre.setString(20, item.getValue_20());
			pre.setShort(21, item.getValue_label_id());

			pre.setInt(22, item.getValue_id());
			
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
	public boolean delValue(ValueObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblvalue WHERE value_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getValue_id());
			
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
	
	private boolean isEmpty(ValueObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getValue_id()+")";
		
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
	public ResultSet getValue(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblvalue WHERE value_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getValues(ValueObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblvalue ";
		sql += "";
		sql += "ORDER BY value_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
