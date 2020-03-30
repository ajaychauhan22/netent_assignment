package com.netent.bookstore.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.netent.bookstore.dao.PurchaseBookDao;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.BookOrderDetails;

/**
 * 
 * @author ajaychauhan01
 *
 */
@Repository
public class PurchaseBookDaoImpl implements PurchaseBookDao {

	private static final Logger LOGGER = LogManager.getLogger(PurchaseBookDaoImpl.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${create.order}")
	private String createOrder;

	@Value("${select.book.by.id}")
	private String selectBookById;

	@Value("${update.book.quantity.by.id}")
	private String updateBookQuantityById;

	public int purchaseBook(BookOrderDetails purchaseBook) {
		LOGGER.info("PurchaseBookDaoImpl:purchaseBook");

		final KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(createOrder, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, purchaseBook.getBookId());
			ps.setInt(2, purchaseBook.getQuantity());
			return ps;
		}, keyHolder);

		return (int) keyHolder.getKeys().get("ID");
	}

	@Override
	public Book getBookById(int id) {
		List<Book> book = jdbcTemplate.query(selectBookById, new Object[] { id },
				new BeanPropertyRowMapper<Book>(Book.class));

		return book.isEmpty() ? null : book.get(0);
	}

	@Override
	public boolean updateBookQuantityById(int id, int quantity) {
		return jdbcTemplate.update(updateBookQuantityById, id, quantity, id) > 0;
	}
}