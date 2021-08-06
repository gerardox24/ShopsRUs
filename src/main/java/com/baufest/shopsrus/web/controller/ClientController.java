package com.baufest.shopsrus.web.controller;

import com.baufest.shopsrus.domain.UserDomain;
import com.baufest.shopsrus.domain.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private UserService userService;

    @GetMapping()
    @ApiOperation("Get all clients")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<UserDomain>> getClients() {
        return new ResponseEntity<>(userService.getClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a client with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Client NOT FOUND")
    })
    public ResponseEntity<UserDomain> getClientById(@PathVariable("id") int userId) {
        return userService.getClientById(userId)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    @ApiOperation("Search a client by NAME")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Client NOT FOUND")
    })
    public ResponseEntity<UserDomain> getClientByName(@PathVariable("name") String name) {
        return userService.getClientByName(name)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ApiOperation("Create new client")
    @ApiResponse(code = 201, message = "Client CREATED")
    public ResponseEntity<UserDomain> save(@RequestBody UserDomain userDomain) {
        return new ResponseEntity<>(userService.save(userDomain), HttpStatus.CREATED);
    }
}
