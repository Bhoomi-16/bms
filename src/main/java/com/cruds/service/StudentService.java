package com.cruds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cruds.dao.StudentDAO;

import com.cruds.entity.Student;
@Service
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	public void create(Student student){
		studentDAO.create(student);
	}
	@Transactional
	public void update(Student student){
		studentDAO.update(student);
	}
	public List<Student> getAll(){
		return studentDAO.getAll();
	}
	
	public Student findByUsn(String usn){
		 return studentDAO.findByUsn(usn);
	}
	public void delete(String usn) {
        studentDAO.delete(usn);
    }
}
	
	
