package com.sirius.elibrary.service;

import com.sirius.elibrary.dao.BookRepo;
import com.sirius.elibrary.model.Book;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService{
    @Autowired
    private BookService bookService;
    @Autowired
    private FileDBService fileDBService;

    private List<Book> dataStore;
    private Set<Book> searchResult;
    private String searchString;

    public SearchServiceImpl() {
        this.searchResult = new LinkedHashSet<>();
    }

    public List<Book> getDataStore() {
        return dataStore;
    }

    public void setDataStore(List<Book> dataStore) {
        this.dataStore = dataStore;
    }

    public Set<Book> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(Set<Book> searchResult) {
        this.searchResult =  searchResult;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public void searchByAuthor() {
        searchResult.addAll(
                dataStore.stream()
                        .filter(book -> Pattern.matches(searchString,book.getAuthor())
                        )
                        .collect(Collectors.toList()));
    }

    @Override
    public void searchByTitle() {
        searchResult.addAll(
                dataStore.stream()
                        .filter(book ->Pattern.matches(searchString,book.getTitle())
                        )
                        .collect(Collectors.toList()));
    }

    @Override
    public void searchByYear() {
        searchResult.addAll(
                dataStore.stream()
                        .filter(book -> Pattern.matches(searchString,Integer.toString(book.getYear())))
                        .collect(Collectors.toList()));
    }

    @Override
    public void searchByContent() {
        searchResult.addAll(
                dataStore.stream()
                        .map(book -> {
                            byte[] byteBook= fileDBService.getFileByBook(book);
                            String pdfText="";
                            try {
                                PDDocument pdf=PDDocument.load(byteBook);
                                PDFTextStripper pdfTextStripper=new PDFTextStripper();
                                pdfTextStripper.setStartPage(1);
                                pdfTextStripper.setEndPage(book.getPages());
                                pdfText=pdfTextStripper.getText(pdf);
                                pdf.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return Pair.of(book,pdfText);
                        })
                        .peek(pair-> System.out.println(pair.getSecond()))
                        .filter(pair -> Pattern.matches(searchString,pair.getSecond()))
                        .map(Pair::getFirst)
                        .collect(Collectors.toList()));
    }

    @Override
    public Set<Book> searchForBooks(String searchString, boolean deepSearch) {
        setSearchString(String.format("(?i).*(%s).*",searchString));
        setDataStore(bookService.getAllBooks());
        searchResult.clear();
        searchByTitle();
        searchByAuthor();
        searchByYear();
        if(deepSearch){
            searchByContent();
        }
        return searchResult;
    }
}
