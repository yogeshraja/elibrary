package com.sirius.elibrary.service;

import com.sirius.elibrary.model.Book;

import java.util.Set;

public interface SearchService {
    public void searchByAuthor();
    public void searchByTitle();
    public void searchByYear();
    public void searchByContent();
    public Set<Book> searchForBooks(String searchString,boolean deepSearch);
}
