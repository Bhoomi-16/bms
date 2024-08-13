package com.cruds.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cruds.entity.Book;


public interface BookDAO {
	public void create(Book book);
	public void update(Book book);
	public List<Book> getAll();
	public List<Book> findByTitle(String title);
	public List<Book> findByCategory(String category);
	public List<Book> findById(String isbn);
	 Book findById(Long id);
	public void delete(Long id);
	

}
