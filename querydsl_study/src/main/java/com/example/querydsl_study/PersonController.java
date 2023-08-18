package com.example.querydsl_study;

import com.querydsl.jpa.impl.*;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PersonController {
    @PersistenceContext
    private EntityManager em;

    @GetMapping("querydsl_test")
    public void querydslTest() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        // Q로 시작하는 QueryDSL 전용의 엔티티 클래스를 사용함을 유의
        QPerson person = QPerson.person;

        List<Person> result;
        // SQL과 비슷한 느낌의 메서드 체인을 이용하여 쿼리문 수행
        result = queryFactory.selectFrom(person).where(person.lastName.eq("김")).fetch();
        // result = queryFactory.selectFrom(person).where(person.lastName.eq("김"), person.email.like("%hello.com")).fetch();
        // result = queryFactory.selectFrom(person).where(person.lastName.eq("김"), person.age.gt(40), person.email.like("%hello.com")).fetch();
        // result = queryFactory.selectFrom(person).where(person.age.between(20, 40)).fetch();

    /*
    JPAQuery<Person> q = queryFactory.selectFrom(person);

    // 추가적으로 predicate 붙일 수 있음
    // (즉, 조건문에 따라서 동적으로 where 조건을 더 추가하는 것이 가능함)
    q = q.where(person.lastName.eq("김"));
    q = q.where(person.age.gt(40));
    q = q.where(person.email.like("%hello.com"));

    result = q.fetch();
    */

        for(Person p : result) {
            System.out.println(p);
        }
    }
}
