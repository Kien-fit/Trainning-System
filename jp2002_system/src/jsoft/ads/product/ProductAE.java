package jsoft.ads.product;

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
@WebServlet("/product/ae")
public class ProductAE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Khai báo kiểu nội dung xuất về trình khách
	private static final String CONTENT_TYPE = "text/html; charset = UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductAE() {
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
		String name = "", image = "", price = "", total = "";
		String discountPrice = "", promotionPrice = "";
		String intro = "",  notes = "", code = "", size = "", nameEn = "";
		int pcId = 0;

		String title = "<i class=\"fas fa-plus-circle\"></i>";
		String lblCre = "Create";
		String readonly = "";
		
		String productCategoryOptions = null;

		boolean isEdit = false;
		
		// Tìm bộ quản lý kết nối
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		
		// Tạo đối tượng thực thi
		ProductControl pc = new ProductControl(cp);
		
		if(cp==null) {
			getServletContext().setAttribute("CPool", pc.getCP());
		}
		
		productCategoryOptions = pc.viewProductCategoryOptions(null);
		
		if (id > 0) {
			
			// Xác định đối tượng để sửa
			ProductObject ePro = pc.getProductObject(id);

			// Kiểm tra
			if (ePro != null) {
				// Tách thông tin để sửa
				code = ePro.getProduct_code();
				name = ePro.getProduct_name();
				image = ePro.getProduct_image();
				price = String.valueOf(ePro.getProduct_price());
				discountPrice = String.valueOf(ePro.getProduct_discount_price());
				promotionPrice = String.valueOf(ePro.getProduct_promotion_price());
				total = String.valueOf(ePro.getProduct_total());
				intro = ePro.getProduct_intro();
				notes = ePro.getProduct_notes();
				size = ePro.getProduct_size();
				nameEn = ePro.getProduct_name_en();
				pcId = ePro.getProduct_pc_id();

				title = "Update Product";
				lblCre = "Update";
				readonly = "readonly";

				isEdit = true;
			}
		}
		
		// Trả về kết nối
		pc.releaseConnection();


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
		out.print("<li class=\"breadcrumb-item\"><a href=\"/adv/article/view\">Product</a></li>&nbsp;");
		out.print("<li class=\"breadcrumb-item\">"+title+"</li>");
		out.print("</ol>");
		out.print("</nav>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"row\">");
		out.print("<div class=\"col-md-12\">");

		out.print("<div class=\"view-content\">");
		out.print("<form name=\"frmProduct\" class=\"frmProduct\" action=\"\" method=\"\">");
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-md-12 text-center\">");
		out.print("<div class=\"mytitle\"><i class=\"fas fa-people-carry\"></i> Product information</div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputCode\" class=\"col-md-2 col-form-label text-right\">Product code</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputCode\" name=\"txtCode\" "
				+ "onkeyup=\"checkCode(this.form)\" "+ readonly +" value=\""+code+"\" >");
		out.print("<div id=\"viewValidCode\"></div>");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputName\" class=\"col-md-2 col-form-label text-right\">Product name</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputName\" name=\"txtName\" onkeyup=\"checkName(this.form)\" value=\""+name+"\" >");
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
		out.print("<label for=\"inputPc\" class=\"col-md-2 col-form-label text-right\">Product category</label>");
		out.print("<div class=\"col-md-8\">");
		out.print("<select name=\"slcPc\" class=\"form-control\">");
		out.print("<option value=0>...</option>");
		out.print(productCategoryOptions);
		out.print("</select>");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row align-items-center\">");
		out.print("<label for=\"inputIntro\" class=\"col-md-2 col-form-label text-right\" text=\"right\">Intro</label>");
		out.print("<div class=\"col-md-10\">");
		out.print("<textarea class=\"form-control-file\" id=\"inputIntro\" name=\"txtIntro\" rows=8>"+intro+"</textarea>");
		out.print("</div>");
		out.print("</div>");
		out.print("<script language=\"javascript\" type=\"text/javascript\">");
		out.print("var editor = CKEDITOR.replace('inputIntro');");
		out.print("</script>");
	
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputImage\" class=\"col-md-2 col-form-label text-right\">Image</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputImage\" name=\"txtImage\" value=\""+ image +"\">");
		out.print("</div>");
		out.print("</div>");
	
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputPrice\" class=\"col-md-2 col-form-label text-right\">Price</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputPrice\" name=\"txtPrice\" value=\""+ price +"\">");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputTotal\" class=\"col-md-2 col-form-label text-right\">Total</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputTotal\" name=\"txtTotal\" value=\""+ total +"\">");
		out.print("</div>");
		out.print("</div>");

		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputDiscount\" class=\"col-md-2 col-form-label text-right\">Discount price</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputDiscount\" name=\"txtDiscount\" value=\""+ discountPrice +"\">");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputPromotion\" class=\"col-md-2 col-form-label text-right\">Promotion price</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputPromotion\" name=\"txtPromotion\" value=\""+ promotionPrice +"\">");
		out.print("</div>");
		out.print("</div>");
		
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputSize\" class=\"col-md-2 col-form-label text-right\">Size</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputSize\" name=\"txtSize\" value=\""+ size +"\">");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<label for=\"inputNotes\" class=\"col-md-2 col-form-label text-right\">Notes</label>");
		out.print("<div class=\"col-md-4\">");
		out.print("<input type=\"text\" class=\"form-control\" id=\"inputNotes\" name=\"txtNotes\" value=\""+ notes +"\">");
		out.print("</div>");
		out.print("</div>");
		
		out.print("<div class=\"form-group row\">");
		out.print("<div class=\"col-sm-12 text-center\">");
		out.print("<button type=\"button\" class=\"btn btn-primary\" name=\"btnLogin\" onClick=\"saveProduct(this.form)\"><i class=\"fas fa-sign-in-alt\"></i>"+lblCre+"</button>&nbsp;");
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
		String code = request.getParameter("txtCode");
		String name = request.getParameter("txtName");
		
		String productCategory = request.getParameter("");
		
		// Kiểm tra
		if(name!=null && code!=null ) {
			name = name.trim();
			code = code.trim();
			if(name.equalsIgnoreCase("") && code.equalsIgnoreCase("")) {
				// Lấy thêm thông tin trên giao diện
				String image = request.getParameter("txtImage");
				String intro = request.getParameter("txtIntro");
				String price = request.getParameter("txtPrice");
				String total = request.getParameter("txtTotal");
				String discountPrice = request.getParameter("txtDiscount");
				String promotionPrice = request.getParameter("txtPromotion");
				String size = request.getParameter("txtSize");
				String notes = request.getParameter("txtNotes");
				String nameEn = request.getParameter("txtNameEn");
				
				//Tạo đối tượng lưu thông tin
				ProductObject newPro = new ProductObject();
				newPro.setProduct_code(Utilities_Support.encode(code));
				newPro.setProduct_name(Utilities_Support.encode(name));
				newPro.setProduct_name_en(Utilities_Support.encode(nameEn));
				newPro.setProduct_image(image);
				newPro.setProduct_price(Integer.valueOf(price));
				newPro.setProduct_total(Short.parseShort(total));
				newPro.setProduct_discount_price(Integer.valueOf(discountPrice));
				newPro.setProduct_promotion_price(Integer.valueOf(promotionPrice));
				newPro.setProduct_intro(Utilities_Support.encode(intro));
				newPro.setProduct_notes(Utilities_Support.encode(notes));
				newPro.setProduct_size(Utilities_Support.encode(size));
				
				//Ngày tạo/sửa sản phẩm
				String date = DateTime.getFullDate("dd/MM/yyyy");
				
				//Tìm thông tin đăng nhập
				UserObject user = (UserObject) request.getSession().getAttribute("userLogined") ;
				newPro.setProduct_manager_id(user.getUser_id());
				
				//Tim bộ quản lý kêt nối
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
				
				//Tạo đói tượng thực thi
				ProductControl pc = new ProductControl(cp);
				if(cp==null) {
					getServletContext().setAttribute("CPool", pc.getCP());
				}
				
				boolean result;
				if(id>0) {
					// cập nhật
					newPro.setProduct_id(id);
					newPro.setProduct_modified_date(date);
					result = pc.editProduct(newPro);
				} else {
					// Thêm mới
					newPro.setProduct_created_date(date);
					result = pc.addProduct(newPro);
				}
				
				//Trả về kết nối
				pc.releaseConnection();
				
				//Kiểm tra kết quả
				if(result) {
					response.sendRedirect("/adv/product/view");
				} else {
					response.sendRedirect("/adv/product/ae?err=notok");
				}	
			} else {
				response.sendRedirect("/adv/product/ae?err=value");
			}
		} else {
			response.sendRedirect("/adv/product/ae?err=param");
		}
	}

}
