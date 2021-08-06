package com.baufest.shopsrus.domain.service;

import com.baufest.shopsrus.domain.UserDomain;
import com.baufest.shopsrus.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDomain> getClients() {
        return userRepository.getClients();
    }

    public Optional<UserDomain> getClientById(int userId) {
        return userRepository.getClientById(userId);
    }

    public Optional<UserDomain> getClientByName(String name) {
        return userRepository.getClientByName(name);
    }

    public UserDomain save(UserDomain userDomain) {
        return userRepository.save(userDomain);
    }
}
