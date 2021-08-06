package com.baufest.shopsrus.persistence.mapper;

import com.baufest.shopsrus.domain.UserDomain;
import com.baufest.shopsrus.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "userTypeId", target = "userTypeId"),
            @Mapping(source = "lastname", target = "lastname"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "documentType", target = "documentType"),
            @Mapping(source = "document", target = "document"),
            @Mapping(source = "affiliated", target = "affiliated"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt")
    })
    UserDomain toUserDomain(User user);
    List<UserDomain> toUsersDomain(List<User> users);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "userType", ignore = true),
            @Mapping(target = "invoices", ignore = true)
    })
    User toUser(UserDomain userDomain);
}
