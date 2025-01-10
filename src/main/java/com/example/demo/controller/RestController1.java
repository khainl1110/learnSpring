package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.PurchaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class RestController1 {

    @Autowired
    private CustomerService customerService;

    // Get all customers
    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    // Get all purchase histories for a customer
    @GetMapping("/{customerId}/purchases")
    public ResponseEntity<List<PurchaseHistory>> getPurchasesByCustomer(@PathVariable Long customerId) {
        List<PurchaseHistory> purchases = customerService.getPurchasesByCustomer(customerId);
        return purchases != null ? ResponseEntity.ok(purchases) : ResponseEntity.notFound().build();
    }

    // Create a new purchase for a customer
    @PostMapping("/{customerId}/purchases")
    public ResponseEntity<PurchaseHistory> createPurchase(@PathVariable Long customerId, @RequestBody PurchaseHistory purchaseHistory) {
        PurchaseHistory createdPurchase = customerService.createPurchase(customerId, purchaseHistory);
        return createdPurchase != null ? ResponseEntity.ok(createdPurchase) : ResponseEntity.badRequest().build();
    }

    // Update a purchase history
    @PutMapping("/purchases/{purchaseId}")
    public ResponseEntity<PurchaseHistory> updatePurchaseHistory(@PathVariable Long purchaseId, @RequestBody PurchaseHistory updatedPurchase) {
        PurchaseHistory purchase = customerService.updatePurchaseHistory(purchaseId, updatedPurchase);
        return purchase != null ? ResponseEntity.ok(purchase) : ResponseEntity.notFound().build();
    }
}

