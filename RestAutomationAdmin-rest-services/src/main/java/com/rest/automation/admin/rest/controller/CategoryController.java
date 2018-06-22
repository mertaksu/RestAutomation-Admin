package com.rest.automation.admin.rest.controller;

import com.rest.automation.admin.dto.CategoryDto;
import com.rest.automation.admin.dto.response.CategoryResponseDto;
import com.rest.automation.admin.services.CategoryService;
import com.rest.automation.commons.ResponseCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private CategoryResponseDto createNewCategory(@RequestBody CategoryDto newCategory) {
        try {
            CategoryDto categoryDto = categoryService.createNewCategory(newCategory);
            if(categoryDto==null) {
                return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc) ;
            } else {
                return new CategoryResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc,categoryDto);
            }
        } catch (Exception e) {
            return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc) ;
        }
    }

    @RequestMapping(value = "/category",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private CategoryResponseDto updateExistingCategory(@RequestBody CategoryDto newCategory) {
        try {
            CategoryDto categoryDto = categoryService.updateCategory(newCategory);
            if(categoryDto==null) {
                return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc);
            } else {
                return new CategoryResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc,categoryDto);
            }
        } catch (Exception e) {
            return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc);
        }

    }

    @RequestMapping(value = "/category/{categoryId}",method = RequestMethod.DELETE)
    private CategoryResponseDto deleteExistingCategory(@PathVariable("categoryId") Long categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
        } catch (Exception e) {
            return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc) ;
        }
        return new CategoryResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
    }

    @RequestMapping(value = "/category",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    private CategoryResponseDto listAllCategories() {
        List<CategoryDto> categoryDtoList = null;
        try {
            categoryDtoList = categoryService.categoryList();
        } catch (Exception e) {
            return new CategoryResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc) ;
        }
        return new CategoryResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc,categoryDtoList);
    }
}
