package com.hoanganh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hoanganh.DAO.INewsDAO;
import com.hoanganh.model.NewsModel;
import com.hoanganh.service.INewsService;

public class NewsService implements INewsService{
	@Inject 
	private INewsDAO newsDAO;
	@Override
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		Long id =  newsDAO.save(newsModel);
		return newsDAO.findOne(id);
	}
	@Override
	public void update(NewsModel newsUpdate) {
		newsDAO.update(newsUpdate);	
	}
	@Override
	public NewsModel findOne(Long id) {
		return newsDAO.findOne(id);
	}
	@Override
	public void delete(Long id) {
		newsDAO.delete(id);		
	}

}
