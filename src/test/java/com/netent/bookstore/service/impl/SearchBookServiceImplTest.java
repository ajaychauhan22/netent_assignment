package com.netent.bookstore.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netent.bookstore.common.CommonTestData;
import com.netent.bookstore.dao.SearchBookDao;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.Coverage;
import com.netent.bookstore.restservice.RestClientService;
import com.netent.bookstore.service.imp.SearchBookServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class SearchBookServiceImplTest implements CommonTestData {

	@InjectMocks
	private SearchBookServiceImpl searchBookServiceImpl;

	private RestClientService<Coverage[]> restClientService;

	private SearchBookDao searchBookDao;

	@SuppressWarnings("unchecked")
	@Before
	public void init() {
		searchBookDao = Mockito.mock(SearchBookDao.class);
		restClientService = Mockito.mock(RestClientService.class);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSearchBookByISBN_should_return_list_of_empty_books() {
		Mockito.when(searchBookDao.searchBookByISBN("ISBN-1")).thenReturn(new ArrayList<Book>());

		assertEquals(0, searchBookServiceImpl.searchBook(null, null, "ISBN-1").size());

		Mockito.verify(searchBookDao, Mockito.times(0)).searchBookByAuthorOrTitle(ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString());

	}

	@Test
	public void testSearchBookByAuthorOrTitle_should_return_list_of_2_books() {
		Mockito.when(searchBookDao.searchBookByAuthorOrTitle(null, "TITLE")).thenReturn(getBooks(2));

		assertEquals(2, searchBookServiceImpl.searchBook(null, "title", null).size());

		Mockito.verify(searchBookDao, Mockito.times(0)).searchBookByISBN(ArgumentMatchers.anyString());

	}

	@Test
	public void testSearchCoverage_when_no_book_in_DB_should_return_empty_coverage_title_list() {
		Mockito.when(searchBookDao.searchBookByISBN("ISBN-X")).thenReturn(new ArrayList<Book>());

		List<String> cov = searchBookServiceImpl.searchCoverage("ISBN-X");

		Mockito.verify(restClientService, Mockito.times(0)).callExternalApi(ArgumentMatchers.anyString(),
				ArgumentMatchers.any());

		assertEquals(0, cov.size());
	}

	@Test
	public void testSearchCoverage_when_book_in_DB_should_return_empty_coverage_title_list() {
		Mockito.when(searchBookDao.searchBookByISBN("ISBN-X")).thenReturn(getBooks(1));
		Mockito.when(restClientService.callExternalApi(ArgumentMatchers.anyString(), ArgumentMatchers.any()))
				.thenReturn(new Coverage[] { new Coverage(1, 1, "abc", "abc xyz"),
						new Coverage(1, 1, "123", "abc great") });

		List<String> cov = searchBookServiceImpl.searchCoverage("ISBN-X");
		assertEquals(2, cov.size());
	}

}
