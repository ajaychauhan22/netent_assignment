package com.netent.bookstore.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netent.bookstore.config.util.Constants;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.RestResponse;
import com.netent.bookstore.service.CreateBookService;

/**
 * 
 * @author ajaychauhan01 Rest controller for creating a book
 */

@RestController
@RequestMapping("/book")
public class CreateBookController {

	private static final Logger LOGGER = LogManager.getLogger(CreateBookController.class);

	@Autowired
	private CreateBookService createBookService;

	@PostMapping("/create-book")
	public ResponseEntity<RestResponse<String>> createBook(@Valid @RequestBody Book book, Errors errors) {
		LOGGER.info("Request to create book: {}", book);

		try {
			if (errors.hasErrors()) {
				LOGGER.info("Required parameters are missing for creating a book");

				return new ResponseEntity<>(
						new RestResponse<String>(null, HttpStatus.BAD_REQUEST.toString(),
								errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
										.collect(Collectors.joining(Constants.VALIDATION_ERROR_SEPARATOR))),
						HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(new RestResponse<String>(createBookService.createBook(book),
					HttpStatus.OK.toString(), Constants.REQUEST_COMPLETED), HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("Exception in creating book", e);
			return new ResponseEntity<>(new RestResponse<String>(null, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					Constants.ADMIN_CONTACT_MESSAGE), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}