package com.netent.bookstore.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * 
 * @author ajaychauhan01
 * 
 */
public class Book {
	private int id;

	@NotEmpty(message = "ISBN can't null or empty.")
	private String isbn;

	@NotEmpty(message = "TITLE can't null or empty.")
	private String title;

	@NotEmpty(message = "AUTHOR can't null or empty.")
	private String author;

	@Positive(message = "Please provide valid PRICE.")
	private double price;

	@PositiveOrZero(message = "Please provide valid QUANTITY.")
	private int quantity;

	public Book() {
	}

	public Book(int id, String isbn, String title, String auther, double price, int quantity) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = auther;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", auther=" + author + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}
