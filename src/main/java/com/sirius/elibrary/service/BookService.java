package com.sirius.elibrary.service;

import com.sirius.elibrary.model.Book;

import java.util.List;
import java.util.Set;

public interface BookService {
    Book store(Book book) throws Exception;
    Book getBook(int bid);
    List<Book> getAllBooks();
    byte[] getBannerAsByteArray(int bid);
    byte[] getBookAsByteArray(int bid);

    void deleteBook(int bid);
    void deleteAllBooks();
}
