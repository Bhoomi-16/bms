package com.cruds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cruds.entity.Author;
import com.cruds.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	@RequestMapping(value="author.html",method=RequestMethod.GET)
public String showPage(Model model){
		model.addAttribute("command",new Author());
		model.addAttribute("AUTH_LIST",authorService.getAll());
		return "author";
	}
	
	 @RequestMapping(value="author.html",method=RequestMethod.POST)
	public String doDepartment(@ModelAttribute("author")Author d)
	{

		authorService.create(d);
		return "redirect:author.html";
	}
	 
}

