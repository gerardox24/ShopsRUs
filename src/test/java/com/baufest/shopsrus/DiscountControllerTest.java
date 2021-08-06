package com.baufest.shopsrus;

import com.baufest.shopsrus.domain.DiscountDomain;
import com.baufest.shopsrus.web.controller.DiscountController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DiscountControllerTest {
    @Autowired
    private DiscountController controller;

    @Test
    @DisplayName("Should retrieve a Discount by code")
    public void getDiscountByCode_success() throws Exception {
        DiscountDomain discountTest = new DiscountDomain();
        discountTest.setId(7);
        discountTest.setAmount(10.0);

        DiscountDomain discountDomain = controller.getDiscountByCode("PERCENTAGE10").getBody();
        assertThat(discountTest.getId()).isEqualTo(discountDomain.getId());
        assertThat(discountTest.getAmount()).isEqualTo(discountDomain.getAmount());
    }

    @Test
    @DisplayName("Should register a new Discount")
    public void save_success() throws Exception {
        DiscountDomain discountDomain = new DiscountDomain();
        discountDomain.setCode("FIXED30");
        discountDomain.setAmount(30.0);
        discountDomain.setCreatedAt(LocalDateTime.now());

        ResponseEntity<DiscountDomain> response = controller.save(discountDomain);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
