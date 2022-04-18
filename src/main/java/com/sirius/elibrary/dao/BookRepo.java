package com.sirius.elibrary.dao;

import com.sirius.elibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books",path = "books")
public interface BookRepo extends JpaRepository<Book,Integer> {
}
