package jsoft.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsoft.objects.UserObject;

/**
 * Servlet implementation class Header
 */
@WebServlet("/header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Header() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tham chiếu phiên làm việc để tìm thông tin đăng nhập
		HttpSession session = request.getSession();

		// Tim thông tin đăng nhập trong phiên làm việc
		UserObject user = (UserObject) session.getAttribute("userLogined");

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();

		out.print("<!doctype html>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		out.print("<title>Quản trị hệ thống</title>");
		out.print("<link href=\"/adv/adcss/all.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<link href=\"/adv/adcss/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<link href=\"/adv/adcss/bootstrap-grid.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<link href=\"/adv/adcss/layout.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<link href=\"/adv/adcss/user.css\" rel=\"stylesheet\" type=\"text/css\" />");

		out.print("<script language=\"javascript\" src=\"/adv/ckeditor/ckeditor.js\"></script>");	
//		out.print("<script language=\"javascript\" src=\"/adv/adjs/layout.js\"></script>");
		out.print("<script language=\"javascript\" src=\"/adv/adjs/user.js\"></script>");
		out.print("</head>");

		out.print("<body>");
		out.print("<div class=\"container-fluid\">");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-6\">");
		out.print("<div class=\"logo\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"col-md-6\">");
		out.print("<div class=\"account\">");
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-2\">");
		out.print("<i class=\"fas fa-user\"></i>");
		out.print("</div>");
		out.print("<div class=\"col-md-8 text-left\">");
		out.print("<h6>Quyền quản trị</h6>");
		out.print("Tên dăng nhập: <a href=\"#\">"+user.getUser_name()+"("+user.getUser_fullname()+")</a><br />");
		out.print("<a href=\"#\">Đổi mật khẩu</a>");
		out.print("&nbsp;|&nbsp;");
		out.print("<a href=\"/adv/user/logout\">Thoát</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		// Tìm menu và include
		RequestDispatcher m = request.getRequestDispatcher("/menu");
		if (m != null) {
			m.include(request, response);
		}
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
