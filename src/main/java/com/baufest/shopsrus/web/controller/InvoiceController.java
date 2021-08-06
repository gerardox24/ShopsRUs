package com.baufest.shopsrus.web.controller;

import com.baufest.shopsrus.domain.InvoiceDiscountDomain;
import com.baufest.shopsrus.domain.InvoiceDomain;
import com.baufest.shopsrus.domain.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDiscountDomain> getTotalInvoiceById(@PathVariable("id") int invoiceId) {
        return new ResponseEntity<>(invoiceService.getInvoiceWithDiscountById(invoiceId), HttpStatus.OK);
    }
}
