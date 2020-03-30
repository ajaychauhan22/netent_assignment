package com.netent.bookstore.service;

import java.util.List;

import com.netent.bookstore.model.Book;

/**
 * 
 * @author ajaychauhan01
 *
 */
public interface SearchBookService {

	List<Book> searchBook(String author, String title, String isbn);

	List<String> searchCoverage(String isbn);

}
