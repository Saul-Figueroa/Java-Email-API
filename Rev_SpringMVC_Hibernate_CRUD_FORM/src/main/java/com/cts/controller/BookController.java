package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.model.Book;
import com.cts.service.BookService;
@Controller
@RequestMapping("/BookController")
public class BookController {
	
	@Autowired
	BookService bs;
	
	@GetMapping("/booklist")
	public ModelAndView book(Model model) {
		List<Book> a1= bs.listAllBooks();
//		System.out.println("List is : ");
//		a1.forEach(System.out::println);
		return new ModelAndView("booklist","list",a1);
	}
	
	
	@GetMapping("/showForm")
	public ModelAndView showBookForm(Model model) {
		
		Book book = new Book();
		ModelAndView m1 = new ModelAndView("bookForm");
		m1.addObject("book", book);
		return m1;
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("book") Book book) {
		System.out.println(book.getTitle()+" "+book.getAuthor()+" "+book.getPrice());
		bs.createBook(book);
		return new ModelAndView("redirect:booklist");//will redirect to booklist
		
	}

}
