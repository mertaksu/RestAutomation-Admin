package com.rest.automation.admin.rest.controller;

import com.rest.automation.admin.dto.CategoryDto;
import com.rest.automation.admin.dto.response.CategoryResponseDto;
import com.rest.automation.admin.services.CategoryService;
import com.rest.automation.commons.ResponseCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private CategoryResponseDto createNewCategory(CategoryDto newCategory) {
        CategoryDto categoryDto = categoryService.createNewCategory(newCategory);
        if(categoryDto==null) {
            return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc) ;
        } else {
            return new CategoryResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc,categoryDto);
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private CategoryResponseDto updateExistingCategory(CategoryDto newCategory) {
        CategoryDto categoryDto = categoryService.updateCategory(newCategory);
        if(categoryDto==null) {
            return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc) ;
        } else {
            return new CategoryResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc,categoryDto);
        }

    }

    @RequestMapping(value = "/{categoryId}",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private CategoryResponseDto deleteExistingCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
