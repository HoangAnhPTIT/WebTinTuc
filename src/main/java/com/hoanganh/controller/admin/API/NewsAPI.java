package com.hoanganh.controller.admin.API;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoanganh.model.NewsModel;
import com.hoanganh.model.UserModel;
import com.hoanganh.service.INewsService;
import com.hoanganh.utils.HttpUtil;
import com.hoanganh.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-new" })
public class NewsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel model = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		model.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(request, "MODEL")).getUserName());
		model = newsService.save(model);
		mapper.writeValue(response.getOutputStream(), model);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel model = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
//		model.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "MODEL")).getUserName());
		newsService.update(model);
		NewsModel modelUpdated = newsService.findOne(model.getId());
		mapper.writeValue(response.getOutputStream(), modelUpdated);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel model = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newsService.delete(model.getId());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
