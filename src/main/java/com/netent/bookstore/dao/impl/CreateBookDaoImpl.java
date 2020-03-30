package com.netent.bookstore.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.netent.bookstore.dao.CreateBookDao;
import com.netent.bookstore.model.Book;

/**
 * 
 * @author ajaychauhan01
 *
 */
@Repository
public class CreateBookDaoImpl implements CreateBookDao {

	private static final Logger LOGGER = LogManager.getLogger(CreateBookDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${create.book}")
	private String createBook;

	public boolean createBook(Book book) {
		LOGGER.info("CreateBookDaoImpl:createBook");

		return jdbcTemplate.update(createBook, book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(),
				book.getQuantity()) > 0;
	}
}