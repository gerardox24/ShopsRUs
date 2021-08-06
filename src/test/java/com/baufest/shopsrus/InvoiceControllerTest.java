package com.baufest.shopsrus;

import com.baufest.shopsrus.domain.DiscountDomain;
import com.baufest.shopsrus.domain.InvoiceDiscountDomain;
import com.baufest.shopsrus.domain.InvoiceDomain;
import com.baufest.shopsrus.web.controller.InvoiceController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InvoiceControllerTest {
    @Autowired
    private InvoiceController controller;

    @Test
    @DisplayName("Should retrieve Total amount of an Invoice by ID")
    public void getTotalInvoiceById_success() throws Exception {
        InvoiceDiscountDomain invoiceDiscountTest = new InvoiceDiscountDomain();
        InvoiceDomain invoiceTest = new InvoiceDomain();
        DiscountDomain discountTest = new DiscountDomain();

        invoiceTest.setId(3);
        invoiceTest.setAmount(900.0);
        invoiceTest.setCurrency("USD");

        discountTest.setId(11);
        discountTest.setCode("PERCENTAGE30");
        discountTest.setAmount(30.0);

        invoiceDiscountTest.setInvoice(Optional.of(invoiceTest));
        invoiceDiscountTest.setDiscount(Optional.of(discountTest));

        invoiceDiscountTest.setTotal(630.0);
        int invoiceTestId = invoiceDiscountTest.getInvoice().get().getId();
        int discountTestId = invoiceDiscountTest.getDiscount().get().getId();
        Double totalTest = invoiceDiscountTest.getTotal();

        ResponseEntity<InvoiceDiscountDomain> invoiceDiscountDomain = controller.getTotalInvoiceById(3);
        int invoiceId = invoiceDiscountDomain.getBody().getInvoice().get().getId();
        int discountId = invoiceDiscountDomain.getBody().getDiscount().get().getId();
        Double total = invoiceDiscountDomain.getBody().getTotal();

        assertThat(invoiceDiscountDomain.getBody().getTotal()).isEqualTo(invoiceDiscountTest.getTotal());
        assertThat(invoiceId).isEqualTo(invoiceTestId);
        assertThat(discountId).isEqualTo(discountTestId);
        assertThat(totalTest).isEqualTo(total);
        assertThat(invoiceDiscountDomain.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
