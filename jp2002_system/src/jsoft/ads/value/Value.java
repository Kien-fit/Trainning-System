package jsoft.ads.value;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Value extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addValue(ValueObject item);
	public boolean editValue(ValueObject item);
	public boolean delValue(ValueObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getValue(int id);
	public ResultSet getValues(ValueObject similar, int at, byte total);

}
