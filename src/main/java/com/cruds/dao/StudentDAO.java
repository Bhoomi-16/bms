package com.cruds.dao;

import java.util.List;


import com.cruds.entity.Student;

public interface StudentDAO {
	public void create(Student student);
	 List<Student> getAll();
	 public void update(Student student);
	 Student findByUsn(String usn);
	 public void delete(String usn);
}