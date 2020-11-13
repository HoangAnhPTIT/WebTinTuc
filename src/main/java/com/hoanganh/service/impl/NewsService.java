package com.hoanganh.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.hoanganh.DAO.ICategoryDAO;
import com.hoanganh.DAO.INewsDAO;
import com.hoanganh.model.CategoryModel;
import com.hoanganh.model.NewsModel;
import com.hoanganh.service.INewsService;

public class NewsService implements INewsService{
	@Inject 
	private INewsDAO newsDAO;
	@Inject
	private ICategoryDAO categoryDAO;
	@Override
	public List<NewsModel> findAll() {
		return newsDAO.findAll();
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setModifiedBy("");
		newsModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDAO.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(categoryModel.getId());
		Long id =  newsDAO.save(newsModel);
		return newsDAO.findOne(id);
	}
	@Override
	public void update(NewsModel newsUpdate) {
		NewsModel oldNews = newsDAO.findOne(newsUpdate.getId());
		newsUpdate.setCreatedDate(oldNews.getCreatedDate());
		newsUpdate.setCreatedBy(oldNews.getCreatedBy());
		newsUpdate.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newsUpdate.setModifiedBy("");
		CategoryModel categoryModel = categoryDAO.findOneByCode(newsUpdate.getCategoryCode());
		newsUpdate.setCategoryId(categoryModel.getId());
		newsDAO.update(newsUpdate);	
	}
	@Override
	public NewsModel findOne(Long id) {
		NewsModel newsModel = newsDAO.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}
	@Override
	public void delete(Long id) {
		newsDAO.delete(id);		
	}

}
