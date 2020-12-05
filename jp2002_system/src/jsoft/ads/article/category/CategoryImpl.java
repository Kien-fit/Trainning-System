package jsoft.ads.article.category;

import java.sql.*;

import jsoft.objects.*;
import jsoft.*;
import jsoft.ads.article.section.SectionImpl;

public class CategoryImpl extends SectionImpl implements Category {

	public CategoryImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
	}

	@Override
	public boolean addCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		

		String sql = "INSERT INTO tblcategory (";
		sql += "category_name, ";
		sql += "category_section_id, ";
		sql += "category_notes, ";
		sql += "category_created_date, ";
		sql += "category_manager_id, ";
		sql += "category_enable, ";
		sql += "category_delete, ";
		sql += "category_last_modified, ";
		sql += "category_created_author_id, ";
		sql += "category_image, ";
		sql += "category_name_en, ";
		sql += "category_language ";
		sql += ") ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			//Truyền giá trị cho các tham số
			pre.setString(1, item.getCategory_name());
			pre.setInt(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
			pre.setString(4, item.getCategory_created_date());
			pre.setInt(5, item.getCategory_manager_id());
			pre.setBoolean(6, item.isCategory_enable());
			pre.setBoolean(7, item.isCategory_delete());
			pre.setString(8, item.getCategory_last_modified());
			pre.setInt(9, item.getCategory_created_author_id());
			pre.setString(10, item.getCategory_image());
			pre.setString(11, item.getCategory_name_en());
			pre.setByte(12, item.getCategory_language());
			
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
	public boolean editCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE tblcategory SET ";
		sql += "category_name=?, ";
		sql += "category_section_id=?, ";
		sql += "category_notes=?, ";
//		sql += "category_created_date=?, ";
		sql += "category_manager_id=?, ";
		sql += "category_enable=?, ";
		sql += "category_delete=?, ";
		sql += "category_last_modified=?, ";
//		sql += "category_created_author_id=?, ";
		sql += "category_image=?, ";
		sql += "category_name_en=?, ";
		sql += "category_language=? ";
		sql += "";
		sql += "WHERE category_id=?";
		
		//Thực hiện biên dịch
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			//Truyền giá trị cho các tham số
			pre.setString(1, item.getCategory_name());
			pre.setInt(2, item.getCategory_section_id());
			pre.setString(3, item.getCategory_notes());
//			pre.setString(4, item.getCategory_created_date());
			pre.setInt(4, item.getCategory_manager_id());
			pre.setBoolean(5, item.isCategory_enable());
			pre.setBoolean(6, item.isCategory_delete());
			pre.setString(7, item.getCategory_last_modified());
//			pre.setInt(9, item.getCategory_created_author_id());
			pre.setString(8, item.getCategory_image());
			pre.setString(9, item.getCategory_name_en());
			pre.setByte(10, item.getCategory_language());
			
			pre.setInt(11, item.getCategory_id());
			
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
	public boolean delCategory(CategoryObject item) {
		// TODO Auto-generated method stub
		
		if(!this.isEmpty(item)) {
			return false;
		}
		
		String sql = "DELETE FROM tblcategory WHERE category_id=?";
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getCategory_id());
			
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
	
	private boolean isEmpty(CategoryObject item) {
		boolean flag = true;
		
		String sql = "SELECT article_id FROM tblarticle ";
		sql += "WHERE (article_category_id="+item.getCategory_id()+")";
		
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
	public ResultSet getCategory(short id) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblcategory ";
		sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
		sql += "WHERE category_id=?";

		return this.get(sql, id);
	}

	@Override
	public ResultSet getCategories(CategoryObject similar, int at, byte total) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblcategory ";
		sql += "LEFT JOIN tblsection ON category_section_id=section_id ";
		sql += "";
		sql += "ORDER BY category_name ASC ";
		sql += "LIMIT " + at + ", " + total;
		
		return this.gets(sql);
	}

	public static void main(String[] args) {
		// Tạo đối tượng quản lý kết nối
		ConnectionPool cp = new ConnectionPoolImpl();

		// Tạo đối tượng thực thi chức năng vào CSDL mức giao tiếp (interface)
		Category cat = new CategoryImpl(cp, "Category");

		// Lấy tập kết quả
		ResultSet rs = cat.getCategories(null, 0, (byte) 10);
		
		//Trả lại kết nối
		cat.releaseConnection();

		// Duyệt và hiển thị kết quả
		String row;
		if (rs != null) {
			try {
				while(rs.next()) {
					row = "ID: " + rs.getInt("category_id");
					row += "\t\tNAME: " + rs.getString("category_name");
					row += "\t\tNOTES: " + rs.getString("category_notes");
					
					System.out.println(row);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
