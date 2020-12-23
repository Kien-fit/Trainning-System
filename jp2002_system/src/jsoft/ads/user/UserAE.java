package jsoft.ads.user;

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
@WebServlet("/user/ae")
public class UserAE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAE() {
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

		// Tim id dể sửa nếu có
		int id = Utilities.getIntParam(request, "id");
		String name = "", fullname = "", email = "", address = "";
		String phone = "", office = "", mobile = "", notes = "";

		String title = "<i class=\"fas fa-plus-circle\"></i>";
		String lblReg = "Register";
		String readonly = "";

		boolean isEdit = false;

		if (id > 0) {
			// Tham chiếu ngữ cảnh
			// Tìm bộ quản lý kết nối
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

			// Tạo đối tượng thực thi
			UserControl uc = new UserControl(cp);
			
			if(cp==null) {
				getServletContext().setAttribute("CPool", uc.getCP());
			}
			
			// Xác định đối tượng để sửa
			UserObject eUser = uc.getUserObject(id);

			// Trả về kết nối
			uc.releaseConnection();

			// Kiểm tra
			if (eUser != null) {
				// Tách thông tin để sửa
				name = eUser.getUser_name();
				fullname = eUser.getUser_fullname();
				email = eUser.getUser_email();
				address = eUser.getUser_address();
				phone = eUser.getUser_homephone();
				office = eUser.getUser_officephone();
				mobile = eUser.getUser_mobilephone();
				notes = eUser.getUser_notes();

				title = "cập nhật người sử dụng";
				lblReg = "Update";
				readonly = "readonly";

				isEdit = true;
			}
		}

