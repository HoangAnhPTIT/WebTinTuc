package com.hoanganh.service;

import java.util.List;

import com.hoanganh.model.NewsModel;

public interface INewsService {
	List<NewsModel> findAll();
	NewsModel findOne(Long id);
	NewsModel save(NewsModel newsModel);
	void update(NewsModel newsUpdate);
	void delete(Long id);
}
