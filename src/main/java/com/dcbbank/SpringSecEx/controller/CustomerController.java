package com.dcbbank.SpringSecEx.controller;

import com.dcbbank.SpringSecEx.dto.CustomerDTO;
import com.dcbbank.SpringSecEx.model.Customer;
import com.dcbbank.SpringSecEx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Allow CORS from any origin

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:5173") 
public class CustomerController {

    // Automatically inject CustomerService
    @Autowired
    private CustomerService customerService;

    // POST request to create a customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("Creating customer...");
        Customer customer = customerService.createCustomer(customerDTO);
        return ResponseEntity.ok(customer);  // HTTP 200 OK with created customer
    }

    // GET request for test
    @GetMapping
    public String hello() {
        return "Hello world";
    }
}
