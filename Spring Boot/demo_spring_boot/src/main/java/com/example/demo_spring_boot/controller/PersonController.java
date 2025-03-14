package com.example.demo_spring_boot.controller;

import com.example.demo_spring_boot.entities.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class PersonController {

    @GetMapping("/listProducts")
    public List<Person> getAllProducts() {
        List<Person> list = new ArrayList<>();
        return list;
    }
}
