package com.sirius.elibrary.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityBean {
    private static AuthorityRepo authorityRepository;

    @Autowired
    public AuthorityBean(AuthorityRepo authorityRepo) {
        authorityRepository = authorityRepo;
    }

    public static AuthorityRepo getInstance() {
        return authorityRepository;
    }
}
