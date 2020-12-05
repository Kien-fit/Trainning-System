package jsoft.ads.article.category;

import jsoft.objects.*;
import java.sql.*;

import jsoft.ads.article.section.*;;

public interface Category extends Section {
	// Cac chuc nang cap nhat
	public boolean addCategory(CategoryObject item);
	public boolean editCategory(CategoryObject item);
	public boolean delCategory(CategoryObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getCategory(short id);
	public ResultSet getCategories(CategoryObject similar, int at, byte total);

}
