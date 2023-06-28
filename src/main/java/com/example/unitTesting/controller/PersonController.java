package com.example.unitTesting.controller;

import com.example.unitTesting.entity.Person;
import com.example.unitTesting.service.PersonService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public String insertingData(@RequestBody Person person){
        return personService.add(person);
    }

    @GetMapping("/persons")
    public List<Person> findAll(){
        return personService.getAll();
    }

    @GetMapping("/list/{id}")
    public Person find(@PathVariable ("id") int id){
        return personService.findPerson(id);
    }
}
