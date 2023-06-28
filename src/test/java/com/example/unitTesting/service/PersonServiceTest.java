package com.example.unitTesting.service;

import com.example.unitTesting.repository.PersonRepo;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepo personRepo;

    @Autowired
    private PersonService personService;
  //  AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
      this.personService = new PersonService(this.personRepo);
    }

//    @AfterEach
//    void tearDown() {
//        try {
//            this.autoCloseable.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


    // with @ExtendWith(MockitoExtension.class) gives autoClosable class directly
    @Test
    void getAll() {
      personService.getAll();

      verify(personRepo).findAll();
    }
}