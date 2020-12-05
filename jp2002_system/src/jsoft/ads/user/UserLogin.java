package jsoft.ads.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import jsoft.*;
import jsoft.objects.*;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/user/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Phương thức cung cấp một GUI về phía trình khách, mốt cấu trúc html
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request - đối tượng lưu trữ các dữ liệu và yêu cầu sử lý từ trình khách gửi lên
		// response - đối tượng lưu trữ các đáp ứng, các kết quả cầ gửi về trình khách

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();
		
		//Tìm tham số báo lỗi
		String error = request.getParameter("err");
		String message = "";
		if(error!=null) {
			if(error.equalsIgnoreCase("param")) {
				message = "lỗi tham số lấy giá trị trong lập trình.";
			}else if(error.equalsIgnoreCase("value")){
				message = "Lỗi thông tin đăng nhập vào hệ thống.";
			}else if(error.equalsIgnoreCase("notok")) {
				message = "Đăng nhập không thành công, hãy kiểm tra tài khoản hoặc mất khẩu!";
			}else {
				message = "Không thành công!";
			}
		}

		// Thực hiện xuất
		out.print("<!doctype html>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"utf-8\">");
		out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		out.print("<title>Login Responsive</title>");
		out.print("<link href=\"/adv/adcss/login.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<link href=\"/adv/adcss/all.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<link href=\"/adv/adcss/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<link href=\"/adv/adcss/bootstrap-grid.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<script language=\"javascript\" src=\"/adv/adjs/login.js\"></script>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-6 offset-md-3 mybg\">");
		
		if(!message.equalsIgnoreCase("")) {
			out.print("<div class=\"row\">");
			out.print("<div style=\"color: red; margin: 20px 0;\" class=\"col-md-12  text-center\">"+message+"</div>");
			out.print("</div>");
		}
		
		out.print("<form name=\"frmLogin\" class=\"frmLogin\" action=\"\" method=\"\">");
		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12 mytitle text-center\"><i class=\"fas fa-user-tie\"></i>Login</div>");
		out.print("</div>");
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-sm-4 col-form-label text-right\">Username</label>");
		out.print("<div class=\"col-sm-6\">");
		out.print("<input type=\"name\" class=\"form-control\" id=\"inputName\" name=\"txtUsername\" value=\"admin\">");
		out.print("</div>");
		out.print("</div>");
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputPassword\" class=\"col-sm-4 col-form-label text-right\" text=\"right\">Password</label>");
		out.print("<div class=\"col-sm-6\">");
		out.print("<input type=\"password\" class=\"form-control\" id=\"inputPassword\" name=\"txtPassword\" value=\"abc123\">");
		out.print("</div>");
		out.print("</div>");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-4\"></div>");
		out.print("<div class=\"col-sm-8\">");
		out.print("<div class=\"form-check\">");
		out.print("<input class=\"form-check-input\" type=\"checkbox\" id=\"chkSave\" name=\"chkSave\">");
		out.print("<label class=\"form-check-label\" for=\"chkSave\">");
		out.print("Save account in this PC?");
		out.print("</label>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<a href=\"#\">Password forget?</a>&nbsp;|&nbsp;");
		out.print("<a href=\"#\">Sign Up!</a>&nbsp;|&nbsp;");
		out.print("<a href=\"#\">Help?</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<button type=\"bottom\" class=\"btn btn-primary\" name=\"btnLogin\" onClick=\"login(this.form)\"><i class=\"fas fa-sign-in-alt\"></i>Login</button>&nbsp;");
		out.print("<button type=\"bottom\" class=\"btn btn-primary\" name=\"btnExit\"><i class=\"fas fa-sign-out-alt\"></i>Exit</button>");
		out.print("</div>");
		out.print("</div>");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-right\">");
		out.print("<a href=\"#\">Tiếng Việt?</a>");
		out.print("</div>");
		out.print("</div>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");

		// Đóng đối tượng xuất
		out.close();

	}

	/**
	 * Phương thức xử lý dữ liệu do doGet gửi/truyền tới.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Lấy thông tin trên giao diện
		String username = request.getParameter("txtUsername");
		String userpass = request.getParameter("txtPassword");

		// Kiểm tra sự hợp lệ của tham số lấy giá trị
		if (username != null && userpass != null) {
			// Cắt bỏ dữ liệu dấu cách thừa
			username = username.trim();
			userpass = userpass.trim();

			// Kiểm tra giá trị
			if (!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("")) {
				// Tham chiếu ngữ cảnh ứng dụng
				ServletContext application = getServletConfig().getServletContext();

				// Tim bộ quản lý kết nối trong ngữ cảnh
				ConnectionPool cp = (ConnectionPool) application.getAttribute("CPool");// cp=null

				// tạo đối tượng thực thi chức năng mức control
				UserControl uc = new UserControl(cp);
				// Nếu cp lúc đầu chưa tồn tại thì hỏi xin ngược trở lại cho ngữ cảnh
				if (cp == null) {
					application.setAttribute("CPool", uc.getCP());
				}

				// Thực hiện đăng nhập
				UserObject user = uc.getUserObject(username, userpass);

				// trả về kết nối
				uc.releaseConnection();

				// kiểm tra kết quả dăng nhập
				if (user != null) {
					// Tham chiếu phiên làm việc
					HttpSession sesion = request.getSession(true);

					// Đưa thông tin đăng nhập vào phiên làm việc
					sesion.setAttribute("userLogined", user);

					// Chuyển về giao diện chính
					response.sendRedirect("/adv/view");
					
				} else {
					response.sendRedirect("/adv/user/login?err=notok");
					
				}

			} else {
				response.sendRedirect("/adv/user/login?err=value");
			}
		} else {
			// Trở lại giao diện và báo lỗi tham số
			response.sendRedirect("/adv/user/login?err=param");
		}

	}

}
