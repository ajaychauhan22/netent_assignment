package com.netent.bookstore.dao;

import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.BookOrderDetails;

/**
 * 
 * @author ajaychauhan01
 *
 */
public interface PurchaseBookDao {

	Book getBookById(int id);

	boolean updateBookQuantityById(int l, int quantity);

	int purchaseBook(BookOrderDetails purchaseBook);
}