package jsoft.ads.ae;

import jsoft.objects.*;
import java.sql.*;

import jsoft.*;

public interface ArticleExtends extends ShareControl {

	// Cac chuc nang cap nhat
	public boolean addArticleExtends(ArticleExtendsObject item);
	public boolean editArticleExtends(ArticleExtendsObject item);
	public boolean delArticleExtends(ArticleExtendsObject item);

	// Cac chuc nang lay du lieu
	public ResultSet getArticleExtends(int id);
	public ResultSet getArticleExtends(ArticleExtendsObject similar, int at, byte total);

}
