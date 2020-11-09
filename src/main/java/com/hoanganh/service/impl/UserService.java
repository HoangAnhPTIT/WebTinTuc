package com.hoanganh.service.impl;

import java.util.List;

import javax.inject.Inject;
import com.hoanganh.DAO.IUserDAO;
import com.hoanganh.model.UserModel;
import com.hoanganh.service.IUserService;

public class UserService implements IUserService {
	@Inject
	private IUserDAO userDAO;
	
	@Override
	public List<UserModel> findAll() {
		return userDAO.findAll();
	}

	@Override
	public UserModel findByUsernameAndPassword(String userName, String password) {
		return userDAO.findByUsernameAndPassword(userName, password);
	}


}
