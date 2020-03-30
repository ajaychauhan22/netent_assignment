package com.netent.bookstore.service.impl;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netent.bookstore.common.CommonTestData;
import com.netent.bookstore.dao.CreateBookDao;
import com.netent.bookstore.dao.SearchBookDao;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.service.imp.CreateBookServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class CreateBookServiceImplTest implements CommonTestData {

	@InjectMocks
	private CreateBookServiceImpl createBookServiceImpl;

	private CreateBookDao createBookDao;
	private SearchBookDao searchBookDao;

	@Before
	public void init() {
		createBookDao = Mockito.mock(CreateBookDao.class);
		searchBookDao = Mockito.mock(SearchBookDao.class);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateBook_should_when_book_isbn_exists() {
		Mockito.when(searchBookDao.searchBookByISBN("ISBN-1")).thenReturn(getBooks(1));

		Book book = bookSupplier.get();
		book.setIsbn("ISBN-1");
		createBookServiceImpl.createBook(book);
		
		Mockito.verify(createBookDao, Mockito.times(0)).createBook(ArgumentMatchers.any(Book.class));
	}

	@Test
	public void testCreateBook_should_create_book_success() {
		Mockito.when(searchBookDao.searchBookByISBN("ISBN-1")).thenReturn(new ArrayList<>());
		Mockito.when(createBookDao.createBook(ArgumentMatchers.any(Book.class))).thenReturn(true);

		Book book = bookSupplier.get();
		book.setIsbn("ISBN-1");
		createBookServiceImpl.createBook(book);
		Mockito.verify(createBookDao, Mockito.times(1)).createBook(ArgumentMatchers.any(Book.class));
	}

}
