package com.netent.bookstore.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.netent.bookstore.dao.SearchBookDao;
import com.netent.bookstore.model.Book;

/**
 * 
 * @author ajaychauhan01
 *
 */
@Repository
public class SearchBookDaoImpl implements SearchBookDao {

	private static final Logger LOGGER = LogManager.getLogger(SearchBookDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${select.book.by.author.or.title}")
	private String selectBookByAuthorOrTitle;

	@Value("${select.book.by.isbn}")
	private String selectBookByISBN;

	public List<Book> searchBookByAuthorOrTitle(String author, String title) {
		LOGGER.info("SearchBookDaoImpl:searchBook");

		List<Book> books = jdbcTemplate.query(selectBookByAuthorOrTitle,
				new Object[] { "%" + author + "%", "%" + title + "%" }, new BeanPropertyRowMapper<Book>(Book.class));
		LOGGER.info(books);
		return books;
	}

	public List<Book> searchBookByISBN(String isbn) {
		LOGGER.info("SearchBookDaoImpl:searchCoverage");

		return jdbcTemplate.query(selectBookByISBN, new Object[] { isbn }, new BeanPropertyRowMapper<Book>(Book.class));
	}
}