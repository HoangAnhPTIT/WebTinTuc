package com.hoanganh.service.impl;

import java.sql.Timestamp;
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

	@Override
	public UserModel save(UserModel userModel) {
		
		userModel.setModifiedBy("");
		userModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		Long id = userDAO.save(userModel);
		return userDAO.findOne(id);
	}


}
