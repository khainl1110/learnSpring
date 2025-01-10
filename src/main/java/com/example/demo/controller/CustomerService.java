package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.PurchaseHistory;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    // Create a new customer with purchase history
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Create a new purchase for a customer
    public PurchaseHistory createPurchase(Long customerId, PurchaseHistory purchaseHistory) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            purchaseHistory.setCustomer(customer.get());
            return purchaseHistoryRepository.save(purchaseHistory);
        }
        return null;
    }

    // Get all customers
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Get all purchases for a customer
    public List<PurchaseHistory> getPurchasesByCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return (List<PurchaseHistory>) customer.map(Customer::getPurchaseHistories).orElse(null);
    }

    // Update purchase history (if needed)
    public PurchaseHistory updatePurchaseHistory(Long purchaseId, PurchaseHistory updatedPurchase) {
        Optional<PurchaseHistory> existingPurchase = purchaseHistoryRepository.findById(purchaseId);
        if (existingPurchase.isPresent()) {
            PurchaseHistory purchaseHistory = existingPurchase.get();
            purchaseHistory.setItem(updatedPurchase.getItem());
            purchaseHistory.setQuantity(updatedPurchase.getQuantity());
            purchaseHistory.setPrice(updatedPurchase.getPrice());
            purchaseHistory.setPurchaseDate(updatedPurchase.getPurchaseDate());
            return purchaseHistoryRepository.save(purchaseHistory);
        }
        return null;
    }
}
