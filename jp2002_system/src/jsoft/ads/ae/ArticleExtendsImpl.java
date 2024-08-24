package jsoft.ads.ae;

import java.sql.*;
import jsoft.objects.*;

import jsoft.*;
import jsoft.ads.article.ArticleImpl;

public class ArticleExtendsImpl extends ArticleImpl implements ArticleExtends {
	
	public ArticleExtendsImpl(ConnectionPool cp) {
		super(cp, "ArticleExtends");
	}

	@Override
	public boolean addArticleExtends(ArticleExtendsObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tblarticle_extends (";	
		sql += "ae_text200_1, ";
		sql += "ae_text200_2, ";
		sql += "ae_text200_3, "; 
		sql += "ae_text200_4, ";
		sql += "ae_text200_5, ";
		sql += "ae_byte_1, ";
		sql += "ae_byte_2, ";
		sql += "ae_byte_3, ";
		sql += "ae_byte_4, ";
		sql += "ae_byte_5, ";
		sql += "ae_short_1, ";
		sql += "ae_short_2, ";
		sql += "ae_int_1, ";
		sql += "ae_int_2, ";
		sql += "ae_text_1, ";
		sql += "ae_text_2, ";
		sql += "ae_longtext, ";
		sql += "ae_article_id ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getAe_text200_1());
			pre.setString(2, item.getAe_text200_2());
			pre.setString(3, item.getAe_text200_3());
			pre.setString(4, item.getAe_text200_4());
			pre.setString(5, item.getAe_text200_5());
			pre.setByte(6, item.getAe_byte_1());
			pre.setByte(7, item.getAe_byte_2());
			pre.setByte(8, item.getAe_byte_3());
			pre.setByte(9, item.getAe_byte_4());
			pre.setByte(10, item.getAe_byte_5());
			pre.setShort(11, item.getAe_short_1());
			pre.setShort(12, item.getAe_short_2());
			pre.setInt(13, item.getAe_int_1());
			pre.setInt(14, item.getAe_int_2());
			pre.setString(15, item.getAe_text_1());
			pre.setString(16, item.getAe_text_2());
			pre.setString(17, item.getAe_longtext());
			pre.setInt(18, item.getAe_article_id());
			
			return this.add(pre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return false;
	}

	@Override
	public boolean editArticleExtends(ArticleExtendsObject item) {
		// TODO Auto-generated method stub

		String sql = "UPDATE tblarticle_extends SET ";	
		sql += "ae_text200_1=?, ";
		sql += "ae_text200_2=?, ";
		sql += "ae_text200_3=?, ";
		sql += "ae_text200_4=?, ";
		sql += "ae_text200_5=?, ";
		sql += "ae_byte_1=?, ";
		sql += "ae_byte_2=?, ";
		sql += "ae_byte_3=?, ";
		sql += "ae_byte_4=?, ";
		sql += "ae_byte_5=?, ";
		sql += "ae_short_1=?, ";
		sql += "ae_short_2=?, ";
		sql += "ae_int_1=?, ";
		sql += "ae_int_2=?, ";
		sql += "ae_text_1=?, ";
		sql += "ae_text_2=?, ";
		sql += "ae_longtext=?, ";
		sql += "ae_article_id=? ";
		
		sql += "WHERE ae_id=?)";

		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, item.getAe_text200_1());
			pre.setString(2, item.getAe_text200_2());
			pre.setString(3, item.getAe_text200_3());
			pre.setString(4, item.getAe_text200_4());
			pre.setString(5, item.getAe_text200_5());
			pre.setByte(6, item.getAe_byte_1());
			pre.setByte(7, item.getAe_byte_2());
			pre.setByte(8, item.getAe_byte_3());
			pre.setByte(9, item.getAe_byte_4());
			pre.setByte(10, item.getAe_byte_5());
			pre.setShort(11, item.getAe_short_1());
			pre.setShort(12, item.getAe_short_2());
			pre.setInt(13, item.getAe_int_1());
			pre.setInt(14, item.getAe_int_2());
			pre.setString(15, item.getAe_text_1());
			pre.setString(16, item.getAe_text_2());
			pre.setString(17, item.getAe_longtext());
			pre.setInt(18, item.getAe_article_id());
			
			pre.setInt(19, item.getAe_id());
			
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean delArticleExtends(ArticleExtendsObject item) {
		// TODO Auto-generated method stub

		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblarticle_extends WHERE ae_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getAe_id());
			
			return this.del(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		return false;
	}
	
	private boolean isEmpty(ArticleExtendsObject item) {
		boolean flag = true;
		
		String sql = "SELECT customer_id FROM tblcustomer ";
		sql += "WHERE (customer_articleextends_id="+item.getAe_id()+")";
		
		ResultSet rs = this.gets(sql);
		if(rs!=null) {
			try {
				if(rs.next()) {
					flag = false;
				}
				
				rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}


	@Override
	public ResultSet getArticleExtends(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblae WHERE ae_id=?";

		return this.get(sql, id);	}

	@Override
	public ResultSet getArticleExtends(ArticleExtendsObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM tblae ";
		sql += "";
		sql += "ORDER BY ae_id ASC ";
		sql += "LIMIT " + at + ", " + total;

		return this.gets(sql);	}

}
