package com.rest.automation.admin.da.api;

import com.rest.automation.admin.dto.CategoryDto;

public interface CategoryApi {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

    void delete(Long categoryId);
}
