package com.baufest.shopsrus.persistence.repository;

import com.baufest.shopsrus.domain.UserDomain;
import com.baufest.shopsrus.domain.repository.UserDomainRepository;
import com.baufest.shopsrus.persistence.crud.UserCrudRepository;
import com.baufest.shopsrus.persistence.entity.User;
import com.baufest.shopsrus.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserDomainRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDomain> getClients() {
        List<User> clients = (List<User>) userCrudRepository.getClients(2);
        return mapper.toUsersDomain(clients);
    }

    @Override
    public Optional<UserDomain> getClientById(int userId) {
        return userCrudRepository.findById(userId).map(user -> mapper.toUserDomain(user));
    }

    @Override
    public Optional<UserDomain> getClientByName(String name) {
        return userCrudRepository.getClientByName(name).map(user -> mapper.toUserDomain(user));
    }

    @Override
    public UserDomain save(UserDomain userDomain) {
        User user = mapper.toUser(userDomain);
        return mapper.toUserDomain(userCrudRepository.save(user));
    }
}
