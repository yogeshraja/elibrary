package com.sirius.elibrary.service;

import com.sirius.elibrary.dao.AuthorityRepo;
import com.sirius.elibrary.dao.UserRepo;
import com.sirius.elibrary.model.MyUserDetails;
import com.sirius.elibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthorityRepo authorityRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user= Optional.ofNullable(userRepo.findUserByUsername(username));
        user.orElseThrow(()->new UsernameNotFoundException("Not found: "+username));
        return  user.map(MyUserDetails::new).get();
    }
}
