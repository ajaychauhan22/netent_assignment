package com.netent.bookstore.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.netent.bookstore.dao.SearchBookDao;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.Coverage;
import com.netent.bookstore.restservice.RestClientService;
import com.netent.bookstore.service.SearchBookService;

/**
 * 
 * @author ajaychauhan01
 *
 */
@Service
public class SearchBookServiceImpl implements SearchBookService {

	private static final Logger LOGGER = LogManager.getLogger(SearchBookServiceImpl.class);

	@Autowired
	private SearchBookDao searchBookDao;

	@Autowired
	private RestClientService<Coverage[]> restClientService;

	private static final String COVERAGE_API_URL = "https://jsonplaceholder.typicode.com/posts";

	@Transactional(readOnly = true)
	public List<Book> searchBook(String author, String title, String isbn) {
		LOGGER.info("SearchBookServiceImpl:searchBook");

		List<Book> books;
		// If input has isbn then search by isbn only because isbn should be exact match
		if (!StringUtils.isEmpty(isbn)) {
			books = searchBookDao.searchBookByISBN(isbn.toUpperCase());
		} else {
			books = searchBookDao.searchBookByAuthorOrTitle(StringUtils.isEmpty(author) ? null : author.toUpperCase(),
					StringUtils.isEmpty(title) ? null : title.toUpperCase());
		}
		return books;
	}

	@Transactional(readOnly = true)
	public List<String> searchCoverage(String isbn) {

		List<Book> book = searchBookDao.searchBookByISBN(isbn.toUpperCase());

		List<String> covTitles = new ArrayList<>();
		// First check the book in our DB.
		if (!book.isEmpty()) {
			final Book requestedBook = book.get(0);

			// calling coverage third party endpoint.
			Coverage[] coverages = restClientService.callExternalApi(COVERAGE_API_URL, Coverage[].class);

			LOGGER.info("Coverage api called successfully");
			if (coverages != null) {
				// filtering title of book in coverage's title/body and collecting title.
				covTitles = Arrays.stream(coverages).filter(cvrg -> (!StringUtils.isEmpty(cvrg.getTitle())
						&& cvrg.getTitle().toUpperCase().contains(requestedBook.getTitle().toUpperCase()))
						|| (!StringUtils.isEmpty(cvrg.getBody())
								&& cvrg.getBody().toUpperCase().contains(requestedBook.getTitle().toUpperCase())))
						.map(Coverage::getTitle).collect(Collectors.toList());
			}
		}

		return covTitles;
	}
}