package com.baufest.shopsrus.persistence.mapper;

import com.baufest.shopsrus.domain.UserTypeDomain;
import com.baufest.shopsrus.persistence.entity.UserType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserTypeMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt")
    })
    UserTypeDomain toUserTypeDomain(UserType userType);

    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    UserType toUserType(UserTypeDomain userTypeDomain);
}
