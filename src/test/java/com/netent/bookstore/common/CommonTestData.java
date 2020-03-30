package com.netent.bookstore.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.netent.bookstore.model.Book;

public interface CommonTestData {
	Supplier<Book> bookSupplier = Book::new;

	default List<Book> getBooks(int numberOfBooks) {
		List<Book> books = new ArrayList<>();

		for (int i = 0; i < numberOfBooks; i++) {
			Book b = bookSupplier.get();
			b.setTitle("abc");
			books.add(b);
		}
		return books;
	}
}
