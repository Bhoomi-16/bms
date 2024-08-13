package com.cruds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.dao.DepartmentDAO;
import com.cruds.entity.Department;
@Service
public class DepartmentService {
	@Autowired
	private DepartmentDAO departmentDAO;
	
	public void create(Department d){
		departmentDAO.create(d);
	}
	public List<Department> getAll(){
		return departmentDAO.getAll();
	}
	
}
