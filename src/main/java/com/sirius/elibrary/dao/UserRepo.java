package com.sirius.elibrary.dao;

import com.sirius.elibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users",path = "users")
public interface UserRepo extends JpaRepository<User,String> {
    User findUserByUsername(String username);
}
