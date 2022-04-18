package com.sirius.elibrary.service;

import com.sirius.elibrary.model.Book;
import com.sirius.elibrary.model.FileDB;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileDBService {
    String SAVE_PATH=System.getProperty("user.dir")+"/books";
    void store(Book book);
    FileDB getFileDB(String filePath);
    List<FileDB> getAllFileBD(String savePath);
    byte[] getBannerByBook(Book book);
    byte[] getFileByBook(Book book);

    void deleteFileDB(String filepath);
}
