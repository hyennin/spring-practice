package com.example.study_jpa.Controller;
import com.example.study_jpa.Entity.Person;
import com.example.study_jpa.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("test1")
    public void test1() {
        System.out.println("\nfindByEmail(\"kim@hello.com\") ------------------------------");
        System.out.println(personRepository.findByEmail("kim@hello.com").get());

        System.out.println("\nfindByAgeGreaterThan(40) ------------------------------");
        for(Person p : personRepository.findByAgeGreaterThan(40)) {
            System.out.println(p);
        }

        System.out.println("\nfindByAgeGreaterThanEqual(40) ------------------------------");
        for(Person p : personRepository.findByAgeGreaterThanEqual(40)) {
            System.out.println(p);
        }

        System.out.println("\nfindByAgeGreaterThanEqual(40) ------------------------------");
        for(Person p : personRepository.findByAgeGreaterThanEqual(40)) {
            System.out.println(p);
        }

        System.out.println("\nfindByAgeBetween(40, 50) ------------------------------");
        for(Person p : personRepository.findByAgeBetween(40, 50)) {
            System.out.println(p);
        }

        System.out.println("\nfindByAgeBetween(20, 40) ------------------------------");
        for(Person p : personRepository.findByAgeBetween(20, 40)) {
            System.out.println(p);
        }

        System.out.println("\nfindByEmailEndingWith(\"hello.com\") ------------------------------");
        for(Person p : personRepository.findByEmailEndingWith("hello.com")) {
            System.out.println(p);
        }

        System.out.println("\nfindByFirstNameAndLastName(\"철수\", \"김\") ------------------------------");
        for(Person p : personRepository.findByFirstNameAndLastName("철수", "김")) {
            System.out.println(p);
        }
    }

    @GetMapping("test2")
    public void test2() {
        System.out.println("\nmyFindByEmail(\"kim@hello.com\") ------------------------------");
        System.out.println(personRepository.myFindByEmail("kim@hello.com").get());
    }
}