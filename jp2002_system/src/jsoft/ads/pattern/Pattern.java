package jsoft.ads.pattern;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Pattern extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addPattern(PatternObject item);
	public boolean editPattern(PatternObject item);
	public boolean delPattern(PatternObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getPattern(int id);
	public ResultSet getPatterns(PatternObject similar, int at, byte total);

}
