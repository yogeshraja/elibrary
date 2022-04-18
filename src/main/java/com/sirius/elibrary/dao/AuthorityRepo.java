package com.sirius.elibrary.dao;

import com.sirius.elibrary.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "authorities",path = "authorities")
public interface AuthorityRepo extends JpaRepository<Authority,Integer>{
    List<Authority> findByUsername(String username);
    Authority findByUsernameAndAuthority(String username,String authority);
}
