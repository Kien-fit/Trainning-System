package jsoft.ads.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsoft.objects.UserObject;
import jsoft.*;

/**
 * Servlet implementation class UserDel
 */
@WebServlet("/user/del")
public class UserDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDel() {
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
		// Tham chiếu phiên làm việc để tìm thông tin đăng nhập
		HttpSession session = request.getSession();

		// Tim thông tin đăng nhập trong phiên làm việc
		UserObject user = (UserObject) session.getAttribute("userLogined");

		// Kiểm tra
		if (user != null) {
			//Tim id nguoi su dung
			int id = jsoft.library.Utilities.getIntParam(request, "id");
			if(id>0) {
				ConnectionPool cp = (ConnectionPool)getServletContext().getAttribute("CPool");
				UserControl uc = new UserControl(cp);
				if(cp==null) {
					getServletContext().setAttribute("CPool", uc.getCP());
				}
				UserObject delUser = new UserObject();
				delUser.getUser_id();
				boolean result = uc.delUser(delUser);
				uc.releaseConnection();
				
				if(result) {
					response.sendRedirect("/adv/user/view");
				}else {
					response.sendRedirect("/adv/user/view?err=notok");					
				}		
			}else {
				response.sendRedirect("/adv/user/view?err=value");									
			}
		} else {
			response.sendRedirect("/adv/user/login");
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
