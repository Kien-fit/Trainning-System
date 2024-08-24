package jsoft.ads.article.section;

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
import jsoft.library.*;

/**
 * Servlet implementation class View
 */
@WebServlet("/section/ae")
public class SectionAE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SectionAE() {
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

		// Tìm thông tin đăng nhập trong phiên làm việc
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

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tìm id để sửa nếu có
		short id = Utilities.getShortParam(request, "id");
		String name = "", nameEn = "", notes = "";
		int managerId = 0;

		String title = "<i class=\"fas fa-plus-circle\"></i>";
		String lblCre = "Create";

		boolean isEdit = false;


		// Tìm từ khóa nếu có
//		String key = request.getParameter("txtKeyword");
//		String saveKey = (key!=null) ? Utilities_Support.encode(key.trim()) : "";
		
		//Tạo đối tượng bộ lọc
//		SectionObject similar = new SectionObject();
		//Truyền từ khóa tìm kiếm vào tên đăng nhập
//		similar.setSection_name(saveKey);
		
		// Cấu trúc tùy chọn người sử dụng
		String userOptions = null;
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		
		// Tạo đối tượng thực thi chức năng
		SectionControl sc = new SectionControl(cp);
		if(cp==null) {
			getServletContext().setAttribute("CPool", sc.getCP());
		}
		
		//Lấy cấu trúc tùy chọn người sử dụng
		userOptions = sc.viewUserOptions(user);

		if (id > 0) {
			
			// Xác định đối tượng sửa
			SectionObject eSec = sc.getSectionObject(id);

			// kiểm tra
			if (eSec != null) {
				// Lấy thông tin để sửa
				name = eSec.getSection_name();
				nameEn = eSec.getSection_name_en();
				notes = eSec.getSection_notes();
				managerId = eSec.getSection_manager_id();

				title = "Cập nhật chuyên mục";
				lblCre = "Update";

				isEdit = true;
			}
		}	
		
		// Trả lại kết nốil
		sc.releaseConnection();

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();

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
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/section/view\">Chuyên mục</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">" + title + "</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");

		out.print("<div class=\"view-content\">");
		out.print("<form name=\"frmSection\" class=\"frmSection\" action=\"\" method=\"\">");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"mytitle\"><i class=\"fas fa-people-carry\"></i> Section management</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">Section name</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<input type=\"name\" class=\"form-control\" id=\"inputName\" name=\"txtName\" onkeyup=\"checkName(this.form)\" value=\"" + name + "\">");
		out.print("<div id=\"viewValidName\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputNameEng\" class=\"col-md-2 col-form-label text-right\">Name(English)</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputNameEn\" name=\"txtNameEn\" onkeyup=\"checkNameEn(this.form)\" value=\"" + nameEn + "\" >");
		out.print("<div id=\"viewValidNameEn\"></div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">Section manager</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<select name=\"slcManager\" class=\"form-control\" >");
		out.print("<option value=0>...</option>");
		out.print(userOptions);
		out.print("</select>");
		out.print("<div id=\"viewValidSlcManager\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row align-items-center\">");
		out.print("<label for=\"inputNotes\" class=\"col-md-2 col-form-label text-right\" text=\"right\">Notes</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<textarea class=\"form-control-file\" id=\"inputNotes\" name=\"txtNotes\" rows=8 onkeyup=\"checkNotes(this.form)\">" + notes + "</textarea>");
		out.print("<div id=\"viewValidNotes\"></div>");
		out.print("</div>");
		out.print("</div>");
		out.print("<script language=\"javascript\" type=\"text/javascript\">");
		out.print("var editor = CKEDITOR.replace('inputNotes');");
		out.print("</script>");

		/*
		 * out.print("<div class=\"form-group row\">"); 
		 * out.print("<label for=\"input\" class=\"col-md-2 col-form-label text-right\"></label>"); 
		 * out.print("<div class=\"col-md-4\">"); 
		 * out.print("<input type=\"name\" class=\"form-control\" id=\"input\" name=\"txt\">"); 
		 * out.print("</div>"); 
		 * out.print("</div>");
		 */
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnLogin\" onClick=\"saveSection(this.form)\"><i class=\"fas fa-sign-in-alt\"></i>" + lblCre + "</button>&nbsp;");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnExit\" onClick=\"window.close()\"><i class=\"fas fa-sign-out-alt\"></i>Exit</button>");
		out.print("</div>");
		out.print("</div>");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-right\">");
		out.print("<a href=\"#\">Tiếng Việt?</a>");
		out.print("</div>");
		out.print("</div>");

		if (isEdit) {
			// Truyền giá trị của id cho doPost theo cơ chế form ẩn
			out.print("<input type=\"hidden\" id=\"idForPost\" value=\"" + id + "\" />");
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

		// Xác định tập ký tự cần lấy
		request.setCharacterEncoding("UTF-8");

		// Lấy id để sửa nếu có
		short id = Utilities.getShortParam(request, "idForPost");

		// Lấy thông tin trên giao diện
		String name = request.getParameter("txtName");
		String nameEn = request.getParameter("txtNameEn");
		String notes = request.getParameter("txtNotes");
		String manager = request.getParameter("slcManager");

		// Kiểm tra
		if (name != null && nameEn != null && notes != null && manager!=null) {
			name = name.trim();
			nameEn = nameEn.trim();
			notes = notes.trim();
			manager = manager.trim();
			if (name.equalsIgnoreCase("") && notes.equalsIgnoreCase("") && nameEn.equalsIgnoreCase("") && manager.equalsIgnoreCase("")) {

				// Tạo đối tượng lưu thông tin
				SectionObject nSec = new SectionObject();
				nSec.setSection_name(Utilities_Support.encode(name));
				nSec.setSection_name_en(Utilities_Support.encode(nameEn));
				nSec.setSection_notes(Utilities_Support.encode(notes));
				nSec.setSection_manager_id(Integer.valueOf(manager));

				// Ngày tạo/sửa chuyên mục
				String date = DateTime.getFullDate("dd/MM/yyyy");

				// Tìm thông tin đăng nhập
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
				nSec.setSection_created_author_id(user.getUser_id());

				// Tim bộ quản lý kêt nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

				// Tạo đói tượng thực thi
				SectionControl sc = new SectionControl(cp);
				if(cp==null) {
					getServletContext().setAttribute("CPool", sc.getCP());
				}

				boolean result;
				if (id > 0) {
					// action cập nhật
					nSec.setSection_id(id);
					nSec.setSection_last_modified(date);
					result = sc.editSection(nSec);
				} else {
					// action Thêm
					nSec.setSection_created_date(date);
					result = sc.addSection(nSec);
				}

				// Trả về kết nối
				sc.releaseConnection();

				// Kiểm tra kết quả
				if (result) {
					response.sendRedirect("/adv/section/view");
				} else {
					response.sendRedirect("/adv/section/ae?err=notok");
				}
			} else {
				response.sendRedirect("/adv/section/ae?err=value");
			}
		} else {
			response.sendRedirect("/adv/section/ae?err=param");
		}

	}

}
