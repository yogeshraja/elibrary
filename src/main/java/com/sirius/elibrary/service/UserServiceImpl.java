package com.sirius.elibrary.service;

import com.sirius.elibrary.dao.UserBean;
import com.sirius.elibrary.dao.UserRepo;
import com.sirius.elibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public boolean checkUser(String userName) {
        Optional<User> user= Optional.ofNullable(userRepo.findUserByUsername(userName));
        return user.isPresent();
    }

    @Override
    public boolean removeUser(String userName) {
        Optional<User> user= Optional.ofNullable(userRepo.findUserByUsername(userName));
        if(user.isPresent()){
            userRepo.delete(user.get());
            return true;
        }
        else {
            return false;
        }
    }
}
