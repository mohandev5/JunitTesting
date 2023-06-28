package com.example.unitTesting.repository;

import com.example.unitTesting.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Integer> {

    public Person findById(int id);
}
