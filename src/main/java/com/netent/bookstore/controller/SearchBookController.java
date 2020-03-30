package com.netent.bookstore.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netent.bookstore.config.util.Constants;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.RestResponse;
import com.netent.bookstore.service.SearchBookService;

/**
 * 
 * @author ajaychauhan01 Rest controller for searching book and coverage.
 */
@RestController
@RequestMapping("/book")
public class SearchBookController {

	private static final Logger LOGGER = LogManager.getLogger(SearchBookController.class);

	@Autowired
	private SearchBookService searchBookService;

	@GetMapping("/search-book")
	public ResponseEntity<RestResponse<Object>> searchBook(
			@RequestParam(name = "author", required = false) String author,
			@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "isbn", required = false) String isbn) {
		LOGGER.info("Paramenters to search book isbn: {}, author: {}, title: {}", isbn, author, title);

		try {
			if (StringUtils.isEmpty(isbn) && StringUtils.isEmpty(author) && StringUtils.isEmpty(title)) {
				LOGGER.info("Required parameters are missing for searching a book");

				return new ResponseEntity<>(new RestResponse<>(null, HttpStatus.BAD_REQUEST.toString(),
						Constants.VALIDATION_MSG_NOT_EMPTY_ISBN_AUTYHOR_TITLE), HttpStatus.BAD_REQUEST);
			}

			List<Book> books = searchBookService.searchBook(author, title, isbn);
			return new ResponseEntity<>(
					new RestResponse<>(books, HttpStatus.OK.toString(),
							books.isEmpty() ? Constants.SEARCH_NO_RECORD_FOUNT : Constants.REQUEST_COMPLETED),
					HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("Exception in searching books", e);
			return new ResponseEntity<>(new RestResponse<>(null, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					Constants.ADMIN_CONTACT_MESSAGE), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/search-coverage")
	public ResponseEntity<RestResponse<Object>> searchCoverage(
			@RequestParam(name = "isbn", required = false) String isbn) {
		LOGGER.debug("SearchBookController:searchCoverage");

		try {
			if (StringUtils.isEmpty(isbn)) {
				LOGGER.info("ISBN are missing for searching coverage");

				return new ResponseEntity<>(new RestResponse<>(null, HttpStatus.BAD_REQUEST.toString(),
						Constants.VALIDATION_MSG_NOT_EMPTY_ISBN), HttpStatus.BAD_REQUEST);
			}

			List<String> coverages = searchBookService.searchCoverage(isbn);
			return new ResponseEntity<>(
					new RestResponse<>(coverages, HttpStatus.OK.toString(),
							coverages.isEmpty() ? Constants.SEARCH_NO_RECORD_FOUNT : Constants.REQUEST_COMPLETED),
					HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("Exception in searching coverages", e);
			return new ResponseEntity<>(new RestResponse<>(null, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					Constants.ADMIN_CONTACT_MESSAGE), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}