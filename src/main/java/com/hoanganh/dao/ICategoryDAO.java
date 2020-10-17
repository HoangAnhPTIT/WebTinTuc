package com.hoanganh.dao;

import java.util.List;

import com.hoanganh.model.CategoryModel;

public interface ICategoryDAO<T> extends IGenericDAO<T>{
	List<CategoryModel> allFind();
}
