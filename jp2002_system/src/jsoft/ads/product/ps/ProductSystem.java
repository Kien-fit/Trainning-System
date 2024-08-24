package jsoft.ads.product.ps;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface ProductSystem extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addProductSystem(ProductSystemObject item);
	public boolean editProductSystem(ProductSystemObject item);
	public boolean delProductSystem(ProductSystemObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getProductSystem(int id);
	public ResultSet getProductSystems(ProductSystemObject similar, int at, byte total);
	ResultSet getUsers(UserObject similar);

}
