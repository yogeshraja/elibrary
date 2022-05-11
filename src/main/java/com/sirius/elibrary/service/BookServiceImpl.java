package com.sirius.elibrary.service;

import com.sirius.elibrary.dao.BookRepo;
import com.sirius.elibrary.model.Book;
import com.sirius.elibrary.properties.ResponseProperties;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepo bookRepo;
    private final FileDBS3Service fileDBService;
    private final ResponseProperties responseProperties;
    @Autowired
    public BookServiceImpl(BookRepo bookRepo, FileDBS3Service fileDBService, ResponseProperties responseProperties) {
        this.bookRepo = bookRepo;
        this.fileDBService = fileDBService;
        this.responseProperties = responseProperties;
    }

    @Override
    public Book store(Book book) throws Exception {
        PDDocument pdf = PDDocument.load(book.getFile());
        PDFRenderer pdfRenderer = new PDFRenderer(pdf);
        BufferedImage image = pdfRenderer.renderImageWithDPI(0, 100, ImageType.RGB);
        ByteArrayOutputStream byteArrayImage = new ByteArrayOutputStream();
        ImageIO.write(image, "png", byteArrayImage);
        book.setPages(pdf.getNumberOfPages());
        book.setBanner(byteArrayImage.toByteArray());
        pdf.close();
        System.out.println("Storing file");
        fileDBService.store(book);
        return bookRepo.save(book);
    }

    @Override
    public Book getBook(int bid) {
        Book book = bookRepo.getById(bid);
        book.setImage(String.format("%s/%s/%d", responseProperties.getServerUrl(), "banners", bid));
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepo.findAll();
        bookList = bookList.stream().
                peek(book -> book.setImage(String
                        .format("%s/%s/%d", responseProperties.getServerUrl(), "banners", book.getBid())))
                .collect(Collectors.toList());
        return bookList;
    }

    public byte[] getBannerAsByteArray(int bid) {
        Book book = bookRepo.getById(bid);
        return fileDBService.getBannerByBook(book);
    }

    @Override
    public byte[] getBookAsByteArray(int bid) {
        Book book = bookRepo.getById(bid);
        return fileDBService.getFileByBook(book);
    }

    @Override
    public void deleteAllBooks() {
        List<Book> books=bookRepo.findAll();
        for (Book book:books){
                    fileDBService.deleteFileDB(book.getFilePath());
                    bookRepo.delete(book);
        }
    }

    @Override
    public void deleteBook(int bid) {
        Book book=bookRepo.getById(bid);
        fileDBService.deleteFileDB(book.getFilePath());
        bookRepo.delete(book);
    }
}
