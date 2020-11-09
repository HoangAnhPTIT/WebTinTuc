package com.hoanganh.DAO.impl;

import java.util.List;

import com.hoanganh.DAO.INewsDAO;
import com.hoanganh.mapper.NewsMapper;
import com.hoanganh.model.NewsModel;

public class NewsDAO extends AbstractDAO implements INewsDAO {

	@Override
	public List<NewsModel> findAll() {
		String sql = "SELECT * FROM news";
		return query(sql, new NewsMapper());
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (");
		sql.append("title, thumbnail, shortdescription, content, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newsModel.getTitle(), newsModel.getThumbnail(), newsModel.getShortDescription(),
				newsModel.getContent(), newsModel.getCategoryId(), newsModel.getCreatedDate(),
				newsModel.getCreatedBy());

	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
				updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());

	}

	@Override
	public void delete(Long id) {
		StringBuilder sql = new StringBuilder("DELETE FROM news WHERE id=?");
		update(sql.toString(), id);
	}

}
