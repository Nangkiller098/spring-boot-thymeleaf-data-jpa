package com.dinsaren.springbootthymeleaf.service;

import com.dinsaren.springbootthymeleaf.models.Category;
import com.dinsaren.springbootthymeleaf.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    //Object Injection
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllData () {
        return categoryRepository.findAllByStatus("ACT");
    }

    @Override
    public void create(Category category) {
        category.setStatus("ACT");
        categoryRepository.save(category);
    }

    @Override
    public Category update(Integer id) {
        Category category=categoryRepository.findById(id).get();
        return categoryRepository.save(category);

    }

    public void delete(Integer id) {
       Category category = null;
        category=categoryRepository.getById(id);
        category.setStatus("DEL");
       categoryRepository.save(category);
    }


    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
