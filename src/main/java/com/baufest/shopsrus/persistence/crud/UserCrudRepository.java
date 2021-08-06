package com.baufest.shopsrus.persistence.crud;

import com.baufest.shopsrus.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM users u WHERE u.user_type_id = ?1", nativeQuery = true)
    List<User> getClients(Integer userTypeId);

    @Query(value = "SELECT * FROM users u WHERE u.name LIKE ?1", nativeQuery = true)
    Optional<User> getClientByName(String name);
}
