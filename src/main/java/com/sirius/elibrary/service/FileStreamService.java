package com.sirius.elibrary.service;

import org.springframework.http.ResponseEntity;

public interface FileStreamService {
    public ResponseEntity<byte[]> prepareContent(final String fileName, final String fileType, final String range);
}
