package jsoft.ads.product.ps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsoft.objects.*;
import jsoft.*;
import jsoft.library.DateTime;
import jsoft.library.Utilities;
import jsoft.library.Utilities_Support;


/**
 * Servlet implementation class View
 */
@WebServlet("/ps/ae")
public class ProductSystemAE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductSystemAE() {
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

		// xác định kiểu nội dung xuất về trình khách
		response.setContentType(CONTENT_TYPE);

		// Tạo đối tượng xuất nội dung về trình khách
		PrintWriter out = response.getWriter();
		
		// Tim id dể sửa nếu có
		int id = Utilities.getIntParam(request, "id");
		String name = "", notes = "", nameEn = "";
		int psId = 0;
		String userOptions = null;

		String title = "<i class=\"fas fa-plus-circle\"></i>";
		String lblCre = "Create";
		String readonly = "";

		boolean isEdit = false;
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
					
		// Tạo đối tượng thực thi
		ProductSystemControl psc = new ProductSystemControl(cp);
		
		if(cp==null) {
			getServletContext().setAttribute("CPool", psc.getCP());
		}
		
		userOptions = psc.viewUserOptions(user);
		
		if (id > 0) {
			
			// Xác định đối tượng để sửa
			ProductSystemObject ePs = psc.getProductSystemObject(id);	
			
			// Kiểm tra
			if (ePs != null) {
				// Tách thông tin để sửa
				name = ePs.getPs_name();
				notes = ePs.getPs_notes();
				nameEn = ePs.getPs_name_en();
				psId = ePs.getPs_manager_id();

				title = "Update Product Group";
				lblCre = "Update";
				readonly = "readonly";

				isEdit = true;
			}
		}
		
		// Trả về kết nối
		psc.releaseConnection();

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
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/article/view\">Product System</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">"+title+"</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");

		out.print("<div class=\"view-content\">");
		out.print("<form name=\"frmPs\" class=\"frmPs\" action=\"\" method=\"\">");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"mytitle\"><i class=\"fas fa-people-carry\"></i> Product system information</div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">Product system name</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputName\" name=\"txtName\" "
				+ "onkeyup=\"checkName(this.form)\" "+ readonly +" value=\""+name+"\" >");
		out.print("<div id=\"viewValidName\"></div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputNameEn\" class=\"col-md-2 col-form-label text-right\">Product system name(English)</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputNameEn\" name=\"txtNameEn\" value=\""+nameEn+"\" >");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">Product system manager</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<select name=\"slcManager\" class=\"form-control\">");
		out.print("<option value=0>...</option>");
		out.print(userOptions);
		out.print("</select>");
		out.print("<div id=\"viewValidSlcManager\"></div>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row align-items-center\">");
		out.print("<label for=\"inputNotes\" class=\"col-md-2 col-form-label text-right\" text=\"right\">Notes</label>");
		out.print("<div class=\"col-md-10\">");
		out.print("<textarea class=\"form-control-file\" id=\"inputNotes\" name=\"txtNotes\" rows=8>"+notes+"</textarea>");
		out.print("</div>");
		out.print("</div>");
		out.print("<script language=\"javascript\" type=\"text/javascript\">");
		out.print("var editor = CKEDITOR.replace('inputNotes');");
		out.print("</script>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnLogin\" onClick=\"savePs(this.form)\"><i class=\"fas fa-sign-in-alt\"></i>"+lblCre+"</button>&nbsp;");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnExit\" onClick=\"window.close()\"><i class=\"fas fa-sign-out-alt\"></i>Exit</button>");
		out.print("</div>");
		out.print("</div>");

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
		int id = Utilities.getIntParam(request, "idForPost");
		
		//Lấy thông tin trên giao diện
		String name = request.getParameter("txtName");
				
		// Kiểm tra
		if(name!=null) {
			name = name.trim();
			
			if(name.equalsIgnoreCase("")) {
				// Lấy thêm thông tin trên giao diện
				String notes = request.getParameter("txtNotes");
				String nameEn = request.getParameter("txtNameEn");
				
				//Tạo đối tượng lưu thông tin
				ProductSystemObject newPs = new ProductSystemObject();
				newPs.setPs_name(Utilities_Support.encode(name));
				newPs.setPs_name_en(Utilities_Support.encode(nameEn));
				newPs.setPs_notes(Utilities_Support.encode(notes));
//				newPs.setPs_manager_id();
				
				//Ngày tạo/sửa sản phẩm
				String date = DateTime.getFullDate("dd/MM/yyyy");
				
				//Tìm thông tin đăng nhập
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined") ;
				newPs.setPs_created_author_id(user.getUser_id());
				
				//Tim bộ quản lý kêt nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
				
				//Tạo đói tượng thực thi
				ProductSystemControl psc = new ProductSystemControl(cp);
				if(cp==null) {
					getServletContext().setAttribute("CPool", psc.getCP());
				}
				
				boolean result;
				if(id>0) {
					// cập nhật
					newPs.setPs_id(id);
					newPs.setPs_modified_date(date);
					result = psc.editProductSystem(newPs);
				} else {
					// Thêm mới
					newPs.setPs_created_date(date);
					result = psc.addProductSystem(newPs);
				}
				
				//Trả về kết nối
				psc.releaseConnection();
				
				//Kiểm tra kết quả
				if(result) {
					response.sendRedirect("/adv/pc/view");
				} else {
					response.sendRedirect("/adv/pc/ae?err=notok");
				}	
			} else {
				response.sendRedirect("/adv/pc/ae?err=value");
			}
		} else {
			response.sendRedirect("/adv/pc/ae?err=param");
		}
	}

}
