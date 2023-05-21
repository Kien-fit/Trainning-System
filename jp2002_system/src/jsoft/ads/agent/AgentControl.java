package jsoft.ads.agent;

import jsoft.*;
import jsoft.objects.*;
//import java.sql.*;
import java.util.*;

public class AgentControl {

	private AgentModel am;

	public AgentControl(ConnectionPool cp) {
		this.am = new AgentModel(cp);
	}

	protected void finalize() throws Throwable {
		this.am = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.am.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.am.getCP();
	}

	// ------------------------------------------------
		public boolean addAgent(AgentObject item) {
			return this.am.addAgent(item);
		}

		public boolean editAgent(AgentObject item) {
			return this.am.editAgent(item);
		}

		public boolean delAgent(AgentObject item) {
			return this.am.delAgent(item);
		}

		// ------------------------------------------------
		public AgentObject getAgentObject(short id) {
			return this.am.getAgentObject(id);
		}

		public String viewAgents(AgentObject similar, short page, byte total) {

			ArrayList<AgentObject> items = this.am.getAgentObjects(similar, page, total);

			return AgentLibrary.viewAgents(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