		// Tìm header và include
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"col-md-10\">");
		out.print("<div class=\"row mt-flex view-header\">");
		out.print("<div class=\"col-md-9\">");
		out.print("<nav aria-label=\"breadcrumb\">");
		out.print("<ol class=\"breadcrumb\">");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/view\">Dashboard</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/user/view\">Người sử dụng</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">" + title + "</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("<div class=\"col-md-3\">");
		out.print("<div class=\"view-search\">");
		out.print("<form class=\"form-inline\">");
		out.print("<div class=\"form-group\">");
		out.print("<label for=\"inputKeyword\">Tìm kiếm</label>&nbsp;");
		out.print("<input type=\"text\" id=\"inputKeyword\" class=\"form-control mx-sm-3\" aria-describedby=\"keywordHelpInline\" placeholder=\"Từ khóa\">");
		out.print("</div>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");

		out.print("<div class=\"view-content\">");
		out.print("<form name=\"frmUser\" class=\"frmUser\" action=\"\" method=\"\">");

		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"mytitle\"><i class=\"fas fa-people-carry\"></i> Account information</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">User name</label>");
		out.print("<div class=\"col-md-3\">");
		out.print(
				"<input type=\"name\" class=\"form-control\" id=\"inputName\" name=\"txtUserName\" onkeyup=\"checkName(this.form)\" "
						+ readonly + " value=\"" + name + "\">");
		out.print("<div id=\"viewValidName\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print(
				"<label for=\"inputPass\" class=\"col-md-2 col-form-label text-right\" text=\"right\">Password</label>");
		out.print("<div class=\"col-md-3\">");
		out.print(
				"<input type=\"password\" class=\"form-control-file\" id=\"inputPass\" name=\"txtUserPass\" onkeyup=\"checkPass(this.form)\">");
		out.print("<div id=\"viewValidPass1\"></div>");
		out.print("</div>");

		out.print(
				"<label for=\"inputPass2\" class=\"col-md-2 col-form-label text-right\" text=\"right\">Confirm</label>");
		out.print("<div class=\"col-md-3\">");
		out.print(
				"<input type=\"password\" class=\"form-control-file\" id=\"inputPass2\" name=\"txtUserPassConfirm\" onkeyup=\"checkPass(this.form)\">");
		out.print("<div id=\"viewValidPass2\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputEmail\" class=\"col-md-2 col-form-label text-right\">Email address</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<input type=\"name\" class=\"form-control\" id=\"inputEmail\" name=\"txtEmail\" value=\"" + email
				+ "\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputPermis\" class=\"col-md-2 col-form-label text-right\">Permission</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<script language=\"javascript\">");
		out.print("generatePermis();");
		out.print("</script>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row align-items-center\">");
		out.print("<label for=\"inputRoles\" class=\"col-md-2 col-form-label text-right\">Roles</label>");
		out.print("<div class=\"col-md-10\">");
		out.print("<script language=\"javascript\">");
		out.print("generateRole();");
		out.print("</script>");
		out.print("<div id=\"validPermis\"></div>");
		out.print("</div>");
		out.print("</div>");

		
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"mytitle\"><i class=\"fas fa-people-carry\"></i> Defail information</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputFullName\" class=\"col-md-2 col-form-label text-right\">Full name</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputFullName\" name=\"txtFullName\" value=\""
				+ fullname + "\">");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputAlias\" class=\"col-md-2 col-form-label text-right\">Alias</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputAlias\" name=\"txtAlias\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputAddress\" class=\"col-md-2 col-form-label text-right\">Address</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputAddress\" name=\"txtAddress\" value=\""
				+ address + "\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputbirthdate\" class=\"col-md-2 col-form-label text-right\">BirthDate</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<input type=\"date\" class=\"form-control\" name=\"txtbirthdate\" id=\"inputbirthdate\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputGender\" class=\"col-md-2 col-form-label text-right\">Gender</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<select class=\"form-control\" id=\"inputGender\" name=\"slcGender\">");
		out.print("<option value=\"0\">Nam</option>");
		out.print("<option value=\"1\">Nữ</option>");
		out.print("<option value=\"2\">Nam-->Nữ</option>");
		out.print("<option value=\"3\">Nữ-->Nam</option>");
		out.print("<option value=\"4\">Nam---</option>");
		out.print("<option value=\"5\">Nữ----</option>");
		out.print("<option value=\"6\" selected>--*--</option>");
		out.print("</select>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputHomePhone\" class=\"col-md-2 col-form-label text-right\">Home Phone</label>");
		out.print("<div class=\"col-md-2\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputHomePhone\" name=\"txtHomePhone\" value=\""
				+ phone + "\">");
		out.print("</div>");
		out.print("<label for=\"inputOfficePhone\" class=\"col-md-2 col-form-label text-right\">Office Phone</label>");
		out.print("<div class=\"col-md-2\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputOfficePhone\" name=\"txtOfficePhone\" value=\""
				+ office + "\">");
		out.print("</div>");
		out.print("<label for=\"inputMobilePhone\" class=\"col-md-2 col-form-label text-right\">Mobile Phone</label>");
		out.print("<div class=\"col-md-2\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputMobilePhone\" name=\"txtMobilePhone\" value=\""
				+ mobile + "\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row align-items-center\">");
		out.print("<label for=\"inputNote\" class=\"col-md-2 col-form-label text-right\" text=\"right\">Note</label>");
		out.print("<div class=\"col-md-10\">");
		out.print("<textarea class=\"form-control-file\" id=\"inputNote\" rows=8>" + notes + "</textarea>");
		out.print("</div>");
		out.print("</div>");
		out.print("<script language=\"javascript\" type=\"text/javascript\">");
		out.print("var editor = CKEDITOR.replace('inputNote');");
		out.print("</script>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputDepartNames\" class=\"col-md-2 col-form-label text-right\">Names</label>");
		out.print("<div class=\"col-md-3\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputDepartNames\" name=\"txtDepartNames\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputAddress\" class=\"col-md-2 col-form-label text-right\">Address</label>");
		out.print("<div class=\"col-md-12\">");
		out.print("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.4556912349094!2d105.73295331540258!3d21.05445439227537!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345457e292d5bf%3A0x20ac91c94d74439a!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBDw7RuZyBuZ2hp4buHcCBIw6AgTuG7mWk!5e0!3m2!1svi!2s!4v1592396080575!5m2!1svi!2s\" width=\"100%\" height=\"600px\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\" aria-hidden=\"false\" tabindex=\"0\"></iframe>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<a href=\"#\"><i class=\"fas fa-headset\"></i>Support!</a> &nbsp;");
		out.print("<a href=\"#\"><i class=\"fas fa-question-circle\"></i>Help?</a>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnLogin\" onClick=\"saveUser(this.form)\"><i class=\"fas fa-sign-in-alt\"></i> " + lblReg + "</button>&nbsp;");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnExit\" onClick=\"window.close()\"><i class=\"fas fa-sign-out-alt\"></i> Exit</button>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-right\">");
		out.print("<a href=\"#\">Tiếng Việt?</a>");
		out.print("</div>");
		out.print("</div>");

		if (isEdit) {
			// Truyền giá trị của id cho doPost theo cơ chế form ẩn
			out.print("<input type=\"hidden\" name=\"idForPost\" value=\"" + id + "\" />");
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

		// Tìm id để ghi nhận sự cập nhật nếu có
		int id = Utilities.getIntParam(request, "idForPost");

		// Lấy toàn bộ thông tin trên giao diện
		String name = request.getParameter("txtUserName");
		String pass = request.getParameter("txtUserPass");
		String passConfirm = request.getParameter("txtUserPassConfirm");
		String email = request.getParameter("txtEmail");

		// Kiểm tra
		if (name != null && pass != null && email != null) {
			name = name.trim();
			pass = pass.trim();
			passConfirm = passConfirm.trim();
			email = email.trim();

			if (!name.equalsIgnoreCase("") && !pass.equalsIgnoreCase("") && pass.equals(passConfirm)
					&& !email.equalsIgnoreCase("")) {

				// Lấy tiếp thông tin
				String fullName = request.getParameter("txtFullName");
				String address = request.getParameter("txtAddress");
				String homePhone = request.getParameter("txtHomePhone");
				String officePhone = request.getParameter("txtOfficePhone");
				String mobilePhone = request.getParameter("txtMobilePhone");

				// Tao đối tượng lưu trữ thông tin mới
				UserObject nUser = new UserObject();
				nUser.setUser_name(name);
				nUser.setUser_pass(pass);
				nUser.setUser_email(email);

				nUser.setUser_fullname(Utilities_Support.encode(fullName));
				nUser.setUser_address(Utilities_Support.encode(address));
				nUser.setUser_homephone(homePhone);
				nUser.setUser_officephone(officePhone);
				nUser.setUser_mobilephone(mobilePhone);

				// Ngày tạo/sửa tài khoản
				String date = DateTime.getFullDate("dd:MM:yyyy");

				// Tìm thông tin đăng nhập
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
				nUser.setUser_parent_id(user.getUser_id());

				// Tìm bộ quản lý kết nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");

				UserControl uc = new UserControl(cp);

				if(cp==null) {
					getServletContext().setAttribute("CPool", uc.getCP());
				}
				
				boolean result;

				if (id > 0) {
					// Thực hiện cập nhật
					nUser.setUser_id(id);
					nUser.setUser_last_modified(date);
					result = uc.editUser(nUser);
				} else {
					// Thực hiện thêm mới
					nUser.setUser_created_date(date);
					result = uc.addUser(nUser);
				}

				// trả về kết nối
				uc.releaseConnection();

				// kiểm tra kết quả
				if (result) {
					response.sendRedirect("/adv/user/view");
				} else {
					response.sendRedirect("/adv/user/ae?err=notok");

				}

			} else {
				// Trả về thông báo lỗi
				response.sendRedirect("/adv/user/ae?err=value");
			}
		} else {
			// Trả về thông báo lỗi
			response.sendRedirect("/adv/user/ae?err=param");
		}
	}

}
