package com.hoanganh.dao;

import com.hoanganh.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	UserModel findByUsernameAndPasswordAndStatus(String usename, String password, int status);
}
