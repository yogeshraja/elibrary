package com.sirius.elibrary.controller;

import com.sirius.elibrary.model.Book;
import com.sirius.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.io.ByteArrayInputStream;

@Controller
@CrossOrigin("http://localhost:8080")
public class BookController {

    private final BookService bookService;

    public BookController(@Autowired BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(
            value = "/book/{bid}",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody
    ResponseEntity<Resource> getBook(@PathVariable int bid){
        Book book=bookService.getBook(bid);
        byte[] pdf=bookService.getBookAsByteArray(bid);
        Resource resource=new InputStreamResource(new ByteArrayInputStream(pdf));
        HttpHeaders headers = new HttpHeaders();
        String filename = String.format("%s.pdf",book.getTitle());
        headers.setContentDisposition(ContentDisposition.inline().filename(filename).build());
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.noCache())
                .headers(headers)
                .body(resource);
    }

    //    Function to handle banner image requests
    @GetMapping(
            value = "/banners/{bid}",
            produces = MediaType.IMAGE_PNG_VALUE
    )
    public @ResponseBody
    byte[] getBanner(@PathVariable int bid) {
        return bookService.getBannerAsByteArray(bid);
    }

//    Handler to provide pdf view
    @GetMapping ("/book/view/{bid}")
    public String getBookview(@PathVariable int bid) {
        return "redirect:/bookview.html?bid="+bid;
    }

    @DeleteMapping("/book/{bid}")
    @ResponseBody
    public String deleteBook(@PathVariable int bid){
        bookService.deleteBook(bid);
        return "isDeleted:true";
    }

    @DeleteMapping("/books")
    @ResponseBody
    public String deleteBooks(){
        bookService.deleteAllBooks();
        return "isDeleted:true";
    }
}
