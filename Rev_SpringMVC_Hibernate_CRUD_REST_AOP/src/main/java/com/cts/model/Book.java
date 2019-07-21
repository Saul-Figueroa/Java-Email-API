package com.cts.model;

import java.lang.reflect.Member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Book_Rev")
public class Book {
	
	@Id
	@Column(name="B_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="B_TITLE")
	private String title;
	
	@Column(name="B_AUTHOR")
	private String author;
	
	@Column(name="B_PRICE")
	private double price;
	
	
	
	public Book() {
	}


	public Book(int id, String title, String author, double price) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public Book(String title, String author, double price) {
	
		this.title = title;
		this.author = author;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	



	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price
				+ "]";
	}


	
	
	

}
