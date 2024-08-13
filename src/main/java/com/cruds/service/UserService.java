package com.cruds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.dao.UserDAO;
import com.cruds.entity.User;

@Service
public class UserService {
@Autowired
	private UserDAO userDAO;

public User getUser(String userId,String password){
	return userDAO.get(userId, password);
}
}
