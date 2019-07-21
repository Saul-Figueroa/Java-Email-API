package com.cts.dao;

import java.util.List;

import com.cts.model.Book;

public interface BookDAO {
	
	public List<Book> getAllBooks();
	public void addBook(Book book);
	public Book fetchBookbyId(int BookId);
	public void deleteBookById(Integer BookId);
//	void updateBookById(int BookId, float price);
	

}
