package com.cruds.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.entity.User;
import com.cruds.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
 @RequestMapping(value="login",method=RequestMethod.GET)
	public String showLoginPage(){
		return "login";
	}
 @RequestMapping(value="login",method=RequestMethod.POST)
	public String doLoginP(@RequestParam("userId") String userId,@RequestParam("pwd")String pwd,HttpSession session,RedirectAttributes redirectAttributes ){
	// System.out.println(userId +":"+ pwd);
	 User user = userService.getUser(userId, pwd);
	// System.out.println(user);
	 if(user != null){
		 user.setPassword("");
		 session.setAttribute("USER",user);
		 return "home";
	 }
	 redirectAttributes.addAttribute("ERROR", "Invalid credentials");
		return "redirect:login.html";
	}
}
