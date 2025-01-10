package com.example.demo;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        /*


        generate JPA advanced mappings and CRUD API layer for Customer and Purchase History, with Customer can have multiple Purchase History
         */

        SpringApplication.run(DemoApplication.class, args);
    }
}
