package com.hoanganh.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hoanganh.constant.SystemConstant;
import com.hoanganh.model.NewsModel;
import com.hoanganh.service.INewsService;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = -8414978554683999872L;

	@Inject
	private INewsService newsService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsModel model = new NewsModel();
		String pageStr = request.getParameter("page");
		String maxPageItemStr = request.getParameter("maxPageItem");
		if (pageStr != null) {
			model.setPage(Integer.parseInt(pageStr));
		} else {
			model.setPage(1);
		}
		if (maxPageItemStr != null) {
			model.setMaxPageItem(Integer.parseInt(maxPageItemStr));
		} else {
			model.setMaxPageItem(1);
		}
		Integer offset = (model.getPage() - 1) * model.getMaxPageItem();
		model.setListResults(newsService.findAll(offset, model.getMaxPageItem()));
		model.setTotalItem(newsService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));

		request.setAttribute(SystemConstant.MODEL, model);

		RequestDispatcher rd = request.getRequestDispatcher("view/admin/news/list.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
