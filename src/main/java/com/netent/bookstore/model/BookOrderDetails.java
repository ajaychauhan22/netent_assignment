package com.netent.bookstore.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

/**
 * 
 * @author ajaychauhan01
 *
 */
public class BookOrderDetails {
	private int id;

	@Positive(message = "Book Id can't null or empty.")
	private int bookId;

	@Min(value = 1, message = "Please provide valid quantity.")
	private int quantity;

	private int userId;

	BookOrderDetails() {
	}

	public BookOrderDetails(int id, int bookId, int quantity, int userId) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.quantity = quantity;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PurchaseBook [id=" + id + ", bookId=" + bookId + ", quantity=" + quantity + ", userId=" + userId + "]";
	}

}