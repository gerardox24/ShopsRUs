package com.baufest.shopsrus.domain.service;

import com.baufest.shopsrus.domain.DiscountDomain;
import com.baufest.shopsrus.domain.repository.DiscountDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {
    @Autowired
    private DiscountDomainRepository discountDomainRepository;

    public List<DiscountDomain> getAll() {
        return discountDomainRepository.getAll();
    }

    public Optional<DiscountDomain> getDiscountByCode(String code) {
        return discountDomainRepository.getDiscountByCode(code);
    }

    public DiscountDomain save(DiscountDomain discountDomain) {
        return discountDomainRepository.save(discountDomain);
    }
}
