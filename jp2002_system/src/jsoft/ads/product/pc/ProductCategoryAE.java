package jsoft.ads.product.pc;

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
import jsoft.library.Utilities_Support;


/**
 * Servlet implementation class View
 */
@WebServlet("/pc/ae")
public class ProductCategoryAE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductCategoryAE() {
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
		String name = "", image = "", notes = "", nameEn = "";
		int pgId = 0;
		
		String title = "<i class=\"fas fa-plus-circle\"></i>";
		String lblCre = "Create";
		String readonly = "";
		
		String productGroupOptions = null;

		boolean isEdit = false;
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		
		// Tạo đối tượng thực thi
		ProductCategoryControl pcc = new ProductCategoryControl(cp);
		
		if(cp==null) {
			getServletContext().setAttribute("CPool", pcc.getCP());
		}
		
		productGroupOptions = pcc.viewProductGroupOptions(null, pgId);
		
		if (id > 0) {
			
			// Xác định đối tượng để sửa
			ProductCategoryObject ePc = pcc.getProductCategoryObject(id);	

			// Kiểm tra
			if (ePc != null) {
				// Tách thông tin để sửa
				name = ePc.getPc_name();
				image = ePc.getPc_image();
				notes = ePc.getPc_notes();
				nameEn = ePc.getPc_name_en();
				pgId = ePc.getPc_pg_id();
				
				title = "Update Product Category";
				lblCre = "Update";
				readonly = "readonly";

				isEdit = true;
			}
			
			productGroupOptions = pcc.viewProductGroupOptions(null, pgId);
		}
		
		// Trả về kết nối
		pcc.releaseConnection();

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
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/article/view\">Product Category</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">"+title+"</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");

		out.print("<div class=\"view-content\">");
		out.print("<form name=\"frmPc\" class=\"frmPc\" action=\"\" method=\"\">");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"mytitle\"><i class=\"fas fa-people-carry\"></i> Product category information</div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">Product name</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputName\" name=\"txtName\" "
				+ "onkeyup=\"checkName(this.form)\" "+ readonly +" value=\""+name+"\" >");
		out.print("<div id=\"viewValidName\"></div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputNameEn\" class=\"col-md-2 col-form-label text-right\">Product name(English)</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputNameEn\" name=\"txtNameEn\" value=\""+nameEn+"\" >");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputPg\" class=\"col-md-2 col-form-label text-right\">Product group</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<select name=\"slcPg\" class=\"form-control\" required>");
		out.print("<option value=0>...</option>");
		out.print(productGroupOptions);
		out.print("</select>");
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
		out.print("<label for=\"inputImage\" class=\"col-md-2 col-form-label text-right\">Image</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputImage\" name=\"txtImage\" value=\""+ image +"\">");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnLogin\" onClick=\"savePc(this.form)\"><i class=\"fas fa-sign-in-alt\"></i>"+lblCre+"</button>&nbsp;");
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
		
		String productGroup = request.getParameter("slcPg");
		
		// Kiểm tra
		if(name!=null) {
			name = name.trim();
			
			if(name.equalsIgnoreCase("")) {
				// Lấy thêm thông tin trên giao diện
				String image = request.getParameter("txtImage");
				String notes = request.getParameter("txtNotes");
				String nameEn = request.getParameter("txtNameEn");
				
				//Tạo đối tượng lưu thông tin
				ProductCategoryObject newPc = new ProductCategoryObject();
				newPc.setPc_name(Utilities_Support.encode(name));
				newPc.setPc_name_en(Utilities_Support.encode(nameEn));
				newPc.setPc_notes(Utilities_Support.encode(notes));
				newPc.setPc_image(image);
				
				//Ngày tạo/sửa sản phẩm
				String date = DateTime.getFullDate("dd/MM/yyyy");
				
				//Tìm thông tin đăng nhập
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined") ;
				newPc.setPc_created_author_id(user.getUser_id());
				newPc.setPc_manager_id(user.getUser_parent_id());
				
				//Tim bộ quản lý kêt nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
				
				//Tạo đói tượng thực thi
				ProductCategoryControl pcc = new ProductCategoryControl(cp);
				if(cp==null) {
					getServletContext().setAttribute("CPool", pcc.getCP());
				}
				
				boolean result;
				if(id>0) {
					// cập nhật
					newPc.setPc_id(id);
					newPc.setPc_modified_date(date);
					result = pcc.editProductCategory(newPc);
				} else {
					// Thêm mới
					newPc.setPc_created_date(date);
					result = pcc.addProductCategory(newPc);
				}
				
				//Trả về kết nối
				pcc.releaseConnection();
				
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
