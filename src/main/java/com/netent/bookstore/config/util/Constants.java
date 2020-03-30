package com.netent.bookstore.config.util;

/**
 * 
 * @author ajaychauhan01
 *
 */
public class Constants {
	private Constants() {
	}

	public static final String BLANK = "";
	public static final String VALIDATION_ERROR_SEPARATOR = ",  ";
	public static final String VALIDATION_MSG_NOT_EMPTY_ISBN_AUTYHOR_TITLE = "Please provide at least one search criteria(title/author/isbn.)";
	public static final String REQUEST_COMPLETED = "Completed successfully";
	public static final String SEARCH_NO_RECORD_FOUNT = "No record found for given criteria";
	public static final String VALIDATION_MSG_NOT_EMPTY_ISBN = "Please provide ISBN";
	public static final String MSG_BOOK_CREATED = "Book has been created successfully.";
	public static final String MSG_BOOK_EXISTS = "Book already exists with given ISBN : ";
	public static final String MSG_BOOK_NOT_EXISTS = "Book does not exists with the id";
	public static final String ORDER_PLACED = "Order placed with order id #";
	public static final String OOS = "Currently, out of stock";
	public static final String ADMIN_CONTACT_MESSAGE = "Please contact to Admin or try later";
}
