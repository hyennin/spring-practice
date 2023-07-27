package com.example.study_jpa.Repository;

import com.example.study_jpa.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
