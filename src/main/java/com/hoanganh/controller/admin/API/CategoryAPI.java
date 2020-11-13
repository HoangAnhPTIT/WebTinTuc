package com.hoanganh.controller.admin.API;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoanganh.model.CategoryModel;
import com.hoanganh.service.ICategoryService;

@WebServlet(urlPatterns= {"/api-category"})
public class CategoryAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	ICategoryService categoryService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");		
		CategoryModel model = new CategoryModel();
		model.setListResult(categoryService.findAll());
		mapper.writeValue(response.getOutputStream(), model);
	}
}
