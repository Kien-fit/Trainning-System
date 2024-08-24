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
import jsoft.library.Utilities_Support;


/**
 * Servlet implementation class View
 */
@WebServlet("/article/view")
public class ArticleView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleView() {
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

		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
		
		// Tạo đối tượng thực thi chức năng
		ArticleControl ac = new ArticleControl(cp);

		// Tìm từ khóa nếu có
		String key = request.getParameter("txtKeyword");
		String saveKey = (key!=null) ? Utilities_Support.encode(key.trim()) : "";
		
		//Tạo đối tượng bộ lọc
		ArticleObject similar = new ArticleObject();
		//Truyền từ khóa tìm kiếm vào tên đăng nhập
		similar.setArticle_title(saveKey);
		
		// Lấy cấu trúc trình bày
		String view = ac.viewArticles(null, (short)1, (byte)10);
		
		// Trả lại kết nối
		ac.releaseConnection();
		
		
		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();

		// Tìm header và include
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"col-md-10\">");
		out.print("<div class=\"row mt-flex view-header\">");
		out.print("<div class=\"col-md-8\">");
		out.print("<nav aria-label=\"breadcrumb\">");
		out.print("<ol class=\"breadcrumb\">");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/view\">Dashboard</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/article/view\">Bài viết</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">Danh sách</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print("<div class=\"view-search\">");
		out.print("<form class=\"form-inline\" name=\"frmSearch\" action=\"/adv/article/view\" method=\"POST\">");
		out.print("<div class=\"form-group\">");
		out.print("<label for=\"inputKeyword\">Tìm kiếm</label>&nbsp;");
		out.print("<input type=\"text\" id=\"inputKeyword\" name=\"txtKeyword\" value=\""+ saveKey +"\" class=\"form-control mx-sm-3\" aria-describedby=\"keywordHelpInline\" placeholder=\"Từ khóa\">");
		out.print("</div>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");
		
		out.print("<div class=\"view-content\">"+view+"</div>");
		
		out.print("<div class=\"view-pagination\">");
		out.print("<nav aria-label=\"...\">");
		out.print("<ul class=\"pagination justify-content-center\">");
		out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"#\"><<</a></li>");
		out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"#\"><</a></li>");
		out.print("<li class=\"page-item active\" aria-current=\"page\">");
		out.print("<span class=\"page-link\">1");
		out.print("<span class=\"sr-only\">(current)</span>");
		out.print("</span>");
		out.print("</li>");
		out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">2</a></li>");
		out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">></a></a></li>");
		out.print("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">>></a></a></a></li>");
		out.print("</ul>");
		out.print("</nav>");
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
		doGet(request, response);
	}

}
