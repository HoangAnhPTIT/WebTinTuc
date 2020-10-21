package com.hoanganh.service.impl;

import javax.inject.Inject;

import com.hoanganh.dao.IUserDAO;
import com.hoanganh.model.UserModel;
import com.hoanganh.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUsernameAndPasswordAndStatus(String usename, String password, int status) {
		return userDAO.findByUsernameAndPasswordAndStatus(usename, password, status);
	}

}
