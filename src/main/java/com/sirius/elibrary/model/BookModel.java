package com.sirius.elibrary.model;

import org.springframework.web.multipart.MultipartFile;

public class BookModel {
    public String title;
    public String author;
    public int year;
    public MultipartFile file;

    @Override
    public String toString() {
        return "BookModel{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", file=" + file +
                '}';
    }
}
