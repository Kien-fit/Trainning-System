package jsoft.ads.product.pc;

import jsoft.objects.*;
import java.sql.*;
import jsoft.ads.product.pg.*;

public interface ProductCategory extends ProductGroup {

	// Cac chuc nang cap nhat
	public boolean addProductCategory(ProductCategoryObject item);
	public boolean editProductCategory(ProductCategoryObject item);
	public boolean delProductCategory(ProductCategoryObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getProductCategory(int id);
	public ResultSet getProductCategories(ProductCategoryObject similar, int at, byte total);
	
	public ResultSet getProductGroups(ProductGroupObject similar);
}
