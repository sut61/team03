package com.sut.se.g03.controller;

import org.springframework.web.bind.annotation.*;
import com.sut.se.g03.entity.CustomerFix;
import com.sut.se.g03.repository.CustomerFixRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerFixController {
    @Autowired private final CustomerFixRepository customerFixRepository;

    CustomerFixController(CustomerFixRepository customerFixRepository) {
        this.customerFixRepository = customerFixRepository;
    }
    @GetMapping("/CustomerFixes")
    public Collection<CustomerFix> customerFixes() {
        return customerFixRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @PostMapping("/CustomerFix/add/{customerFixName}/{tel}/{email}")
    public CustomerFix newCustomer(@PathVariable String customerFixName, @PathVariable String tel, @PathVariable String email){
        CustomerFix customerFix = new CustomerFix();
        customerFix.setCustomerFixName(customerFixName);
        customerFix.setTel(tel);
        customerFix.setEmail(email);
        return customerFixRepository.save(customerFix);
    }
}
