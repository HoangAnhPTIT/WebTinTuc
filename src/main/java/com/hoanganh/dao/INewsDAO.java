package com.hoanganh.dao;

import java.util.List;

import com.hoanganh.model.NewsModel;

public interface INewsDAO<T> extends IGenericDAO<T>{
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	NewsModel findOne(Long id);
	List<NewsModel> findAll();
	void update(NewsModel newsModel);
	void delete(Long id);
}
