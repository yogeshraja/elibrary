package com.sirius.elibrary.service;

import com.sirius.elibrary.model.ROLES;

public interface AuthorityService {
    String ADMIN="ROLE_ADMIN";
    String USER="ROLE_USER";
    void addAuthority(String userName, ROLES role);
    void removeAuthority(String userName, ROLES role);
    String getMaximumAccess(String userName);
}
