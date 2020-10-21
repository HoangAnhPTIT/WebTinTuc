package com.hoanganh.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.hoanganh.dao.INewsDAO;
import com.hoanganh.model.NewsModel;
import com.hoanganh.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreateBy("");
		Long newId = newsDAO.save(newsModel);
		return newsDAO.findOne(newId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDAO.findOne(updateNews.getId());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("");
		updateNews.setCreateDate(oldNews.getCreateDate());
		updateNews.setCreateBy(oldNews.getCreateBy());
		newsDAO.update(updateNews);
		return newsDAO.findOne(updateNews.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			newsDAO.delete(id);
		}

	}

	@Override
	public List<NewsModel> findAll(Integer offset, Integer limit) {
		return newsDAO.findAll(offset, limit);
	}

	@Override
	public int getTotalItem() {
		return newsDAO.getTotalItem();
	}

}
