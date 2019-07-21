package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Book;
import com.cts.service.BookService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bs;
	//get all books
	@GetMapping("/books")
	public List<Book> getBooks() {
		System.out.println("Entered list book");
		List<Book> lb= bs.listAllBooks();
		
		System.out.println("List: "+lb);
		
		return lb;
	}
	
	//get book by id
	
	//@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	@GetMapping("/books/{id}")
	public Book findBook(@PathVariable int id)
	{
		System.out.println("Book id "+id);
		Book b = bs.getBookById(id);
		
		
		return b;
		
	}
	
	
	//delete book
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable ("id") int id) {
		
		bs.deleteBookById(id);
		System.out.println("Book deleted id "+id);
		
		return "Deleted";
		
	}
	
	//add a book
	@PostMapping("/books")
	public Book createBooks(@RequestBody Book book) {
		
		bs.createBook(book);
		return book;
		
	}
	
	//update book
	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public String updateBooks(@RequestBody Book book) {
		
		bs.createBook(book);
		return "Book updated";
		
	}
	
	
	

}






