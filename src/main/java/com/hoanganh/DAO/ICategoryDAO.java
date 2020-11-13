package com.hoanganh.DAO;

import java.util.List;

import com.hoanganh.model.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);
}
