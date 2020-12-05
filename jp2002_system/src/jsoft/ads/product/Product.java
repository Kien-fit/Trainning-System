package jsoft.ads.product;

import jsoft.objects.*;

import java.sql.*;

import jsoft.ads.product.ps.*;


public interface Product extends ProductSystem {
	// Cac chuc nang cap nhat
	public boolean addProduct(ProductObject item);
	public boolean editProduct(ProductObject item);
	public boolean delProduct(ProductObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getProduct(short id);
	public ResultSet getProducts(ProductObject similar, int at, byte total);

}
