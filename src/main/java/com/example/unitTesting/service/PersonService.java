package com.example.unitTesting.service;

import com.example.unitTesting.entity.Person;
import com.example.unitTesting.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public String add(Person person){
        repo.save(person);
        return "successful";
    }

    public List<Person> getAll(){
        return repo.findAll();
    }

    public Person findPerson(int id) {
        var person = repo.findById(id);
        if (person != null) {
            return person;
        } else {
//            throw new RuntimeException("Person not found with ID: " + id);
            return null;
        }
    }

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }
}
