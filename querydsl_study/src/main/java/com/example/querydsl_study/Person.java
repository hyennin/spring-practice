package com.example.querydsl_study;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    @NonNull
    private String firstName;

    @Column(nullable=false)
    @NonNull
    private String lastName;

    @Column(nullable=false)
    @NonNull
    private Integer age;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date birthDay;

    @Column(unique=true)
    @Nullable
    private String email;
}