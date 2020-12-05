package jsoft.ads.account;

import java.sql.*;
import jsoft.*;
import jsoft.objects.*;
import jsoft.ads.basic.*;

public class AccountImpl extends BasicImpl implements Account {
	
	public AccountImpl(ConnectionPool cp) {
		super(cp, "Account");
	}

	@Override
	public boolean addAccount(AccountObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblaccount (";	
		sql += "account_customer_id, ";
		sql += "account_money, ";
		sql += "account_actived_date, ";
		sql += "account_notes, ";
		sql += "account_current_money, ";
		sql += "account_type";
		sql += ") ";
		sql += "VALUES(?,?,?,?,?,?)";
		
		//Thực thi biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getAccount_customer_id());
			pre.setInt(2, item.getAccount_money());
			pre.setString(3, item.getAccount_actived_date());
			pre.setString(4, item.getAccount_notes());
			pre.setInt(5, item.getAccount_current_money());
			pre.setInt(6, item.getAccount_type());
			
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
	public boolean editAccount(AccountObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblaccount SET ";	
		sql += "account_customer_id=?, ";
		sql += "account_money=?, ";
		sql += "account_actived_date=?, ";
		sql += "account_notes=?, ";
		sql += "account_current_money=?, ";
		sql += "account_type=? ";
		
		sql += "WHERE account_id=?";
		
		//Thực thi biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getAccount_customer_id());
			pre.setInt(2, item.getAccount_money());
			pre.setString(3, item.getAccount_actived_date());
			pre.setString(4, item.getAccount_notes());
			pre.setInt(5, item.getAccount_current_money());
			pre.setInt(6, item.getAccount_type());
			
			pre.setInt(7, item.getAccount_id());
			
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
	public boolean delAccount(AccountObject item) {
		// TODO Auto-generated method stub

		//Kiểm tra sự liên quan tới các thông tin khác
		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblaccount WHERE account_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setInt(1, item.getAccount_id());
			
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
	
	private boolean isEmpty(AccountObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getAccount_id() + ")";
		
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
	public ResultSet getAccount(short id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblaccount ";
		sql += "";
		sql += "";
		sql += "WHERE acount_id=?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getAccounts(AccountObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblaccount ";
		sql += "";
		sql += "";
		sql += "";
		sql += "ORDER BY account_name ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);
	}

}
