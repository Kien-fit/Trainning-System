package jsoft.ads.product.pc;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ProductCategoryControl {

	private ProductCategoryModel pc;

	public ProductCategoryControl(ConnectionPool cp, String objectname) {
		this.pc = new ProductCategoryModel(cp, objectname);
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
		public ProductCategoryObject getPcObject(int id) {
			return this.pc.getProductCategoryObject(id);
		}

		public String viewProductCategory(ProductCategoryObject similar, short page, byte total) {

			ArrayList<ProductCategoryObject> items = this.pc.getProductCategoryObjects(similar, page, total);
			
			return ProductCategoryLibrary.viewProductCategory(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
