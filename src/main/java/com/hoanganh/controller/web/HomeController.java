package com.hoanganh.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoanganh.model.NewsModel;
import com.hoanganh.model.UserModel;
import com.hoanganh.service.ICategoryService;
import com.hoanganh.service.INewsService;
import com.hoanganh.service.IUserService;
import com.hoanganh.ultis.FormUtil;
import com.hoanganh.ultis.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {
	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewsService newsService;
	
	@Inject
	private IUserService userService;
	
	private static final long serialVersionUID = -8414978554683999872L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("view/login/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("view/web/home.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			model = userService.findByUsernameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if(model!=null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if(model.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				} else if (model.getRole().getCode().equals("ADMIN")){
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
			}
		}
	}
}
