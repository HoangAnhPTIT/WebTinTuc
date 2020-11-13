package com.hoanganh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hoanganh.model.RoleModel;
import com.hoanganh.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("roleid"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

}
