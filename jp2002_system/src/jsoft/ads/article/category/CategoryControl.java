package jsoft.ads.article.category;

import jsoft.*;
import jsoft.objects.*;
import java.util.*;

public class CategoryControl {

	private CategoryModel cm;

	public CategoryControl(ConnectionPool cp, String objectName) {
		this.cm = new CategoryModel(cp, objectName);
	}

	protected void finalize() throws Throwable {
		this.cm = null;
		super.finalize();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	// ------------------------------------------------
	public boolean addCategory(CategoryObject item) {
		return this.cm.addCategory(item);
	}

	public boolean editCategory(CategoryObject item) {
		return this.cm.editCategory(item);
	}

	public boolean delCategory(CategoryObject item) {
		return this.cm.delCategory(item);
	}

	// ------------------------------------------------
	public CategoryObject getCategoryObject(short id) {
		return this.cm.getCategoryObject(id);
	}

	public String viewCategories(CategoryObject similar, short page, byte total) {

		ArrayList<CategoryObject> items = this.cm.getCategoryObjects(similar, page, total);

		return CategoryLibrary.viewCategories(items);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
