package com.hoanganh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hoanganh.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel model = new CategoryModel();
		
		try {
			model.setId(rs.getLong("id"));
			model.setCode(rs.getString("code"));
			model.setName(rs.getString("name"));
			model.setCreatedDate(rs.getTimestamp("createddate"));
			model.setCreatedBy(rs.getString("createdby"));
			if (rs.getTimestamp("modifieddate") != null) {
				model.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			if (rs.getString("modifiedby") != null) {
				model.setModifiedBy(rs.getString("modifiedby"));
			}
			return model;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
