package com.hoanganh.service;

import java.util.List;

import com.hoanganh.model.UserModel;

public interface IUserService {
	List<UserModel> findAll();
	UserModel findByUsernameAndPassword(String userName, String password);
}
