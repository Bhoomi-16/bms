package com.cruds.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cruds.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Student existingStudent = (Student) session.get(Student.class, student.getUsn());
            if (existingStudent != null) {
                existingStudent.setName(student.getName());
                session.update(existingStudent);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        List<Student> list = session.createQuery("from Student").list();
        session.close();
        return list;
    }

    public Student findByUsn(String usn) {
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Student.class);
        cr.add(Restrictions.eq("usn", usn));
        Student student = (Student) cr.uniqueResult();
        session.close();
        return student;
    }

    public void delete(String usn) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, usn);
        if (student != null) {
            session.delete(student);
        }
        tx.commit();
        session.close();
    }
}
