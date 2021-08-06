package com.baufest.shopsrus.domain.service;

import com.baufest.shopsrus.domain.DiscountDomain;
import com.baufest.shopsrus.domain.InvoiceDiscountDomain;
import com.baufest.shopsrus.domain.InvoiceDomain;
import com.baufest.shopsrus.domain.UserDomain;
import com.baufest.shopsrus.domain.repository.DiscountDomainRepository;
import com.baufest.shopsrus.domain.repository.InvoiceDomainRepository;
import com.baufest.shopsrus.domain.repository.UserDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceDomainRepository invoiceDomainRepository;

    @Autowired
    private DiscountDomainRepository discountDomainRepository;

    @Autowired
    private UserDomainRepository userDomainRepository;

    public InvoiceDiscountDomain getInvoiceWithDiscountById(int invoiceId) {
        Optional<InvoiceDomain> invoice = invoiceDomainRepository.getInvoice(invoiceId);
        Optional<UserDomain> user = userDomainRepository.getClientById(invoice.get().getClientId());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime userCreationDate = user.get().getCreatedAt();
        long diffYears = userCreationDate.until(now, ChronoUnit.YEARS);

        // Applying discounts
        if (user.get().getUserTypeId() == 1) {
            Optional<DiscountDomain> discount = discountDomainRepository.getDiscountByCode("PERCENTAGE30");
            Double totalInvoice = (invoice.get().getAmount() * (100 - discount.get().getAmount())) / 100;

            InvoiceDiscountDomain invoiceDiscountDomain = new InvoiceDiscountDomain();
            invoiceDiscountDomain.setInvoice(invoice);
            invoiceDiscountDomain.setDiscount(discount);
            invoiceDiscountDomain.setTotal(totalInvoice);
            return invoiceDiscountDomain;
        }

        if(user.get().getAffiliated()) {
            Optional<DiscountDomain> discount = discountDomainRepository.getDiscountByCode("PERCENTAGE10");
            Double totalInvoice = (invoice.get().getAmount() * (100 - discount.get().getAmount())) / 100;

            InvoiceDiscountDomain invoiceDiscountDomain = new InvoiceDiscountDomain();
            invoiceDiscountDomain.setInvoice(invoice);
            invoiceDiscountDomain.setDiscount(discount);
            invoiceDiscountDomain.setTotal(totalInvoice);
            return invoiceDiscountDomain;
        }

        if (diffYears >= 2 ) {
            Optional<DiscountDomain> discount = discountDomainRepository.getDiscountByCode("PERCENTAGE5");
            Double totalInvoice = (invoice.get().getAmount() * (100 - discount.get().getAmount())) / 100;

            InvoiceDiscountDomain invoiceDiscountDomain = new InvoiceDiscountDomain();
            invoiceDiscountDomain.setInvoice(invoice);
            invoiceDiscountDomain.setDiscount(discount);
            invoiceDiscountDomain.setTotal(totalInvoice);
            return invoiceDiscountDomain;
        }

        if (invoice.get().getAmount() > 100) {
            Optional<DiscountDomain> discount = discountDomainRepository.getDiscountByCode("FIXED5");
            int totalDiscount = ((int)(invoice.get().getAmount() / 100)) * 5;
            Double totalInvoice = invoice.get().getAmount() - totalDiscount;

            InvoiceDiscountDomain invoiceDiscountDomain = new InvoiceDiscountDomain();
            invoiceDiscountDomain.setInvoice(invoice);
            invoiceDiscountDomain.setDiscount(discount);
            invoiceDiscountDomain.setTotal(totalInvoice);
            return invoiceDiscountDomain;
        }

        return null;
    }
}
