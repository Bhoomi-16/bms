package com.cruds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cruds.entity.Department;
import com.cruds.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping(value="dept.html",method=RequestMethod.GET)
public String showPage(Model model){
		model.addAttribute("command",new Department());
		model.addAttribute("DEPT_LIST",departmentService.getAll());
		return "dept";
	}
	@RequestMapping(value="dept.html",method=RequestMethod.POST)
	public String doDepartment(@ModelAttribute("department")Department d)
	{
		
		
		departmentService.create(d);
		return "redirect:dept.html";
	}
}
