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
import com.hoanganh.service.ICategoryService;
import com.hoanganh.service.INewsService;

@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet {
	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewsService newsService;
	private static final long serialVersionUID = -8414978554683999872L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Long categoryId = 1L;
//		request.setAttribute("news", newsService.findByCategoryId(categoryId));
		
//		String title = "Baì biết thu n !!!"; 
//		String content = "Dep trai ok ";
//		Long categoryId = 4L;
//		NewsModel newsModel = new NewsModel();
//		newsModel.setCategoryId(categoryId);
//		newsModel.setTitle(title);
//		newsModel.setContent(content);
//		newsService.save(newsModel);
//		request.setAttribute("categiries", categoryService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("view/web/home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
