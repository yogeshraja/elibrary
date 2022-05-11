package com.sirius.elibrary.service;

import com.sirius.elibrary.model.Book;
import com.sirius.elibrary.model.FileDB;

import java.util.List;

public interface FileDBS3Service {
    String BUCKET_NAME="elibrary";
    void store(Book book);
    FileDB getFileDB(String filePath);
    List<FileDB> getAllFileBD(String savePath);
    byte[] getBannerByBook(Book book);
    byte[] getFileByBook(Book book);

    void deleteFileDB(String filepath);
}
