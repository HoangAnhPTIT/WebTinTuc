package com.hoanganh.DAO;

import java.util.List;

import com.hoanganh.model.UserModel;

public interface IUserDAO {
	List<UserModel> findAll();
	UserModel findOne(Long id);
	UserModel findByUsernameAndPassword(String userName, String password);
	Long save(UserModel userModel);
}
