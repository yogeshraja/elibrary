package com.sirius.elibrary.controller;

import com.sirius.elibrary.model.Book;
import com.sirius.elibrary.service.BookService;
import com.sirius.elibrary.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BooksRestController {

    @Autowired
    BookService bookService;

    @Autowired
    SearchService searchService;

    //    Function to handle file Upload
    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("title") String title,
                                             @RequestParam("author") String author,
                                             @RequestParam("year") int year,
                                             @RequestParam("file") MultipartFile file) throws Exception {
        Book book=new Book(title, author, year, file.getBytes());
        Optional<Book> response = Optional.ofNullable(bookService.store(book));
        return response.isPresent()?"Success":"fail";
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/search")
    public Set<Book> searchBooks(@RequestParam String searchterm,@RequestParam boolean deepsearch){
        return searchService.searchForBooks(searchterm,deepsearch);
    }
}
