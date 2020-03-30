package com.netent.bookstore.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author ajaychauhan01
 * Just for application checking purpose.
 */

@RestController
@RequestMapping("/info")
public class AppInfoController {
	private static final Logger LOGGER = LogManager.getLogger(AppInfoController.class);

	@GetMapping("/")
	public String index() {

		LOGGER.info("Application is running..");

		return "Application is running...";

	}
}
