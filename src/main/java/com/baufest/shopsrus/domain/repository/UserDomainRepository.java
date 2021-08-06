package com.baufest.shopsrus.domain.repository;

import com.baufest.shopsrus.domain.UserDomain;

import java.util.List;
import java.util.Optional;

public interface UserDomainRepository {
    List<UserDomain> getClients();
    Optional<UserDomain> getClientById(int userId);
    Optional<UserDomain> getClientByName(String name);
    UserDomain save(UserDomain userDomain);
}
