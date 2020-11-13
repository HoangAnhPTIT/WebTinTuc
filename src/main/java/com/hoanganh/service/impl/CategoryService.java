package com.hoanganh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hoanganh.DAO.ICategoryDAO;
import com.hoanganh.model.CategoryModel;
import com.hoanganh.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	ICategoryDAO categoryDAO;
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}
		
}
