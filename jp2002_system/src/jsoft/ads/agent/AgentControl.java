package jsoft.ads.agent;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class AgentControl {

	private AgentModel agent;

	public AgentControl(ConnectionPool cp, String objectname) {
		this.agent = new AgentModel(cp, objectname);
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
			return this.agent.getAgentObject(id);
		}

		public String viewAgents(AgentObject similar, short page, byte total) {

			ArrayList<AgentObject> items = this.agent.getAgentObjects(similar, page, total);

			return AgentLibrary.viewAgents(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
