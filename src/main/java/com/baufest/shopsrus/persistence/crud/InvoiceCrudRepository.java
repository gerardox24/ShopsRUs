package com.baufest.shopsrus.persistence.crud;

import com.baufest.shopsrus.persistence.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceCrudRepository extends CrudRepository<Invoice, Integer> {
}
