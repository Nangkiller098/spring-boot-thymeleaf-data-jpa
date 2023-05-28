package com.dinsaren.springbootthymeleaf.repository;

import com.dinsaren.springbootthymeleaf.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByStatus(String status);

}
