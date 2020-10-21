package com.hoanganh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hoanganh.model.RoleModel;
import com.hoanganh.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {

		try {
			UserModel users = new UserModel();
			users.setId(resultSet.getLong("id"));
			users.setUserName(resultSet.getString("usename"));
			users.setFullName(resultSet.getString("fullname"));
			users.setPassword(resultSet.getString("password"));
			users.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return users;
		} catch (SQLException e) {
			return null;
		}
	}

}
