package com.sirius.elibrary.service;

import com.sirius.elibrary.dao.AuthorityBean;
import com.sirius.elibrary.dao.AuthorityRepo;
import com.sirius.elibrary.dao.UserBean;
import com.sirius.elibrary.model.Authority;
import com.sirius.elibrary.model.ROLES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    AuthorityRepo authRepo;

    @Override
    public void addAuthority(String userName, ROLES role) {
        Optional<Authority> authority= Optional.ofNullable(authRepo.findByUsernameAndAuthority(userName, role.name()));
        authRepo.save(authority.orElse(new Authority(userName, role.name(), UserBean.getInstance().findUserByUsername(userName))));
    }

    @Override
    public void removeAuthority(String userName, ROLES role) {
        Optional<Authority> authority= Optional.ofNullable(authRepo.findByUsernameAndAuthority(userName, role.name()));
        authority.ifPresent(authRepo::delete);
    }

    @Override
    public String getMaximumAccess(String userName) {
        List<Authority> authorities=authRepo.findByUsername(userName);
        Optional<Integer> maxAccess= authorities.stream()
                .map(Authority::getAuthority)
                .map(authority -> ROLES.valueOf(authority).ordinal()).max(Comparator.naturalOrder());
        return maxAccess.map(integer -> ROLES.values()[integer].name()).orElse(null);
    }
}
