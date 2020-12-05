package jsoft.ads.interior;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Interior extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addInterior(InteriorObject item);
	public boolean editInterior(InteriorObject item);
	public boolean delInterior(InteriorObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getInterior(int id);
	public ResultSet getInteriors(InteriorObject similar, int at, byte total);

}
