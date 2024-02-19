package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Employee;
import com.example.exception.ResourceFoundException;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        Optional<Customer> cast = customerRepository.findByEmail(customer.getEmail());
        if(cast.isPresent()) {
            throw new ResourceFoundException(customer.getEmail() + "already registered");
        }
        long id = new Random().nextLong();
        customer.setId(id);
        return customerRepository.save(customer);
    }
}
