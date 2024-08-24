package jsoft.ads.product.pg;

import jsoft.objects.*;
import java.sql.*;
import jsoft.ads.product.ps.*;

public interface ProductGroup extends ProductSystem {

	// Cac chuc nang cap nhat
	public boolean addProductGroup(ProductGroupObject item);
	public boolean editProductGroup(ProductGroupObject item);
	public boolean delProductGroup(ProductGroupObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getProductGroup(int id);
	public ResultSet getProductGroups(ProductGroupObject similar, int at, byte total);
	
	public ResultSet getProductSystems(ProductSystemObject similar);
}
