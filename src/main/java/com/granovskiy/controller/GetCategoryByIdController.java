package com.granovskiy.controller;

import com.granovskiy.web.Request;
import com.granovskiy.web.ViewModel;
import com.granovskiy.service.CategoryService;

import static java.util.Collections.emptyList;

public class GetCategoryByIdController implements Controller {

    private final CategoryService categoryService;

    public GetCategoryByIdController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request req) {
        String param = req.getParam("c_id")[0];
        Long id = Long.parseLong(param);
        return categoryService.getById(id)
                .map(c -> ViewModel.of("category").withAttribute("category", c))
                .orElseGet(() -> ViewModel.of("category").withAttribute("category", emptyList()));
    }
}
