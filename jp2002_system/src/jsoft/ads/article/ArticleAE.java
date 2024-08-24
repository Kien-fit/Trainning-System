package jsoft.ads.article;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsoft.objects.*;
import jsoft.*;
import jsoft.library.DateTime;
import jsoft.library.Utilities;
import jsoft.library.*;

/**
 * Servlet implementation class View
 */
@WebServlet("/article/ae")
public class ArticleAE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleAE() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Tham chiếu phiên làm việc để tìm thông tin đăng nhập
		HttpSession session = request.getSession();

		// Tim thông tin đăng nhập trong phiên làm việc
		UserObject user = (UserObject) session.getAttribute("userLogined");

		// Kiểm tra
		if (user != null) {
			view(request, response);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}

	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();
		
		//Tìm id để sủa nếu có
		short id = Utilities.getShortParam(request, "id");
		String name="", content="", nameEng="";
		int categoryId=0;
		
		String categoryOptions = null;
		
		String title = "<i class=\"fas fa-plus-circle\"></i>";
		String lblCre = "Create";	
		
		boolean isEdit = false;
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		
		// Tạo đối tượng thực thi chức năng
		ArticleControl ac = new ArticleControl(cp);
		if(cp==null) {
			getServletContext().setAttribute("CPool", ac.getCP());
		}
		
		// Lay danh sach the loai
		categoryOptions = ac.viewCategoryOptions(null);
		
		if(id>0) {
			
			// Xác định đối tượng sửa
			ArticleObject editArticle = ac.getArticleObject(id);
			
			//kiểm tra
			if(editArticle!=null) {
				// Lấy thông tin để sửa
				name = editArticle.getArticle_title();
				content = editArticle.getArticle_content();
				nameEng = editArticle.getArticle_title_en();
				categoryId = editArticle.getArticle_category_id();
				
				title = "Cập nhật chuyên mục";
				lblCre = "Update";
				
				isEdit = true;
			}
		}
		
		// Trả lại kết nối
		ac.releaseConnection();
		

		// Tìm header và include
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"col-md-10\">");
		out.print("<div class=\"row mt-flex view-header\">");
		out.print("<div class=\"col-md-12\">");
		out.print("<nav aria-label=\"breadcrumb\">");
		out.print("<ol class=\"breadcrumb\">");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/view\">Dashboard</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/article/view\">Bài viết</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">"+title+"</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");

		out.print("<div class=\"view-content\">");
		out.print("<form name=\"frmArticle\" class=\"frmArticle\" action=\"\" method=\"\">");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"mytitle\"><i class=\"fas fa-people-carry\"></i> Article information</div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputTitle\" class=\"col-md-2 col-form-label text-right\">Article title</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"name\" class=\"form-control\" id=\"inputTitle\" name=\"txtTitle\" onkeyup=\"checkName(this.form)\" value=\""+name+"\" >");
		out.print("<div id=\"viewValidName\"></div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputTitleEng\" class=\"col-md-2 col-form-label text-right\">Titel(English)</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputTitleEng\" name=\"inputTitleEng\" value=\""+nameEng+"\" >");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">Category</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<select name=\"slcCategory\" class=\"form-control\">");
		out.print("<option value=0>...</option>");
		out.print(categoryOptions);
		out.print("</select>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row align-items-center\">");
		out.print("<label for=\"inputContent\" class=\"col-md-2 col-form-label text-right\" text=\"right\">Content</label>");
		out.print("<div class=\"col-md-10\">");
		out.print("<textarea class=\"form-control-file\" id=\"inputContent\" name=\"txtContent\" rows=8>"+content+"</textarea>");
		out.print("</div>");
		out.print("</div>");
		out.print("<script language=\"javascript\" type=\"text/javascript\">");
		out.print("var editor = CKEDITOR.replace('inputContent');");
		out.print("</script>");

/*		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"input\" class=\"col-md-2 col-form-label text-right\"></label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"name\" class=\"form-control\" id=\"input\" name=\"txt\">");
		out.print("</div>");
		out.print("</div>");
*/		
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnLogin\" onClick=\"saveArticle(this.form)\"><i class=\"fas fa-sign-in-alt\"></i>"+lblCre+"</button>&nbsp;");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnExit\" onClick=\"window.close()\"><i class=\"fas fa-sign-out-alt\"></i>Exit</button>");
		out.print("</div>");
		out.print("</div>");
		out.print("				");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-right\">");
		out.print("<a href=\"#\">Tiếng Việt?</a>");
		out.print("</div>");
		out.print("</div>");
		
		if(isEdit) {
			//truyền giá trị của id cho doPost theo cơ chế form ẩn
			out.print("<input type=\"hidden\" id=\"idForPost\" value=\""+id+"\" />");		
		}
		
		out.print("</form>");
		out.print("</div>");

		out.print("</div>");
		out.print("</div>");

		out.print("</div>");
		out.print("</div>");

		// Tìm footer và include
		RequestDispatcher f = request.getRequestDispatcher("/footer");
		if (f != null) {
			f.include(request, response);
		}

		// Đóng đối tượng xuất
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Xác định tập ký tự cần lấy
		request.setCharacterEncoding("UTF-8");
		
		//Lấy id để sửa nếu có
		short id = Utilities.getShortParam(request, "idForPost");
		
		//Lấy thông tin trên giao diện
		String name = request.getParameter("txtTitle");
		String content = request.getParameter("txtContent");
		String nameEng = request.getParameter("txtTitleEng");
		String categoryId = request.getParameter("slcCategory");
		
		// Kiểm tra
		if(name!=null && content!=null && nameEng!=null) {
			name = name.trim();
			content = content.trim();
			nameEng = nameEng.trim();
			if(name.equalsIgnoreCase("") && content.equalsIgnoreCase("") && nameEng.equalsIgnoreCase("")) {
				
				//Tạo đối tượng lưu thông tin
				ArticleObject newArticle = new ArticleObject();
				newArticle.setArticle_title(Utilities_Support.encode(name));
				newArticle.setArticle_content(Utilities_Support.encode(content));
				newArticle.setArticle_title_en(Utilities_Support.encode(nameEng));
				//newArticle.setArticle_category_id(categoryId);
				
				//Ngày tạo/sửa chuyên mục
				String date = DateTime.getFullDate("dd/MM/yyyy");
				
				//Tìm thông tin đăng nhập
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined") ;
				newArticle.setArticle_author_name(user.getUser_name());
				
				//Tim bộ quản lý kêt nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
				
				//Tạo đói tượng thực thi
				ArticleControl ac = new ArticleControl(cp);
				if(cp==null) {
					getServletContext().setAttribute("CPool", ac.getCP());
				}
				
				boolean result;
				if(id>0) {
					//act cập nhật
					newArticle.setArticle_id(id);
					newArticle.setArticle_last_modified(date);
					result = ac.editArticle(newArticle);
				} else {
					//act Thêm
					newArticle.setArticle_last_modified(date);
					result = ac.addArticle(newArticle);
				}
				
				//Trả về kết nối
				ac.releaseConnection();
				
				//Kiểm tra kết quả
				if(result) {
					response.sendRedirect("/adv/article/view");
				} else {
					response.sendRedirect("/adv/article/ae?err=notok");
				}	
			} else {
				response.sendRedirect("/adv/article/ae?err=value");
			}
		} else {
			response.sendRedirect("/adv/article/ae?err=param");
		}
		
	}

}
