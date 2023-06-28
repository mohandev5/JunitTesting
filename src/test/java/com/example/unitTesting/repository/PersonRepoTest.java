package com.example.unitTesting.repository;

import com.example.unitTesting.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRepoTest {
    @Autowired
    private PersonRepo personRepo;

    @Test
    void findById( ) {
        int id = 1;
        Person person = new Person(1, "mohan", "srikakulam", "India");
        personRepo.save(person);

        Optional<Person> expectedResult = Optional.of(person);
        Optional<Person> actualResult = Optional.ofNullable(personRepo.findById(id));

        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearing down");
        personRepo.deleteAll();
    }
}