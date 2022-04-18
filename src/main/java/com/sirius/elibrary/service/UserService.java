package com.sirius.elibrary.service;

import com.sirius.elibrary.model.User;

public interface UserService {
    void addUser(User user);
    boolean checkUser(String userName);
    boolean removeUser(String userName);
}
