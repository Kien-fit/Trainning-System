package jsoft.ads.agent;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class AgentModel {

	private Agent agent;

	public AgentModel(ConnectionPool cp) {
		this.agent = new AgentImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.agent = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.agent.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.agent.getCP();
	}

	// ------------------------------------------------
		public boolean addAgent(AgentObject item) {
			return this.agent.addAgent(item);
		}

		public boolean editAgent(AgentObject item) {
			return this.agent.editAgent(item);
		}

		public boolean delAgent(AgentObject item) {
			return this.agent.delAgent(item);
		}

		// ------------------------------------------------
		public AgentObject getAgentObject(short id) {
			AgentObject item = null;

			// Lấy dữ liệu
			ResultSet rs = this.agent.getAgent(id);
			if (rs != null) {
				try {
					if (rs.next()) {
						item = new AgentObject();
						item.setAgent_id(rs.getShort("agent_id"));
						item.setAgent_name(rs.getString("agent_name"));
						item.setAgent_address(rs.getString("agent_address"));
						item.setAgent_phone(rs.getString("agent_phone"));
						item.setAgent_email(rs.getString("agent_email"));
						item.setAgent_website(rs.getString("agent_website"));
						item.setAgent_map(rs.getString("agent_map"));
						item.setAgent_notes(rs.getString("agent_notes"));
						item.setAgent_created_date(rs.getString("agent_created_date"));
						item.setAgent_last_modified(rs.getString("agent_last_modified"));
						
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return item;
		}

		public ArrayList<AgentObject> getAgentObjects(AgentObject similar, short page, byte total) {

			ArrayList<AgentObject> items = new ArrayList<AgentObject>();

			AgentObject item = null;

			// Lấy dữ liệu
			int at = (page - 1) * total;
			ResultSet rs = this.agent.getAgents(similar, at, total);
			if (rs != null) {
				try {
					while (rs.next()) {
						item = new AgentObject();
						item.setAgent_id(rs.getShort("agent_id"));
						item.setAgent_name(rs.getString("agent_name"));
						item.setAgent_address(rs.getString("agent_address"));
						item.setAgent_phone(rs.getString("agent_phone"));
						item.setAgent_email(rs.getString("agent_email"));
						item.setAgent_website(rs.getString("agent_website"));
						item.setAgent_map(rs.getString("agent_map"));
						item.setAgent_notes(rs.getString("agent_notes"));
						item.setAgent_created_date(rs.getString("agent_created_date"));
						item.setAgent_last_modified(rs.getString("agent_last_modified"));

//						sql += "agent_manager_id=? ";
//						sql += "agent_manager_name=? ";
//						sql += "agent_enable=? ";
//						sql += "agent_delete=? ";
//						sql += "agent_boss=? ";
//						sql += "agent_boss_mobile=? ";
//						sql += "agent_pass=? ";
//						sql += "agent_image=? ";
//						sql += "agent_area_id=? ";
//						sql += "agent_tax_code=? ";
//						sql += "agent_city_id=? ";
						
						items.add(item);
					}

					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return items;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
