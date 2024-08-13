package com.cruds.dao;

import java.util.List;

import com.cruds.entity.Department;

public interface DepartmentDAO {
public void create(Department department);
	 List<Department> getAll();

}
