package jsoft.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Menu() {
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

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();

		// Xac dinh vi tri cua menu
		String uri = request.getRequestURI();
		String pos = uri.substring(5);// loai bo '/adv/'
		// Xac dinh vi tri '/'
		int at = pos.indexOf("/");
		String menu = "";
		if (at != -1) {
			menu = pos.substring(0, at);
		}

		// Hien thi
		String[] shows = { "", "", "", "" };
		if (!menu.equalsIgnoreCase("")) {
			if (menu.equalsIgnoreCase("user")) {
				shows[1] = "show";
			} else if (menu.equalsIgnoreCase("article")) {
				shows[2] = "show";
			} else if (menu.equalsIgnoreCase("product")) {
				shows[3] = "show";
			}
		}else {
			shows[0]="show";
		}

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-2\">");
		out.print("<div class=\"menu\">");
		out.print("<div class=\"accordion\"  id=\"accordionExample\">");

		out.print("<div class=\"card\">");
		out.print("<div class=\"card-header\" id=\"headingOne\">");
		out.print("<h2 class=\"mb-0\">");
		out.print("<button class=\"btn btn-link btn-block text-left\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">");
		out.print("<i class=\"fas fa-user\"></i> Thống kê");
		out.print("</button>");
		out.print("</h2>");
		out.print("</div>");
//		out.print("<div id=\"collapseOne\" class=\"collapse "+shows[0]+"\" aria-labelledby=\"headingOne\" data-parent=\"#accordionExample\">");
		out.print("<div id=\"collapseOne\" class=\"collapse\" aria-labelledby=\"headingOne\" data-parent=\"#accordionExample\">");
		out.print("<div class=\"card-body\">");
		out.print("<a href=\"/adv/view\"><i class=\"fas fa-clipboard-list\"></i> Tổng hợp</a><br />");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"card\">");
		out.print("<div class=\"card-header\" id=\"headingTwo\">");
		out.print("<h2 class=\"mb-0\">");
		out.print("<button class=\"btn btn-link btn-block text-left\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">");
		out.print("<i class=\"fas fa-user\"></i> Người sử dụng");
		out.print("</button>");
		out.print("</h2>");
		out.print("</div>");
//		out.print("<div id=\"collapseTwo\" class=\"collapse "+shows[1]+"\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionExample\">");
		out.print("<div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionExample\">");
		out.print("<div class=\"card-body\">");
		out.print("<a href=\"/adv/user/view\"><i class=\"fas fa-clipboard-list\"></i> Danh Sách</a><br />");
		out.print("<a href=\"/adv/user/ae\"><i class=\"fas fa-plus-circle\"></i> Thêm mới</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"card\">");
		out.print("<div class=\"card-header\" id=\"headingThree\">");
		out.print("<h2 class=\"mb-0\">");
		out.print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">");
		out.print("<i class=\"far fa-newspaper\"></i> Bài viết");
		out.print("</button>");
		out.print("</h2>");
		out.print("</div>");
//		out.print("<div id=\"collapseThree\" class=\"collapse "+shows[2]+"\" aria-labelledby=\"headingThree\" data-parent=\"#accordionExample\">");
		out.print("<div id=\"collapseThree\" class=\"collapse\" aria-labelledby=\"headingThree\" data-parent=\"#accordionExample\">");
		out.print("<div class=\"card-body\">");
		out.print("<a href=\"/adv/article/view\"><i class=\"fas fa-clipboard-list\"></i> Danh sách</a><br />");
		out.print("<a href=\"/adv/section/view\"><i class=\"fas fa-clipboard-list\"></i> Chuyên mục</a><br />");
		out.print("<a href=\"/adv/category/view\"><i class=\"fas fa-clipboard-list\"></i> Thể loại</a><br />");
		out.print("<a href=\"/adv/article/ae\"><i class=\"fas fa-plus-circle\"></i> Thêm mới</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"card\">");
		out.print("<div class=\"card-header\" id=\"headingFour\">");
		out.print("<h2 class=\"mb-0\">");
		out.print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseFour\" aria-expanded=\"false\" aria-controls=\"collapseFour\">");
		out.print("<i class=\"fab fa-product-hunt\"></i> Sản phẩm");
		out.print("</button>");
		out.print("</h2>");
		out.print("</div>");
