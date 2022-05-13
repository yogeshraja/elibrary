package com.sirius.elibrary.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.sirius.elibrary.model.Book;
import com.sirius.elibrary.model.FileDB;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileDBS3ServiceImpl implements FileDBS3Service {

    private final AmazonS3Client s3Client;

    public FileDBS3ServiceImpl(AmazonS3Client s3Client) {
        this.s3Client = s3Client;
    }


    @Override
    public void store(Book book) {
        book.setFilePath(String.format("%s%s.fileDB", book.getTitle(),UUID.randomUUID()));
        FileDB fileDB=new FileDB(book.getFile(), book.getBanner());
        byte[] byteData=Objects.requireNonNull(SerializationUtils.serialize(fileDB));
        InputStream is=new ByteArrayInputStream(byteData);
        ObjectMetadata metadata=new ObjectMetadata();
        metadata.addUserMetadata("FileType","Object");
        metadata.setContentLength(byteData.length);
        PutObjectRequest request=new PutObjectRequest(BUCKET_NAME,book.getFilePath(),is,metadata);
        s3Client.putObject(request);
    }

    @Override
    public FileDB getFileDB(String filePath) {
        S3Object s3Object=s3Client.getObject(BUCKET_NAME,filePath);
        S3ObjectInputStream s3ObjectInputStream=s3Object.getObjectContent();
        FileDB fileDB;
        try {
            byte[] byteData=s3ObjectInputStream.readAllBytes();
            fileDB=(FileDB) SerializationUtils.deserialize(byteData);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        s3Client.deleteObject(BUCKET_NAME,filepath);
    }

    public String getImageUrl(){
        s3Client.putObject(BUCKET_NAME,"test.png",new File("/Users/yogeshwaran.rajendra/Desktop/test.png"));
        return s3Client.getResourceUrl(BUCKET_NAME,"test.png");
    }
}
