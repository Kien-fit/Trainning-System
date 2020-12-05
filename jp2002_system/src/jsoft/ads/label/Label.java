package jsoft.ads.label;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Label extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addLabel(LabelObject item);
	public boolean editLabel(LabelObject item);
	public boolean delLabel(LabelObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getLabel(int id);
	public ResultSet getLabels(LabelObject similar, int at, byte total);

}
