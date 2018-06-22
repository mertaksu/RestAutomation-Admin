package com.rest.automation.admin.services.impl;

import com.rest.automation.admin.da.api.CategoryApi;
import com.rest.automation.admin.dto.CategoryDto;
import com.rest.automation.admin.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryApi categoryApi;

    @Override
    public CategoryDto createNewCategory(CategoryDto categoryDto) {
        return categoryApi.save(categoryDto);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        return categoryApi.update(categoryDto);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryApi.delete(categoryId);
    }

    @Override
    public List<CategoryDto> categoryList() {
        return categoryApi.list();
    }
}
