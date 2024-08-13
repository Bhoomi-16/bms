package com.cruds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cruds.entity.Book;
import com.cruds.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value="book.html",method=RequestMethod.GET)
public String showPage(Model model){
		model.addAttribute("command",new Book());
		model.addAttribute("BOOK_LIST",bookService.getAll());
		return "book";
	}
	@RequestMapping(value="searchBooks.html", method=RequestMethod.GET)
	public String showPage(
	    @RequestParam(value = "title", required = false) String title,
	    @RequestParam(value = "category", required = false) String category, 
	    @RequestParam(value = "isbn", required = false) String isbn, 
	    Model model) {
	    
	    model.addAttribute("command", new Book());
	    
	   
	    List<Book> books;
	    
	    if (title != null && !title.isEmpty()) {
	        books = bookService.findByTitle(title);
	    } else if (category != null && !category.isEmpty()) {
	        books = bookService.findByCategory(category);
	    } else if (isbn != null && !isbn.isEmpty()) {
	        books = bookService.findById(isbn);
	    } else {
	        books = bookService.getAll(); 
	    }

	    
	    model.addAttribute("books", books);
	    
	    return "searchBooks";  
	}

	
	@RequestMapping(value="book.html",method=RequestMethod.POST)
	public String doDepartment(@ModelAttribute("book")Book d)
	{
		bookService.create(d);
		return "redirect:book.html";
	}
	@RequestMapping(value = "updateBook/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") Long id, Model model) {
	    Book book = bookService.findById(id);
	    if (book == null) {
	        return "redirect:book.html";
	    }
	    model.addAttribute("book", book);
	    return "updateBook";
	}

	@RequestMapping(value = "updateBook",method = RequestMethod.GET)
	public String doUpdate(@ModelAttribute("book") Book book) {
	    bookService.update(book);
	    return "redirect:book.html";
	}
	
	@RequestMapping(value = "deleteBook", method = RequestMethod.POST)
	public String deleteBook(@RequestParam("id") Long id) {
	    bookService.delete(id);
	    return "redirect:book.html";
	}



}
