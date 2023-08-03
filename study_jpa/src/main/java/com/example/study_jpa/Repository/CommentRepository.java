package com.example.study_jpa.Repository;

import com.example.study_jpa.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {}