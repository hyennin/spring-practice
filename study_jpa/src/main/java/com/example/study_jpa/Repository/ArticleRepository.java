package com.example.study_jpa.Repository;

import com.example.study_jpa.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {}
