package com.rest.automation.admin.da.api;

import com.rest.automation.admin.dto.CategoryDto;

import java.util.List;

public interface CategoryApi {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

    void delete(Long categoryId);

    List<CategoryDto> list();
}
