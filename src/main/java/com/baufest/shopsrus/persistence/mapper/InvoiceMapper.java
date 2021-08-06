package com.baufest.shopsrus.persistence.mapper;

import com.baufest.shopsrus.domain.InvoiceDomain;
import com.baufest.shopsrus.persistence.entity.Invoice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "currency", target = "currency"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt")
    })
    InvoiceDomain toInvoiceDomain(Invoice invoice);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "client", ignore = true),
            @Mapping(target = "products", ignore = true)
    })
    Invoice toInvoice(InvoiceDomain invoiceDomain);
}
