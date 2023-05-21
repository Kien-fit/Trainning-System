package jsoft.ads.product;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class ProductControl {

	private ProductModel pm;

	public ProductControl(ConnectionPool cp) {
		this.pm = new ProductModel(cp);
	}

	protected void finalize() throws Throwable {
		this.pm = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.pm.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.pm.getCP();
	}
	

	// **************************************************
	public boolean addProduct(ProductObject item) {
		return this.pm.addProduct(item);
	}

	public boolean editProduct(ProductObject item) {
		return this.pm.editProduct(item);
	}

	public boolean delProduct(ProductObject item) {
		return this.pm.delProduct(item);
	}

	// **************************************************
	public ProductObject getProductObject(short id) {
		return this.pm.getProductObject(id);
	}

	public String viewProducts(ProductObject similar, short page, byte total) {

		ArrayList<ProductObject> items = this.pm.getProductObjects(similar, page, total);

		return ProductLibrary.viewProducts(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Tạo bộ quản lý kết nối
		//ConnectionPool cp = new ConnectionPoolImpl();


	}

}
