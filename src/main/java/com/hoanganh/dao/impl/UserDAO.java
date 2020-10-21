package com.hoanganh.dao.impl;

import java.util.List;

import com.hoanganh.dao.IUserDAO;
import com.hoanganh.mapper.UserMapper;
import com.hoanganh.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String usename, String password, int status) {
		
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE usename = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), usename, password, status);
		return users.isEmpty() ? null : users.get(0) ;
	}

}
