package com.sirius.elibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "bookId_generator")
    private int bid;

    private String title;
    private String author;
    private int year;
    private int pages;
    @JsonIgnore
    private String filePath;
    @Transient
    private String image;

    @Transient
    @JsonIgnore
    private byte[] file;
    @Transient
    @JsonIgnore
    private byte[] banner;

    public Book(String title, String author, int year, byte[] file) {

        this.title = title;
        this.author = author;
        this.year = year;
        this.file = file;
    }

    public Book() {}

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getBanner() {
        return banner;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }

    public void addFileAndBanner(FileDB fileDB){
        this.setFile(fileDB.getBook());
        this.setBanner(fileDB.getBanner());
    }

    public void addBanner(FileDB fileDB){
        this.setBanner(fileDB.getBanner());
    }

    public void removeFile(){
        this.file=null;
    }
}