package jsoft.ads.agent;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.basic.BasicImpl;


public class AgentImpl extends BasicImpl implements Agent {
	
	public AgentImpl(ConnectionPool cp) {
		super(cp, "Agent");
	}

	@Override
	public boolean addAgent(AgentObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblagent (";	
		sql += "agent_name, ";
		sql += "agent_address, ";
		sql += "agent_phone, ";
		sql += "agent_email, ";
		sql += "agent_website, ";
		sql += "agent_map, ";
		sql += "agent_notes, ";
		sql += "agent_created_date, ";
		sql += "agent_last_modified, ";
		sql += "agent_manager_id, ";
		sql += "agent_manager_name, ";
		sql += "agent_enable, ";
		sql += "agent_delete, ";
		sql += "agent_boss, ";
		sql += "agent_boss_mobile, ";
		sql += "agent_pass, ";
		sql += "agent_image, ";
		sql += "agent_area_id, ";
		sql += "agent_tax_code, ";
		sql += "agent_city_id";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getAgent_name());
			pre.setString(2, item.getAgent_address());
			pre.setString(3, item.getAgent_phone());
			pre.setString(4, item.getAgent_email());
			pre.setString(5, item.getAgent_website());
			pre.setString(6, item.getAgent_map());
			pre.setString(7, item.getAgent_notes());
			pre.setString(8, item.getAgent_created_date());
			pre.setString(9, item.getAgent_last_modified());
			pre.setInt(10, item.getAgent_manager_id());
			pre.setString(11, item.getAgent_manager_name());
			pre.setBoolean(12, item.isAgent_enable());
			pre.setBoolean(13, item.isAgent_delete());
			pre.setString(14, item.getAgent_boss());
			pre.setString(15, item.getAgent_boss_mobile());
			pre.setString(16, item.getAgent_pass());
			pre.setString(17, item.getAgent_image());
			pre.setShort(18, item.getAgent_area_id());
			pre.setString(19, item.getAgent_tax_code());
			pre.setShort(20, item.getAgent_city_id());
			
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
	public boolean editAgent(AgentObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblagent SET ";	
		sql += "agent_name=? ";
		sql += "agent_address=? ";
		sql += "agent_phone=? ";
		sql += "agent_email=? ";
		sql += "agent_website=? ";
		sql += "agent_map=? ";
		sql += "agent_notes=? ";

		sql += "agent_last_modified=? ";
		sql += "agent_manager_id=? ";
		sql += "agent_manager_name=? ";
		sql += "agent_enable=? ";
		sql += "agent_delete=? ";
		sql += "agent_boss=? ";
		sql += "agent_boss_mobile=? ";
		sql += "agent_pass=? ";
		sql += "agent_image=? ";
		sql += "agent_area_id=? ";
		sql += "agent_tax_code=? ";
		sql += "agent_city_id=? ";
		
		sql += "WHERE agent_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getAgent_name());
			pre.setString(2, item.getAgent_address());
			pre.setString(3, item.getAgent_phone());
			pre.setString(4, item.getAgent_email());
			pre.setString(5, item.getAgent_website());
			pre.setString(6, item.getAgent_map());
			pre.setString(7, item.getAgent_notes());

			pre.setString(8, item.getAgent_last_modified());
			pre.setInt(9, item.getAgent_manager_id());
			pre.setString(10, item.getAgent_manager_name());
			pre.setBoolean(11, item.isAgent_enable());
			pre.setBoolean(12, item.isAgent_delete());
			pre.setString(13, item.getAgent_boss());
			pre.setString(14, item.getAgent_boss_mobile());
			pre.setString(15, item.getAgent_pass());
			pre.setString(16, item.getAgent_image());
			pre.setShort(17, item.getAgent_area_id());
			pre.setString(18, item.getAgent_tax_code());
			pre.setShort(19, item.getAgent_city_id());
			
			pre.setInt(20, item.getAgent_id());
			
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
	public boolean delAgent(AgentObject item) {
		// TODO Auto-generated method stub

//		if(!this.isEmpty(item)) {
//			return false;
//		}
		
		String sql = "DELETE FROM tblagent WHERE agent_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getAgent_id());
			
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
/*
	private boolean isEmpty(AgentObject item) {
		boolean flag = true;
		
		String sql = "SELECT _id FROM tbl ";
		sql += "WHERE (_id="+item.getAgent_id()+")";
		
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
*/

	@Override
	public ResultSet getAgent(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblagent WHERE agent_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getAgents(AgentObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT *FROM tblagent ";
		sql += "";
		sql += "ORDER BY agent_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
