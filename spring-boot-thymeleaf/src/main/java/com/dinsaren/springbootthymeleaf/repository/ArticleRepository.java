package com.dinsaren.springbootthymeleaf.repository;

import com.dinsaren.springbootthymeleaf.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>
{
    List<Article> findAllByStatus(String status);
}
