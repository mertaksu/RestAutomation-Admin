package com.rest.automation.admin.da.mapper.impl;

import com.rest.automation.admin.da.domain.CategoryDomain;
import com.rest.automation.admin.da.mapper.DomainDtoMapperInterface;
import com.rest.automation.admin.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements DomainDtoMapperInterface<CategoryDomain,CategoryDto> {

    @Override
    public CategoryDomain dtoToDomain(CategoryDto categoryDto) {
        CategoryDomain domain = new CategoryDomain();
        domain.setCategoryName(categoryDto.getCategoryName());
        domain.setImage(categoryDto.getImage());
        domain.setStatus(categoryDto.isStatus());
        return domain;
    }

    @Override
    public CategoryDto domainToDto(CategoryDomain categoryDomain) {
        CategoryDto dto = new CategoryDto();
        dto.setStatus(categoryDomain.isStatus());
        dto.setImage(categoryDomain.getImage());
        dto.setCategoryName(categoryDomain.getCategoryName());
        return dto;
    }
}
