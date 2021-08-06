package com.baufest.shopsrus.persistence.repository;

import com.baufest.shopsrus.domain.InvoiceDomain;
import com.baufest.shopsrus.domain.repository.InvoiceDomainRepository;
import com.baufest.shopsrus.persistence.crud.InvoiceCrudRepository;
import com.baufest.shopsrus.persistence.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InvoiceRepository implements InvoiceDomainRepository {
    @Autowired
    private InvoiceCrudRepository invoiceCrudRepository;

    @Autowired
    private InvoiceMapper mapper;

    @Override
    public Optional<InvoiceDomain> getInvoice(int invoiceId) {
        return invoiceCrudRepository.findById(invoiceId)
                .map(invoice -> mapper.toInvoiceDomain(invoice));
    }
}
