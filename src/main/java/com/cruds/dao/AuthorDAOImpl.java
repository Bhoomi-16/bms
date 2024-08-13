package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.Author;


@Repository
public class AuthorDAOImpl implements AuthorDAO {
@Autowired
private SessionFactory sessionFactory;

public void create(Author author) {
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(author);
	session.getTransaction().commit();
	session.close();
}


public List<Author> getAll() {
	Session session = sessionFactory.openSession();
	List<Author> list = session.createQuery("from Author").list();
	session.close();
	return list;
}


public void update(Author author) {
	
	
}
}
