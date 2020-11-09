package com.hoanganh.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoanganh.model.UserModel;
import com.hoanganh.service.IUserService;
import com.hoanganh.utils.FormUtil;
import com.hoanganh.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String alert = request.getParameter("alert");
			String message = request.getParameter("message");
			if (message != null) {
				request.setAttribute("message", message);
				request.setAttribute("alert", alert);
			}
			RequestDispatcher rd = request.getRequestDispatcher("views/login/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "MODEL");
			RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel userLogin = FormUtil.toModel(UserModel.class, request);
			UserModel userModel = userService.findByUsernameAndPassword(userLogin.getUserName(),
					userLogin.getPassword());
			if (userModel != null) {
				SessionUtil.getInstance().putValue(request, "MODEL", userModel);
				String role = userModel.getRole().getCode();
				if (role.equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin");
				} else if (role.equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				} else {
					response.sendRedirect(request.getContextPath()
							+ "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/dang-nhap?action=login&message=Username Or Password Not Exist&alert=danger");
			}

		}
	}
}
