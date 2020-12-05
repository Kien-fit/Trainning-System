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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();
		
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-2\">");
		out.print("<div class=\"menu\">");
		out.print("<div class=\"accordion\"  id=\"accordionExample\">");
		
		out.print("<div class=\"card\">");
		out.print("<div class=\"card-header\" id=\"headingOne\">");
		out.print("<h2 class=\"mb-0\">");
		out.print("<button class=\"btn btn-link btn-block text-left\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">");
		out.print("<i class=\"fas fa-user\"></i> Người sử dụng");
		out.print("</button>");
		out.print("</h2>");
		out.print("</div>");
		out.print("<div id=\"collapseOne\" class=\"collapse\" aria-labelledby=\"headingOne\" data-parent=\"#accordionExample\">");
		out.print("<div class=\"card-body\">");
		out.print("<a href=\"/adv/user/view\">Danh Sách</a><br />");
		out.print("<a href=\"/adv/user/ae\">Thêm mới</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"card\">");
		out.print("<div class=\"card-header\" id=\"headingTwo\">");
		out.print("<h2 class=\"mb-0\">");
		out.print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">");
		out.print("<i class=\"fas fa-user\"></i> Bài viết");
		out.print("</button>");
		out.print("</h2>");
		out.print("</div>");	
		out.print("<div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionExample\">");
		out.print("<div class=\"card-body\">");
		out.print("<a href=\"/adv/article/view\">Danh sách</a><br />");
		out.print("<a href=\"/adv/category/view\">Chuyên mục</a><br />");
		out.print("<a href=\"/adv/section/view\">Thể loại</a><br />");
		out.print("<a href=\"/adv/article/ae\">Thêm mới</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"card\">");
		out.print("<div class=\"card-header\" id=\"headingThree\">");
		out.print("<h2 class=\"mb-0\">");
		out.print("<button class=\"btn btn-link btn-block text-left collapsed\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">");
		out.print("<i class=\"fas fa-user\"></i> Sản phẩm");
		out.print("</button>");
		out.print("</h2>");
		out.print("</div>");
		out.print("<div id=\"collapseThree\" class=\"collapse\" aria-labelledby=\"headingThree\" data-parent=\"#accordionExample\">");
		out.print("<div class=\"card-body\">");
		out.print("<a href=\"/adv/product/view\">Danh Sách</a><br />");
		out.print("<a href=\"/adv/ps/view\">Hệ sản phẩm</a><br />");
		out.print("<a href=\"/adv/pg/view\">Nhóm sản phẩm</a><br />");
		out.print("<a href=\"/adv/pc/view\">Loại sản phẩm</a><br />");
		out.print("<a href=\"/adv/product/ae\">Thêm mới</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
