package jsoft.ads.computer;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class ComputerImpl extends BasicImpl implements Computer {
	
	public ComputerImpl(ConnectionPool cp, String objectname) {
		super(cp, objectname);
	}

	@Override
	public boolean addComputer(ComputerObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editComputer(ComputerObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delComputer(ComputerObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getComputer(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblcomputer WHERE computer_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getComputers(ComputerObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblcomputer ";
		sql += "";
		sql += "ORDER BY computer_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
