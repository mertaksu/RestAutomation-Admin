package com.rest.automation.admin.services;

import com.rest.automation.admin.dto.CategoryDto;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface CategoryService {
    CategoryDto createNewCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto);

    void deleteCategory(Long categoryId);
}
