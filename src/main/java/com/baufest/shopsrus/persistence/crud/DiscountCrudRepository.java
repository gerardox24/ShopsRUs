package com.baufest.shopsrus.persistence.crud;

import com.baufest.shopsrus.persistence.entity.Discount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DiscountCrudRepository extends CrudRepository<Discount, Integer> {
    Optional<Discount> findByCode(String code);
}
