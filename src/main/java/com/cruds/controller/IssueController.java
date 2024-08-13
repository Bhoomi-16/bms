package com.cruds.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.cruds.entity.Issue;
import com.cruds.entity.Book;
import com.cruds.service.IssueService;
import com.cruds.service.BookService;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.PropertyEditorSupport;




@Controller
public class IssueController {

	@Autowired
	private IssueService issueService;

	@Autowired
	private BookService bookService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(LocalDate.parse(text, formatter));
			}

			@Override
			public String getAsText() {
				LocalDate value = (LocalDate) getValue();
				return value != null ? value.format(formatter) : "";
			}
		});
	}


	@RequestMapping(value = "issue.html", method = RequestMethod.GET)
	public String showPage(Model model) {
		List<Issue> issues = issueService.getAll();
		System.out.println("Issues List: " + issues);
		model.addAttribute("command", new Issue());
		model.addAttribute("ISSUE_LIST", issueService.getAll());
		model.addAttribute("BOOK_LIST", bookService.getAll());
		return "issue";
	}
	
	@RequestMapping(value = "issue.html", method = RequestMethod.POST)
	public String createIssue(@ModelAttribute("command") Issue issue, BindingResult result, @RequestParam("bookId") Long bookId) {

		System.out.println("Received Issue: " + issue);

		if (issue.getIssueDate() == null || issue.getReturnDate() == null) {
			result.rejectValue("issueDate", "error.issue", "Issue date or return date cannot be null.");
			return "issue"; 
		}

		Book book = bookService.findById(bookId);
		if (book != null) {
			System.out.println("Book Quantity before issue: " + book.getQuantity()); 
			issue.setBook(book);
			issueService.create(issue);
			bookService.decreaseQuantity(bookId);
			book = bookService.findById(bookId); 
			System.out.println("Book Quantity after issue: " + book.getQuantity()); 
			return "redirect:issue.html";
		} else {
			return "error"; 
		}
	}

	@RequestMapping(value = "updateIssue/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") Long id, Model model) {
		Issue issue = issueService.findById(id);
		if (issue == null) {
			return "redirect:/issue.html";
		}
		model.addAttribute("command", issue);
		model.addAttribute("BOOK_LIST", bookService.getAll());
		return "updateIssue";
	}

	@RequestMapping(value = "updateIssue", method = RequestMethod.POST)
	public String doUpdate(@ModelAttribute("command") Issue issue) {

		issueService.update(issue);
		return "redirect:/issue.html"; 
	}


	@RequestMapping(value = "deleteIssue", method = RequestMethod.POST)
	public String deleteIssue(@RequestParam("id") Long id) {
		issueService.delete(id);
		return "redirect:issue.html";
	}
}

