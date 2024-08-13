package com.cruds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cruds.dao.BookDAO;
import com.cruds.entity.Book;


@Service
public class BookService {
	@Autowired
	private BookDAO bookDAO;
	
	public void create(Book d){
		bookDAO.create(d);
	}
	@Transactional
	public void update(Book book){
		bookDAO.update(book);
	}
	public List<Book> getAll(){
		return bookDAO.getAll();
	}
	 public List<Book> findByTitle(String title) {
	        return bookDAO.findByTitle(title);
	    }
	 public List<Book> findByCategory(String category) {
	        return bookDAO.findByCategory(category);
	    }
	 public List<Book> findById(String isbn){
		return bookDAO.findById(isbn);
		 }
	 @Transactional
	 public Book findById(Long id) {
	        return bookDAO.findById(id);
	    }
	 public void delete(Long id) {
	        bookDAO.delete(id);
	    }
	 public List<Book> findByCriteria(String title, String category, String isbn) {
	        if (title != null && !title.isEmpty()) {
	            return findByTitle(title);
	        } else if (category != null && !category.isEmpty()) {
	            return findByCategory(category);
	        } else if (isbn != null && !isbn.isEmpty()) {
	            return findById(isbn);
	        } else {
	            return getAll();
	        }
	    }
	 public void decreaseQuantity(Long bookId) {
	        Book book = bookDAO.findById(bookId);
	        if (book != null && book.getQuantity() > 0) {
	            book.setQuantity(book.getQuantity() - 1);
	            bookDAO.update(book);
	        }
	    }
}
