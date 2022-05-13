package com.sirius.elibrary.service;

import com.sirius.elibrary.model.Book;
import com.sirius.elibrary.model.FileDB;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class FileDBServiceImpl implements FileDBService {
    @Override
    public void store(Book book) {

        book.setFilePath(String.format("%s//%s%s.fileDB", SAVE_PATH, book.getTitle(),UUID.randomUUID()));
        FileOutputStream file;
        ObjectOutputStream fileDBObj;
        try {
            file = new FileOutputStream(book.getFilePath());
            fileDBObj = new ObjectOutputStream(file);
            fileDBObj.writeObject(new FileDB(book.getFile(), book.getBanner()));
            fileDBObj.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileDB getFileDB(String filePath) {
        FileInputStream file;
        FileDB fileDB = null;
        ObjectInputStream fileDBObj;
        try {
            file = new FileInputStream(filePath);
            fileDBObj = new ObjectInputStream(file);
            fileDB = (FileDB) fileDBObj.readObject();
            fileDBObj.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fileDB;
    }

    @Override
    public List<FileDB> getAllFileBD(String savePath) {
        return null;
    }

    @Override
    public byte[] getBannerByBook(Book book) {
        return getFileDB(book.getFilePath())
                .getBanner();
    }

    @Override
    public byte[] getFileByBook(Book book) {
        return getFileDB(book.getFilePath())
                .getBook();
    }

    @Override
    public void deleteFileDB(String filepath) {
        try{
            File file = new File(filepath);
            if(!file.delete()){
                throw new Exception("File could not be deleted");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
