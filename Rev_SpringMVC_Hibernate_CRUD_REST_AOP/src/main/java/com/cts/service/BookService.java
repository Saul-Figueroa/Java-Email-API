package com.cts.service;

import java.util.List;

import com.cts.model.Book;

public interface BookService {
	
	public List<Book> listAllBooks();
	
	public void createBook(Book book);
	public Book getBookById(int BookId);
//	public void updateBookById(int BookId, float price);
	public void deleteBookById(int BookId);

}
