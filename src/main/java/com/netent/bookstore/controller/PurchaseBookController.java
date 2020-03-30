package com.netent.bookstore.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netent.bookstore.config.util.Constants;
import com.netent.bookstore.model.BookOrderDetails;
import com.netent.bookstore.model.RestResponse;
import com.netent.bookstore.service.PurchaseBookService;

/**
 * 
 * @author ajaychauhan01 Rest controller for purchasing a book.
 */
@RestController
@RequestMapping("/book")
public class PurchaseBookController {

	private static final Logger LOGGER = LogManager.getLogger(PurchaseBookController.class);

	@Autowired
	private PurchaseBookService purchaseBookService;

	@PostMapping("/purchase-book")
	public ResponseEntity<RestResponse<String>> purchaseBook(@Valid @RequestBody BookOrderDetails purchaseBook,
			Errors errors) {
		LOGGER.info("Request to purcase book: {}", purchaseBook);

		try {
			if (errors.hasErrors()) {
				LOGGER.info("Required parameters are missing for purchasing a book");

				return new ResponseEntity<>(new RestResponse<String>(null, HttpStatus.BAD_REQUEST.toString(),
						errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
								.collect(Collectors.joining(",  "))),
						HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(new RestResponse<String>(purchaseBookService.purchaseBook(purchaseBook),
					HttpStatus.OK.toString(), Constants.REQUEST_COMPLETED), HttpStatus.OK);

		} catch (DataIntegrityViolationException dve) {
			LOGGER.error("Exception in purchasing book", dve);
			return new ResponseEntity<>(new RestResponse<String>(null, HttpStatus.OK.toString(), Constants.OOS),
					HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception in purchasing book", e);
			return new ResponseEntity<>(new RestResponse<String>(null, HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					Constants.ADMIN_CONTACT_MESSAGE), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}