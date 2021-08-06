package com.baufest.shopsrus;

import com.baufest.shopsrus.domain.UserDomain;
import com.baufest.shopsrus.domain.repository.UserDomainRepository;
import com.baufest.shopsrus.web.controller.ClientController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ClientControllerTest {
    @Autowired
    private ClientController controller;

    @Test
    @DisplayName("Should retrieve Client by Id")
    public void getClientById_success() throws Exception {
        UserDomain userTest = new UserDomain();
        userTest.setId(1);
        userTest.setLastname("RAMOS");
        userTest.setName("JOHNNY");

        UserDomain userDomain = controller.getClientById(1).getBody();
        assertThat(userTest.getId()).isEqualTo(userDomain.getId());
        assertThat(userTest.getLastname()).isEqualTo(userDomain.getLastname());
        assertThat(userTest.getName()).isEqualTo(userDomain.getName());
    }

    @Test
    @DisplayName("Should retrieve Client by Name")
    public void getClientByName_success() throws Exception {
        UserDomain userTest = new UserDomain();
        userTest.setId(4);
        userTest.setLastname("CUADROS");
        userTest.setName("MIGUEL");

        UserDomain userDomain = controller.getClientByName("MIGUEL").getBody();
        assertThat(userTest.getLastname()).isEqualTo(userDomain.getLastname());
        assertThat(userTest.getId()).isEqualTo(userDomain.getId());
    }

    @Test
    @DisplayName("Should register a new Client")
    public void save_success() throws Exception {
        UserDomain userDomain = new UserDomain();
        userDomain.setUserTypeId(2);
        userDomain.setLastname("MENDOZA");
        userDomain.setName("JORGE");
        userDomain.setDocumentType("DNI");
        userDomain.setDocument("12345678");
        userDomain.setAffiliated(true);
        userDomain.setCreatedAt(LocalDateTime.now());

        ResponseEntity<UserDomain> response = controller.save(userDomain);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