//		out.print("<div id=\"collapseFour\" class=\"collapse "+shows[3]+"\" aria-labelledby=\"headingFour\" data-parent=\"#accordionExample\">");
		out.print("<div id=\"collapseFour\" class=\"collapse\" aria-labelledby=\"headingFour\" data-parent=\"#accordionExample\">");
		out.print("<div class=\"card-body\">");
		out.print("<a href=\"/adv/product/view\"><i class=\"fas fa-clipboard-list\"></i> Danh Sách</a><br />");
		out.print("<a href=\"/adv/ps/view\"><i class=\"fas fa-clipboard-list\"></i> Hệ sản phẩm</a><br />");
		out.print("<a href=\"/adv/pg/view\"><i class=\"fas fa-clipboard-list\"></i> Nhóm sản phẩm</a><br />");
		out.print("<a href=\"/adv/pc/view\"><i class=\"fas fa-clipboard-list\"></i> Loại sản phẩm</a><br />");
		out.print("<a href=\"/adv/product/ae\"><i class=\"fas fa-plus-circle\"></i> Thêm mới</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		/*
		 * out.print("<div class=\"card\">");
		 * out.print("<div class=\"card-header\" id=\"headingFive\">");
		 * out.print("<h2 class=\"mb-0\">"); out.
		 * print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseFive\" aria-expanded=\"false\" aria-controls=\"collapseFive\">"
		 * ); out.print("<i class=\"far fa-user-circle\"></i> Custumer");
		 * out.print("</button>"); out.print("</h2>"); out.print("</div>"); out.
		 * print("<div id=\"collapseFive\" class=\"collapse\" aria-labelledby=\"headingFive\" data-parent=\"#accordionExample\">"
		 * ); out.print("<div class=\"card-body\">"); out.
		 * print("<a href=\"/adv/custumer/view\"><i class=\"fas fa-clipboard-list\"></i> Danh Sách</a><br />"
		 * ); out.
		 * print("<a href=\"/adv/custumer/ae\"><i class=\"fas fa-plus-circle\"></i> Thêm mới</a>"
		 * ); out.print("</div>"); out.print("</div>"); out.print("</div>");
		 * 
		 * out.print("<div class=\"card\">");
		 * out.print("<div class=\"card-header\" id=\"headingSix\">");
		 * out.print("<h2 class=\"mb-0\">"); out.
		 * print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseSix\" aria-expanded=\"false\" aria-controls=\"collapseSix\">"
		 * ); out.print("<i class=\"fas fa-user\"></i> Interior");
		 * out.print("</button>"); out.print("</h2>"); out.print("</div>"); out.
		 * print("<div id=\"collapseSix\" class=\"collapse\" aria-labelledby=\"headingSix\" data-parent=\"#accordionExample\">"
		 * ); out.print("<div class=\"card-body\">"); out.
		 * print("<a href=\"/adv/interior/view\"><i class=\"fas fa-clipboard-list\"></i> Danh Sách</a><br />"
		 * ); out.
		 * print("<a href=\"/adv/interior/ae\"><i class=\"fas fa-plus-circle\"></i> Thêm mới</a>"
		 * ); out.print("</div>"); out.print("</div>"); out.print("</div>");
		 * 
		 * out.print("<div class=\"card\">");
		 * out.print("<div class=\"card-header\" id=\"headingSeven\">");
		 * out.print("<h2 class=\"mb-0\">"); out.
		 * print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseSeven\" aria-expanded=\"false\" aria-controls=\"collapseSeven\">"
		 * ); out.print("<i class=\"fas fa-desktop\"></i> Computer");
		 * out.print("</button>"); out.print("</h2>"); out.print("</div>"); out.
		 * print("<div id=\"collapseSeven\" class=\"collapse\" aria-labelledby=\"headingSeven\" data-parent=\"#accordionExample\">"
		 * ); out.print("<div class=\"card-body\">"); out.
		 * print("<a href=\"/adv/computer/view\"><i class=\"fas fa-clipboard-list\"></i> Danh Sách</a><br />"
		 * ); out.
		 * print("<a href=\"/adv/computer/ae\"><i class=\"fas fa-plus-circle\"></i> Thêm mới</a>"
		 * ); out.print("</div>"); out.print("</div>"); out.print("</div>");
		 * 
		 * out.print("<div class=\"card\">");
		 * out.print("<div class=\"card-header\" id=\"headingEight\">");
		 * out.print("<h2 class=\"mb-0\">"); out.
		 * print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseEight\" aria-expanded=\"false\" aria-controls=\"collapseEight\">"
		 * ); out.print("<i class=\"fas fa-user\"></i> Interior");
		 * out.print("</button>"); out.print("</h2>"); out.print("</div>"); out.
		 * print("<div id=\"collapseEight\" class=\"collapse\" aria-labelledby=\"headingEight\" data-parent=\"#accordionExample\">"
		 * ); out.print("<div class=\"card-body\">");
		 * out.print("<a href=\"/adv/interior/view\">Danh Sách</a><br />");
		 * out.print("<a href=\"/adv/interior/ae\">Thêm mới</a>"); out.print("</div>");
		 * out.print("</div>"); out.print("</div>");
		 * 
		 * out.print("<div class=\"card\">");
		 * out.print("<div class=\"card-header\" id=\"headingNine\">");
		 * out.print("<h2 class=\"mb-0\">"); out.
		 * print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseNine\" aria-expanded=\"false\" aria-controls=\"collapseNine\">"
		 * ); out.print("<i class=\"fas fa-user\"></i> Interior");
		 * out.print("</button>"); out.print("</h2>"); out.print("</div>"); out.
		 * print("<div id=\"collapseNine\" class=\"collapse\" aria-labelledby=\"headingNine\" data-parent=\"#accordionExample\">"
		 * ); out.print("<div class=\"card-body\">");
		 * out.print("<a href=\"/adv/interior/view\">Danh Sách</a><br />");
		 * out.print("<a href=\"/adv/interior/ae\">Thêm mới</a>"); out.print("</div>");
		 * out.print("</div>"); out.print("</div>");
		 * 
		 * out.print("<div class=\"card\">");
		 * out.print("<div class=\"card-header\" id=\"headingTen\">");
		 * out.print("<h2 class=\"mb-0\">"); out.
		 * print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseTen\" aria-expanded=\"false\" aria-controls=\"collapseTen\">"
		 * ); out.print("<i class=\"fas fa-user\"></i> Interior");
		 * out.print("</button>"); out.print("</h2>"); out.print("</div>"); out.
		 * print("<div id=\"collapseTen\" class=\"collapse\" aria-labelledby=\"headingTen\" data-parent=\"#accordionExample\">"
		 * ); out.print("<div class=\"card-body\">");
		 * out.print("<a href=\"/adv/interior/view\">Danh Sách</a><br />");
		 * out.print("<a href=\"/adv/interior/ae\">Thêm mới</a>"); out.print("</div>");
		 * out.print("</div>"); out.print("</div>");
		 */
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

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
