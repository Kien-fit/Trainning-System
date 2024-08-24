package jsoft.ads.product.pc;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class ProductCategoryControl {

	private ProductCategoryModel pc;

	public ProductCategoryControl(ConnectionPool cp) {
		this.pc = new ProductCategoryModel(cp);
	}

	protected void finalize() throws Throwable {
		this.pc = null;
		super.finalize();
	}
	
	public void  releaseConnection() {
		this.pc.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.pc.getCP();
	}
	
	// ------------------------------------------------
	public boolean addProductCategory(ProductCategoryObject item) {
		return this.pc.addProductCategory(item);
	}

	public boolean editProductCategory(ProductCategoryObject item) {
		return this.pc.editProductCategory(item);
	}

	public boolean delProductCategory(ProductCategoryObject item) {
		return this.pc.delProductCategory(item);
	}

	// ------------------------------------------------
	public ProductCategoryObject getProductCategoryObject(int id) {
		return this.pc.getProductCategoryObject(id);
	}

	public String viewProductCategory(ProductCategoryObject similar, short page, byte total) {

		ArrayList<ProductCategoryObject> items = this.pc.getProductCategoryObjects(similar, page, total);
		
		return ProductCategoryLibrary.viewProductCategory(items);
	}
	
	public String viewProductGroupOptions(ProductGroupObject similar, int id) {
		
		ArrayList<ProductGroupObject> items = this.pc.getProductGroupObjects(similar);
		
		return ProductCategoryLibrary.viewProductGroupOptions(items, id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
