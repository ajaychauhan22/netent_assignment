package com.netent.bookstore.dao;

import java.util.List;

import com.netent.bookstore.model.Book;

/**
 * 
 * @author ajaychauhan01
 *
 */
public interface SearchBookDao {

	List<Book> searchBookByAuthorOrTitle(String author, String title);

	List<Book> searchBookByISBN(String isbn);

}
