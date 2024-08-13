package com.cruds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cruds.entity.Student;
import com.cruds.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "student.html", method = RequestMethod.GET)
    public String showPage(Model model) {
        model.addAttribute("command", new Student());
        model.addAttribute("STUDENT_LIST", studentService.getAll());
        return "student";
    }

    @RequestMapping(value = "student.html", method = RequestMethod.POST)
    public String doStudent(@ModelAttribute("student") Student student) {
        studentService.create(student);
        return "redirect:student.html";
    }

    @RequestMapping(value = "updateStudent/{usn}", method = RequestMethod.GET)
    public String showUpdatePage(@PathVariable("usn") String usn, Model model) {
        Student student = studentService.findByUsn(usn);
        if (student == null) {
            return "redirect:student.html";
        }
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @RequestMapping(value = "updateStudent", method = RequestMethod.GET)
    public String doUpdate(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:student.html";
    }

    @RequestMapping(value = "deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(@RequestParam("usn") String usn) {
        studentService.delete(usn);
        return "redirect:student.html";
    }
}
