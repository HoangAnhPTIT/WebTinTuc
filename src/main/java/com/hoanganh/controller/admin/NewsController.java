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
import com.hoanganh.service.ICategoryService;
import com.hoanganh.service.INewsService;
import com.hoanganh.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;
	@Inject
	private ICategoryService categoryService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		NewsModel model = FormUtil.toModel(NewsModel.class, request);
		if (model.getType().equals(SystemConstant.LIST)) {
			model.setListResult(newsService.findAll());
			
			view = "views/admin/news/list.jsp";
		} else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId()!=null) {
				model = newsService.findOne(model.getId());
			} else {
				
			}
			view = "views/admin/news/edit.jsp";	
		}
		
		request.setAttribute("categories", categoryService.findAll()); 
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
