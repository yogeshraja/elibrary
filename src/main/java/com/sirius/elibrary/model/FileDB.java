package com.sirius.elibrary.model;

import java.io.Serializable;

public class FileDB implements Serializable {
    private byte[] book;
    private byte[] banner;

    public FileDB() {
    }

    public FileDB(byte[] book, byte[] banner) {
        this.book = book;
        this.banner = banner;
    }

    public byte[] getBook() {
        return book;
    }

    public void setBook(byte[] book) {
        this.book = book;
    }

    public byte[] getBanner() {
        return banner;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }
}
