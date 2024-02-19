package com.example.controller;

import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomers());
    }
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }
}
