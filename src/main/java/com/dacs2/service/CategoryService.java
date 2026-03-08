package com.dacs2.service;

import com.dacs2.model.Category;

import java.util.List;


public interface CategoryService {

    Category saveCategory(Category category);

    Boolean existCategory(String name);

    List<Category> getAllCategory();

    void deleteCategory(Long id);

    Category getCategoryById(Long id);

    List<Category> getCategoryByIsActive();

}
