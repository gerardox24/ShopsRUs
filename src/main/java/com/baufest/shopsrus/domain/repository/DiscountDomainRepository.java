package com.baufest.shopsrus.domain.repository;

import com.baufest.shopsrus.domain.DiscountDomain;

import java.util.List;
import java.util.Optional;

public interface DiscountDomainRepository {
    List<DiscountDomain> getAll();
    Optional<DiscountDomain> getDiscountByCode(String code);
    DiscountDomain save(DiscountDomain discountDomain);
}
