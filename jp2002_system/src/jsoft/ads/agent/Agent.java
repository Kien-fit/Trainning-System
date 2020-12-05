package jsoft.ads.agent;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Agent extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addAgent(AgentObject item);
	public boolean editAgent(AgentObject item);
	public boolean delAgent(AgentObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getAgent(int id);
	public ResultSet getAgents(AgentObject similar, int at, byte total);

}
