package jsoft.ads.agent;

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
@WebServlet("/agent/view")
public class AgentView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgentView() {
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
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}

	protected void view(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Xacs định lấy ký tự unicode
		request.setCharacterEncoding("UTF-8");

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		// Tạo đối tượng thực thi chức năng mức control
		AgentControl ac = new AgentControl(cp);
		// Nếu cp lúc đầu chưa tồn tại thì hỏi xin ngược trở lại ngữ cảnh
		if(cp==null) {
			getServletContext().setAttribute("CPool", ac.getCP());
		}
		// Tìm từ khóa nếu có
		String key = request.getParameter("txtKeyword");
		String saveKey = (key!=null) ? Utilities_Support.encode(key.trim()) : "";
		
		//Tạo đối tượng bộ lọc
		AgentObject similar = new AgentObject();
		//Truyền thông tin tài khoản đăng nhập
		//id
		//similar.setUser_id(user.getUser_id());
		//truyền quyền thực thi của tài khoản đăng nhập
		//similar.setUser_permission(user.getUser_permission());
		//Truyền từ khóa tìm kiếm vào tên đăng nhập
		similar.setAgent_name(saveKey);
		
		// Lấy cấu trúc trình bày
		String view = ac.viewAgents(similar, (short) 1, (byte) 30);
		
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
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/agent/view\">Đại lý</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/agent/view\">Danh sách</a></li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("<div class=\"col-md-4\">");
		out.print("<div class=\"view-search\">");
		out.print("<form class=\"form-inline\" name=\"frmSearch\" action=\"/adv/agent/view\" method=\"POST\">");
		out.print("<div class=\"form-group\">");
		out.print("<label for=\"inputKeyword\">Tìm kiếm</label>&nbsp;");
		out.print("<input type=\"text\" id=\"inputKeyword\" name=\"txtKeyword\" value=\""+saveKey+"\"class=\"form-control mx-sm-3\" aria-describedby=\"keywordHelpInline\" placeholder=\"Từ khóa\">");
		out.print("</div>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");

		out.print("<div class=\"view-content\">" + view + "</div>");

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
