package com.netent.bookstore.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netent.bookstore.common.CommonTestData;
import com.netent.bookstore.dao.PurchaseBookDao;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.BookOrderDetails;
import com.netent.bookstore.service.imp.PurchaseBookServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class PurchaseBookServiceImplTest implements CommonTestData {

	@InjectMocks
	private PurchaseBookServiceImpl purchaseBookServiceImpl;

	private PurchaseBookDao purchaseBookDao;

	@Before
	public void init() {
		purchaseBookDao = Mockito.mock(PurchaseBookDao.class);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateBook_when_id_is_incorrect_stock_should_not_call_update_and_purchase() {
		Mockito.when(purchaseBookDao.getBookById(1)).thenReturn(null);

		purchaseBookServiceImpl.purchaseBook(new BookOrderDetails(0, 1, 10, 1));

		Mockito.verify(purchaseBookDao, Mockito.times(0)).updateBookQuantityById(ArgumentMatchers.anyInt(),
				ArgumentMatchers.anyInt());
		Mockito.verify(purchaseBookDao, Mockito.times(0)).purchaseBook(ArgumentMatchers.any(BookOrderDetails.class));
	}

	@Test
	public void testCreateBook_when_quantity_is_greater_than_stock_should_not_call_update_and_purchase() {
		Book stokBook = bookSupplier.get();
		stokBook.setQuantity(5);

		Mockito.when(purchaseBookDao.getBookById(1)).thenReturn(stokBook);

		purchaseBookServiceImpl.purchaseBook(new BookOrderDetails(0, 1, 10, 1));

		Mockito.verify(purchaseBookDao, Mockito.times(0)).updateBookQuantityById(ArgumentMatchers.anyInt(),
				ArgumentMatchers.anyInt());
		Mockito.verify(purchaseBookDao, Mockito.times(0)).purchaseBook(ArgumentMatchers.any(BookOrderDetails.class));
	}

	@Test
	public void testCreateBook_when_all_validation_pass_then_should_call_update_and_purchase_once() {
		Book stokBook = bookSupplier.get();
		stokBook.setQuantity(5);

		Mockito.when(purchaseBookDao.getBookById(1)).thenReturn(stokBook);
		Mockito.when(purchaseBookDao.updateBookQuantityById(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
				.thenReturn(true);
		Mockito.when(purchaseBookDao.purchaseBook(ArgumentMatchers.any(BookOrderDetails.class))).thenReturn(1);

		purchaseBookServiceImpl.purchaseBook(new BookOrderDetails(0, 1, 2, 1));
		Mockito.verify(purchaseBookDao, Mockito.times(1)).updateBookQuantityById(ArgumentMatchers.anyInt(),
				ArgumentMatchers.anyInt());
		Mockito.verify(purchaseBookDao, Mockito.times(1)).purchaseBook(ArgumentMatchers.any(BookOrderDetails.class));
	}
}
