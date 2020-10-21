package com.hoanganh.dao.impl;

import java.util.List;

import com.hoanganh.dao.INewsDAO;
import com.hoanganh.mapper.NewsMapper;
import com.hoanganh.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO<NewsModel> {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news ");
		sql.append("(title, content, categoryid, thumbnail, shortdescription, ");
		sql.append("createddate, createdby) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId(),
				newsModel.getThumbnail(), newsModel.getShortDescription(), newsModel.getCreateDate(), newsModel.getCreateBy());

	}

	@Override
	public List<NewsModel> findAll(Integer offset, Integer limit) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news") ;
		if(offset != null && limit != null) {
			sql.append(" LIMIT ?, ?");
			List<NewsModel> news = query(sql.toString(), new NewsMapper(), offset, limit); 
			return news;
		} else {
			List<NewsModel> news = query(sql.toString(), new NewsMapper()); 
			return news;
		}
		

	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder(
				"UPDATE news SET title = ?, thumbnail = ?, content = ?, categoryid = ?, shortdescription = ?,");
		sql.append(" createdby = ?, createddate = ?, modifieddate = ?, modifiedby = ?");
		sql.append(" WHERE id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnail(), updateNews.getContent(),
				updateNews.getCategoryId(), updateNews.getShortDescription(), updateNews.getCreateBy(),
				updateNews.getCreateDate(), updateNews.getModifiedDate(), updateNews.getModifiedBy(),
				updateNews.getId());

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}
}
