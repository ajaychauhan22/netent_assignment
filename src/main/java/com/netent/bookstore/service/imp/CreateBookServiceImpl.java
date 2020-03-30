package com.netent.bookstore.service.imp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netent.bookstore.config.util.Constants;
import com.netent.bookstore.dao.CreateBookDao;
import com.netent.bookstore.dao.SearchBookDao;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.service.CreateBookService;

/**
 * 
 * @author ajaychauhan01
 *
 */
@Service
public class CreateBookServiceImpl implements CreateBookService {

	private static final Logger LOGGER = LogManager.getLogger(CreateBookServiceImpl.class);

	@Autowired
	private CreateBookDao createBookDao;

	@Autowired
	private SearchBookDao searchBookDao;

	public String createBook(Book book) {

		String message = Constants.MSG_BOOK_CREATED;
		//Check if ISBN already exists
		if (!searchBookDao.searchBookByISBN(book.getIsbn().toUpperCase()).isEmpty()) {
			LOGGER.info("Book already exists with given isbn number {}", book.getIsbn());
			message = Constants.MSG_BOOK_EXISTS + book.getIsbn();
		} else {
			createBookDao.createBook(book);
		}
		return message;
	}
}