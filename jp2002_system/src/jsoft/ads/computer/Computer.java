package jsoft.ads.computer;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Computer extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addComputer(ComputerObject item);
	public boolean editComputer(ComputerObject item);
	public boolean delComputer(ComputerObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getComputer(int id);
	public ResultSet getComputers(ComputerObject similar, int at, byte total);

}
