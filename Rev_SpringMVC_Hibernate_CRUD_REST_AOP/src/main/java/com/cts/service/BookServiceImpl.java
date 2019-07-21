package com.cts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.BookDAOImpl;
import com.cts.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAOImpl bd;

	@Override
	@Transactional
	public List<Book> listAllBooks() {
		 List<Book> lb = bd.getAllBooks();
		 	System.out.println("List in service "+lb);
		
		return lb;
	}
	
	

	@Override
	@Transactional
	public void createBook(Book book) {
		
		bd.addBook(book);
		
	}

	@Override
	@Transactional
	public Book getBookById(int BookId) {
		System.out.println("Getting id in service "+BookId);
		Book book = bd.fetchBookbyId(BookId);
		return book;
	}
//
//	@Override
//	public void updateBookById(int BookId, float price) {
//		
//		new BookDAOImpl().updateBookById(BookId, price);
//		
//	}
//
	@Override
	@Transactional
	public void deleteBookById(int BookId) {
	bd.deleteBookById(BookId);
		
	}

}
