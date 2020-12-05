package jsoft.ads.product.ps;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class ProductSystemControl {

	private ProductSystemModel pm;

	public ProductSystemControl(ConnectionPool cp, String objectname) {
		this.pm = new ProductSystemModel(cp, objectname);
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
	
	// ------------------------------------------------
		public boolean addProductSystem(ProductSystemObject item) {
			return this.pm.addProductSystem(item);
		}

		public boolean editProductSystem(ProductSystemObject item) {
			return this.pm.editProductSystem(item);
		}

		public boolean delProductSystem(ProductSystemObject item) {
			return this.pm.delProductSystem(item);
		}

		// ------------------------------------------------
		public ProductSystemObject getProductSystemObject(int id) {
			return this.getProductSystemObject(id);
		}

		public String viewProductSystem(ProductSystemObject similar, short page, byte total) {

			ArrayList<ProductSystemObject> items = this.pm.getProductSystemObjects(similar, page, total);
			
			return ProductSystemLibrary.viewProductSystem(items);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
