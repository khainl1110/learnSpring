package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/msg")
    public String getMessage(){
        return "Hello";
    }
}
