package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
		System.out.println("Value of hassErrors "+bindingResult.hasErrors());

		if (bindingResult.hasErrors()) {
			System.out.println("Errors");
			return "bookForm";
		} else {
			System.out.println(book.getTitle()+" "+book.getAuthor()+" "+book.getPrice());
			bs.createBook(book);
			return "bookConfirmation";
		}
		
		
	}

}
