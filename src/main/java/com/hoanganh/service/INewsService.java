package com.hoanganh.service;

import java.util.List;

import com.hoanganh.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel updateNews);
	void delete(Long[] ids);
	List<NewsModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
