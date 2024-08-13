package com.cruds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.dao.AuthorDAO;
import com.cruds.entity.Author;


@Service
public class AuthorService {
	@Autowired
	private AuthorDAO authorDAO;
	
	public void create(Author author){
		authorDAO.create(author);
	}
	public List<Author> getAll(){
		return authorDAO.getAll();
	}
	public void update(Author author){
		authorDAO.update(author);
	}
}
