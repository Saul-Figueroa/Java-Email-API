package com.cts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.Book;

@Repository("bookDAO")
public class BookDAOImpl implements BookDAO{
	
	@Autowired
	SessionFactory sessionFact;
	
	@Override
	public List<Book> getAllBooks()
	{
		ArrayList<Book> booklist = new ArrayList<>();
		//
		Query query = sessionFact.getCurrentSession().createQuery("from Book");
		query.setMaxResults(100);
		booklist = (ArrayList<Book>) query.list();
		System.out.println("List in DAO "+booklist);
		
		
		return booklist;	
	}

	@Override
	public void addBook(Book book) {

		sessionFact.getCurrentSession().saveOrUpdate(book);
		System.out.println("Book saved");
		
	}

	@Override
	public Book fetchBookbyId(int BookId) {
		Session currentSession = sessionFact.getCurrentSession();
		System.out.println("Hello"+BookId);
		Book theBook = currentSession.get(Book.class, BookId);
		return theBook;	
	}

	@Override
	public void deleteBookById(Integer BookId) {
		Session session = sessionFact.getCurrentSession();
		Book book = session.byId(Book.class).load(BookId);
		System.out.println("Delete called from dao "+book);
		session.delete(book);
	}

	@Override
	public void updateBookById(int BookId, float price) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void updateBookById(int BookId, float price) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
//		{
//			Book book = session.get(Book.class, BookId);
//			
//			if (book != null) {
//				book.setPrice(price);
//				
//				session.beginTransaction();
//				session.update(book);
//				session.getTransaction().commit();
//				
//			} else {
//				System.out.println("Book does not exist");
//			}
//			
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		
//	}

	

}


