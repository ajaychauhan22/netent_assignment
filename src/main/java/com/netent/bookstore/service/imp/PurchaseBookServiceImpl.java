package com.netent.bookstore.service.imp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netent.bookstore.config.util.Constants;
import com.netent.bookstore.dao.PurchaseBookDao;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.BookOrderDetails;
import com.netent.bookstore.service.PurchaseBookService;

/**
 * 
 * @author ajaychauhan01
 *
 */
@Service
public class PurchaseBookServiceImpl implements PurchaseBookService {

	private static final Logger LOGGER = LogManager.getLogger(PurchaseBookServiceImpl.class);

	@Autowired
	private PurchaseBookDao purchaseBookDao;

	@Transactional
	public String purchaseBook(BookOrderDetails purchaseBook) {

		// Validate book id and stock.
		Book book = purchaseBookDao.getBookById(purchaseBook.getBookId());
		if (book != null) {
			if (book.getQuantity() >= purchaseBook.getQuantity()) {
				purchaseBookDao.updateBookQuantityById(book.getId(), purchaseBook.getQuantity());
				return Constants.ORDER_PLACED + purchaseBookDao.purchaseBook(purchaseBook);
			} else {
				LOGGER.info("Available stock {}, requested stock {} ", book.getQuantity(), purchaseBook.getQuantity());
				return "Currently, only " + book.getQuantity() + " books are available";
			}
		}
		return Constants.MSG_BOOK_NOT_EXISTS + purchaseBook.getBookId();
	}
}