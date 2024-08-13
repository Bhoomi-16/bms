package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.Department;
@Repository
public class DepartmentDAOImp  implements DepartmentDAO{
@Autowired
private SessionFactory sessionFactory;
	
	public void create(Department department) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(department);
		session.getTransaction().commit();
		session.close();
	}

	public List<Department> getAll() {
		Session session = sessionFactory.openSession();
		List<Department> list = session.createQuery("from Department").list();
		session.close();
		return list;
	}

}
