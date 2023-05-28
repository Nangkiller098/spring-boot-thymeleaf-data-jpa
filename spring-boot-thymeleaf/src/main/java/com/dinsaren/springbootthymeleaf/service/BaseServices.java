package com.dinsaren.springbootthymeleaf.service;

import com.dinsaren.springbootthymeleaf.models.Category;

import java.util.List;

public interface BaseServices<T>
{
    List<T> findAllData();
    void create(T req);
    T update(T t,Integer id);
    void delete(Integer id);
    Category getById(Integer id);

}
