package com.netent.bookstore.service;

import com.netent.bookstore.model.BookOrderDetails;

/**
 * 
 * @author ajaychauhan01
 *
 */
public interface PurchaseBookService {
	String purchaseBook(BookOrderDetails purchaseBook);
}