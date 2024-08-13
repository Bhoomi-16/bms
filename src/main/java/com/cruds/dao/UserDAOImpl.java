package com.cruds.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public User get(String userId, String password) {
		
		Session session =sessionFactory.openSession();
		User user =null;
		
		Query query = session.createQuery("from User where userId=:userId and password=:pwd");
		query.setString("userId", userId);
		query.setString("pwd", password);
		
		List<User> list = query.list();
		session.close();
		if(list.size() >0){
			user =list.get(0);
		}
		return user;
	}
	
	
}
