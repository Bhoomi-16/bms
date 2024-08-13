package com.cruds.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.entity.Book;


@Repository
public class BookDAOImpl implements BookDAO {
	@Autowired
	private SessionFactory sessionFactory;
		
		public void create(Book book) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
			session.close();
		}

		public List<Book> getAll() {
			Session session = sessionFactory.openSession();
			List<Book> list = session.createQuery("from Book").list();
			session.close();
			return list;
		}
		 public List<Book> findByTitle(String title) {
		        Session session = sessionFactory.openSession();
		       Criteria cr = session.createCriteria(Book.class);
		       cr.add(Restrictions.eq("title", title));
		       List<Book> list = cr.list();
		       System.out.println(list);
		        return list;
		    }
		 public List<Book> findByCategory(String category) {
		        Session session = sessionFactory.openSession();
		       Criteria cr = session.createCriteria(Book.class);
		       cr.add(Restrictions.eq("category", category));
		       List<Book> list = cr.list();
		       System.out.println(list);
		        return list;
		    }
		

		

		public List<Book> findById(String isbn) {
			
	        Session session = sessionFactory.openSession();
	       Criteria cr = session.createCriteria(Book.class);
	       cr.add(Restrictions.eq("isbn",isbn));
	       List<Book> list = cr.list();
	       System.out.println(list);
	        return list;
		}

		public void update(Book book) {
	        Session session = sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        try {
	            Book existingBook = (Book) session.get(Book.class, book.getId());
	            if (existingBook != null) {
	                existingBook.setIsbn(book.getIsbn());
	                existingBook.setTitle(book.getTitle());
	                existingBook.setCategory(book.getCategory());
	                existingBook.setQuantity(book.getQuantity());
	                session.update(existingBook);
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


		 public Book findById(Long id) {
		        Session session = sessionFactory.openSession();
		        try {
		            return (Book) session.get(Book.class, id);
		        } finally {
		            session.close();
		        }
		    }

		public void delete(Long id) {
			
			 Session session = sessionFactory.openSession();
		        Transaction tx = session.beginTransaction();

		     
		        Book book = session.get(Book.class, id);
		        if (book != null) {
		            session.delete(book); 
		        }

		        tx.commit();
		        session.close();
		    
		}
		

		

		
}
