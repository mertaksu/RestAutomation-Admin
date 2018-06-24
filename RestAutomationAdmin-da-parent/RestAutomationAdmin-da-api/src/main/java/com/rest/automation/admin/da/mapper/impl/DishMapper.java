package com.rest.automation.admin.da.mapper.impl;

import com.rest.automation.admin.da.domain.DishDomain;
import com.rest.automation.admin.da.mapper.DomainDtoMapperInterface;
import com.rest.automation.admin.dto.DishDto;
import org.springframework.stereotype.Component;

@Component
public class DishMapper implements DomainDtoMapperInterface<DishDomain,DishDto> {

    CategoryMapper categoryMapper;

    public DishMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public DishDomain dtoToDomain(DishDto dishDto) {
        DishDomain dishDomain = new DishDomain();
        dishDomain.setAvgCookingTime(dishDto.getAvgCookingTime());
        dishDomain.setCalories(dishDto.getCalories());
        dishDomain.setCategory(categoryMapper.dtoToDomain(dishDto.getCategory()));
        dishDomain.setDescription(dishDto.getDescription());
        dishDomain.setDiscount(dishDto.getDiscount());
        if(dishDto.getDishId()!=null) {
            dishDomain.setDishId(dishDto.getDishId());
        }
        dishDomain.setDishName(dishDto.getDishName());
        dishDomain.setImage(dishDto.getImage());
        dishDomain.setPrice(dishDto.getPrice());
        dishDomain.setStatus(dishDto.isStatus());
        return dishDomain;
    }

    @Override
    public DishDto domainToDto(DishDomain dishDomain) {
        DishDto dishDto = new DishDto();
        dishDto.setAvgCookingTime(dishDomain.getAvgCookingTime());
        dishDto.setCalories(dishDomain.getCalories());
        dishDto.setCategory(categoryMapper.domainToDto(dishDomain.getCategory()));
        dishDto.setDescription(dishDomain.getDescription());
        dishDto.setDiscount(dishDomain.getDiscount());
        dishDto.setDishId(dishDomain.getDishId());
        dishDto.setDishName(dishDomain.getDishName());
        dishDto.setImage(dishDomain.getImage());
        dishDto.setPrice(dishDomain.getPrice());
        dishDto.setStatus(dishDomain.isStatus());
        return dishDto;
    }
}
