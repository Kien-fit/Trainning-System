package jsoft.ads.product;

import jsoft.objects.*;

import java.sql.*;

import jsoft.ads.product.pc.*;


public interface Product extends ProductCategory {
	// Cac chuc nang cap nhat
	public boolean addProduct(ProductObject item);
	public boolean editProduct(ProductObject item);
	public boolean delProduct(ProductObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getProduct(int id);
	public ResultSet getProducts(ProductObject similar, int at, byte total);

	public ResultSet getProductCategories(ProductCategoryObject similar);

}
