package com.hoanganh.DAO.impl;

import java.util.List;

import com.hoanganh.DAO.IUserDAO;
import com.hoanganh.mapper.UserMapper;
import com.hoanganh.model.UserModel;

public class UserDAO extends AbstractDAO implements IUserDAO {

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM user";
		return query(sql, new UserMapper() );
	}

	@Override
	public UserModel findByUsernameAndPassword(String userName, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user INNER JOIN role ON role.id=user.roleid ");
		sql.append("WHERE username=? AND password=?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password );
		return users.isEmpty() ? null : users.get(0);
	}



}
