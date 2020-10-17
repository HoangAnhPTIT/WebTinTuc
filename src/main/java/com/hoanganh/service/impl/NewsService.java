package com.hoanganh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hoanganh.dao.INewsDAO;
import com.hoanganh.model.NewsModel;
import com.hoanganh.service.INewsService;

public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDAO;	 
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		Long newId = newsDAO.save(newsModel);
		return newsDAO.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDAO.findOne(updateNews.getId());
		updateNews.setCreateDate(oldNews.getCreateDate());
		updateNews.setCreateBy(oldNews.getCreateBy());
		newsDAO.update(updateNews);
		return newsDAO.findOne(updateNews.getId());
	}

	@Override
	public void delete(Long id) {
		newsDAO.delete(id);
		
	}

	@Override
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}
	
	
}
