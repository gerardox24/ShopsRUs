package com.baufest.shopsrus.persistence.repository;

import com.baufest.shopsrus.domain.DiscountDomain;
import com.baufest.shopsrus.domain.repository.DiscountDomainRepository;
import com.baufest.shopsrus.persistence.crud.DiscountCrudRepository;
import com.baufest.shopsrus.persistence.entity.Discount;
import com.baufest.shopsrus.persistence.mapper.DiscountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DiscountRepository implements DiscountDomainRepository {
    @Autowired
    private DiscountCrudRepository discountCrudRepository;

    @Autowired
    private DiscountMapper mapper;

    @Override
    public List<DiscountDomain> getAll() {
        List<Discount> discounts = (List<Discount>) discountCrudRepository.findAll();
        return mapper.toDiscountsDomain(discounts);
    }

    @Override
    public Optional<DiscountDomain> getDiscountByCode(String code) {
        return discountCrudRepository.findByCode(code)
                .map(discount -> mapper.toDiscountDomain(discount));
    }

    @Override
    public DiscountDomain save(DiscountDomain discountDomain) {
        Discount discount = mapper.toDiscount(discountDomain);
        return mapper.toDiscountDomain(discountCrudRepository.save(discount));
    }
}
