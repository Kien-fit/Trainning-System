package jsoft.ads.customer;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface Customer extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addCustomer(CustomerObject item);
	public boolean editCustomer(CustomerObject item);
	public boolean delCustomer(CustomerObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getCustomer(int id);
	public ResultSet getCustomers(CustomerObject similar, int at, byte total);

}
