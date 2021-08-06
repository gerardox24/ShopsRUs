package com.baufest.shopsrus.web.controller;

import com.baufest.shopsrus.domain.DiscountDomain;
import com.baufest.shopsrus.domain.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @GetMapping()
    public ResponseEntity<List<DiscountDomain>> getAll() {
        return new ResponseEntity<>(discountService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DiscountDomain> getDiscountByCode(@PathVariable("code") String code) {
        return discountService.getDiscountByCode(code)
                .map(discount -> new ResponseEntity<>(discount, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<DiscountDomain> save(@RequestBody DiscountDomain discountDomain) {
        return new ResponseEntity<>(discountService.save(discountDomain), HttpStatus.CREATED);
    }
}
