package jsoft.ads.log;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Log extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addLog(LogObject item);
	public boolean editLog(LogObject item);
	public boolean delLog(LogObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getLog(int id);
	public ResultSet getLogs(LogObject similar, int at, byte total);

}
