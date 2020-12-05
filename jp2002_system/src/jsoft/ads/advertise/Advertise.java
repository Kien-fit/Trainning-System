package jsoft.ads.advertise;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Advertise extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addAdvertise(AdvertiseObject item);
	public boolean editAdvertise(AdvertiseObject item);
	public boolean delAdvertise(AdvertiseObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getAdvertise(short id);
	public ResultSet getAdvertises(AdvertiseObject similar, int at, byte total);

}
