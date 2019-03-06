package com.granovskiy.controller;

import com.granovskiy.web.Request;
import com.granovskiy.web.ViewModel;
import com.granovskiy.service.CategoryService;

public class GetAllCategoriesController implements Controller {

    private final CategoryService categoryService;

    public GetAllCategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request req) {
        return ViewModel.of("categories").withAttribute("categories", categoryService.getAll());
    }
}