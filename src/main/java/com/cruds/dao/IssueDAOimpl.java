package com.cruds.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cruds.entity.Issue;

@Repository
public class IssueDAOimpl implements IssueDAO {

    @Autowired
    private SessionFactory sessionFactory;

  
    public void create(Issue issue) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(issue);
        session.getTransaction().commit();
        session.close();
    }

   
    public void update(Issue issue) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(issue);
        session.getTransaction().commit();
        session.close();
    }

  
    public List<Issue> getAll() {
        Session session = sessionFactory.openSession();
        List<Issue> list = session.createQuery("from Issue").list();
        session.close();
        return list;
    }

  
    public Issue findById(Long id) {
        Session session = sessionFactory.openSession();
        Issue issue = session.get(Issue.class, id);
        session.close();
        return issue;
    }

  
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Issue issue = session.get(Issue.class, id);
        if (issue != null) {
            session.delete(issue);
        }
        session.getTransaction().commit();
        session.close();
    }


    public List<Issue> findByBookId(Long bookId) {
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Issue.class);
        cr.add(Restrictions.eq("book.id", bookId));
        List<Issue> list = cr.list();
        session.close();
        return list;
    }
}
