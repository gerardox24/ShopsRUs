package com.baufest.shopsrus.domain.repository;

import com.baufest.shopsrus.domain.InvoiceDomain;

import java.util.Optional;

public interface InvoiceDomainRepository {
    Optional<InvoiceDomain> getInvoice(int invoiceId);
}
