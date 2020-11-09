package com.hoanganh.DAO;

import java.util.List;

import com.hoanganh.model.NewsModel;

public interface INewsDAO {
	List<NewsModel> findAll();
	NewsModel findOne(Long id);
	Long save(NewsModel newsModel);
	void update(NewsModel newsUpdate);
	void delete(Long id);
}
