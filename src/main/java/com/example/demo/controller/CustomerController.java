//package com.example.demo.controller;
//
//import com.example.demo.entity.Customer;
//import com.example.demo.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//    @GetMapping("/addCustomer")
//    public String testAPI() {
//        customerRepository.save(new Customer("Yamete", "Kimochi"));
//        return "Add customer";
//    }
//
//    @PostMapping()
//    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
//        customerRepository.save(customer);
//        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
//    }
//
//    @GetMapping("/viewAll")
//    public Iterable<Customer> viewCustomer() {
//        return customerRepository.findAll();
//    }
//}
