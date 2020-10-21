package com.hoanganh.service;

import java.util.List;

import com.hoanganh.model.NewsModel;
import com.hoanganh.model.UserModel;

public interface IUserService {
	UserModel findByUsernameAndPasswordAndStatus(String usename, String password, int status);
}
