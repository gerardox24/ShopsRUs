package com.baufest.shopsrus.domain;

import java.util.Optional;

public class InvoiceDiscountDomain {
    private Optional<InvoiceDomain> invoice;
    private Optional<DiscountDomain> discount;
    private Double total;

    public Optional<InvoiceDomain> getInvoice() {
        return invoice;
    }

    public void setInvoice(Optional<InvoiceDomain> invoice) {
        this.invoice = invoice;
    }

    public Optional<DiscountDomain> getDiscount() {
        return discount;
    }

    public void setDiscount(Optional<DiscountDomain> discount) {
        this.discount = discount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
