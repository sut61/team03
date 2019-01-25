package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;
import com.sut.se.g03.entity.*;
import com.sut.se.g03.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
    @Autowired private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/Customers")
    public Collection<Customer> customers() {
        return customerRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/Customer/user/{username}")
    public Customer Customers (@PathVariable String username) {
        Customer findCustomer = customerRepository.findByUsername(username);
        return findCustomer;
    }
    @PostMapping("/Customer/add/{username}/{customerName}/{tel}/{email}")
    public Customer newCustomer(@PathVariable String username ,@PathVariable String customerName, @PathVariable String tel, @PathVariable String email){
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setCustomerName(customerName);
        customer.setTel(tel);
        customer.setEmail(email);
        return customerRepository.save(customer);
    }
}
