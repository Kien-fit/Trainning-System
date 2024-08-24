package jsoft.ads.article.section;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Section extends ShareControl {
	// Cac chuc nang cap nhat
	public boolean addSection(SectionObject item);
	public boolean editSection(SectionObject item);
	public boolean delSection(SectionObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getSection(short id);
	public ResultSet getSections(SectionObject similar, int at, byte total);
	
	public ResultSet getUsers(UserObject similar);
}
