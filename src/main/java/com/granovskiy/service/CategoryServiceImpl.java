package com.granovskiy.service;

import com.granovskiy.dao.CategoryDao;
import com.granovskiy.model.Category;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Optional<Category> getById(Long id) {
        return null;
    }
}
