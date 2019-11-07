package com.lambdaschool.demo.controllers;

import com.lambdaschool.demo.models.Customers;
import com.lambdaschool.demo.services.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

private CustomersService customersService;
    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> getCustomerById(@PathVariable long id) {
        Customers myCustomer = customersService.findCustomersById(id);
        return new ResponseEntity<>(myCustomer, HttpStatus.OK);
    }

    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> getAllCustomers() {
        List<Customers> myCustomers = customersService.findAllCustomers();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "/namelike/{nameLike}", produces = {"application/json"})
    public ResponseEntity<?> getCustomersByNameLike(@PathVariable String nameLike) {
        List<Customers> myCustomers = customersService.findByNameLike(nameLike);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }


}
