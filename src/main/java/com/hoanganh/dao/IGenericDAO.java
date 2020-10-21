package com.hoanganh.dao;

import java.util.List;

import com.hoanganh.mapper.RowMapper;

public interface IGenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMappper, Object... parameters);

	public void update(String sql, Object... parameters);

	public Long insert(String sql, Object... parameters);
	public void delete(String sql, Object... parameters);
	public int count(String sql, Object... parameters);
}
