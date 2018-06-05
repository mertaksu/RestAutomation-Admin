package com.rest.automation.admin.da.api.impl;

import com.rest.automation.admin.da.api.CategoryApi;
import com.rest.automation.admin.da.domain.CategoryDomain;
import com.rest.automation.admin.da.mapper.impl.CategoryMapper;
import com.rest.automation.admin.da.repository.CategoryRepository;
import com.rest.automation.admin.dto.CategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryApiImpl implements CategoryApi{

    CategoryRepository categoryRepository;

    CategoryMapper mapper;

    CategoryApiImpl(CategoryRepository repository,CategoryMapper mapper){
        this.categoryRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        CategoryDto response;
        try {
            long startDate = System.currentTimeMillis();
            CategoryDomain domain = mapper.dtoToDomain(categoryDto);
            CategoryDomain savedCategory = categoryRepository.save(domain);
            response = mapper.domainToDto(savedCategory);
            log.info("New Category saved with id {} in {} ms.",savedCategory.getCategoryId(),System.currentTimeMillis()-startDate);
        } catch (Exception e) {
            log.error("Exception occured while saving new category ",e);
            return null;
        }
        return response;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        CategoryDto response;
        try {
            long startDate = System.currentTimeMillis();
            CategoryDomain domain = mapper.dtoToDomain(categoryDto);
            CategoryDomain savedCategory = categoryRepository.save(domain);
            response = mapper.domainToDto(savedCategory);
            log.info("Category updated with id {} in {} ms.",savedCategory.getCategoryId(),System.currentTimeMillis()-startDate);
        } catch (Exception e) {
            log.error("Exception occured while saving new category ",e);
            return null;
        }
        return response;
    }

    @Override
    public void delete(Long categoryId) {

    }
}