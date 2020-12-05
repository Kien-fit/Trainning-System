package jsoft.ads.product.pg;

import jsoft.*;
import jsoft.objects.*;
import java.sql.*;
import java.util.*;

public class ProductGroupControl {

	private ProductGroupModel pg;

	public ProductGroupControl(ConnectionPool cp, String objectname) {
		this.pg = new ProductGroupModel(cp, objectname);
	}

	protected void finalize() throws Throwable {
		this.pg = null;
		super.finalize();
	}

	public void  releaseConnection() {
		this.pg.releaseConnection();
	}
	
	public ConnectionPool getCP() {
		return this.pg.getCP();
	}
	
	// ------------------------------------------------
		public boolean addProductGroup(ProductGroupObject item) {
			return this.pg.addProductGroup(item);
		}

		public boolean editProductGroup(ProductGroupObject item) {
			return this.pg.editProductGroup(item);
		}

		public boolean delProductGroup(ProductGroupObject item) {
			return this.pg.delProductGroup(item);
		}

		// ------------------------------------------------
		public ProductGroupObject getProductGroupObject(int id) {
			return this.pg.getProductGroupObject(id);
		}

		public String viewProductGroup(ProductGroupObject similar, short page, byte total) {

			ArrayList<ProductGroupObject> items = this.pg.getProductGroupObjects(similar, page, total);

			return ProductGroupLibrary.viewProductGroup(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
