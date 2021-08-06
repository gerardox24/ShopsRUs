package com.baufest.shopsrus.persistence.mapper;

import com.baufest.shopsrus.domain.DiscountDomain;
import com.baufest.shopsrus.persistence.entity.Discount;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt"),
    })
    DiscountDomain toDiscountDomain(Discount discount);
    List<DiscountDomain> toDiscountsDomain(List<Discount> discounts);

    @InheritInverseConfiguration
    Discount toDiscount(DiscountDomain discountDomain);
}
