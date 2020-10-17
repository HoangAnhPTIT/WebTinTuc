package com.hoanganh.dao.impl;

import java.util.List;

import com.hoanganh.dao.ICategoryDAO;
import com.hoanganh.mapper.CategoryMapper;
import com.hoanganh.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO<CategoryModel> {

	@Override
	public List<CategoryModel> allFind() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}
