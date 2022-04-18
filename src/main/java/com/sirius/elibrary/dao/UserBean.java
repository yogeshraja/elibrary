package com.sirius.elibrary.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBean {
    private static UserRepo userRepository;

    @Autowired
    public UserBean(UserRepo userRepo) {
        userRepository = userRepo;
    }

    public static UserRepo getInstance() {
        return userRepository;
    }
}
