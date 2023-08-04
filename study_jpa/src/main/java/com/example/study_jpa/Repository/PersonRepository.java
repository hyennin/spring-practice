package com.example.study_jpa.Repository;

import com.example.study_jpa.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    public Optional<Person> findByEmail(String email);
    public List<Person> findByFirstNameAndLastName(String first, String last);
    public List<Person> findByAgeBetween(Integer s, Integer e);
    public List<Person> findByEmailEndingWith(String criteria);
    public List<Person> findByAgeGreaterThan(Integer criteria);
    public List<Person> findByAgeGreaterThanEqual(Integer criteria);
    @Query("SELECT p FROM Person p WHERE p.email = ?1")
    public Optional<Person> myFindByEmail(String email);
}