package com.rest.automation.admin.services;

import com.rest.automation.admin.dto.DishDto;

import java.util.List;

public interface FoodService {

    DishDto createFood(DishDto dishDto) throws Exception;

    DishDto updateFood(DishDto dishDto) throws Exception;

    void deleteFood(Long dishId) throws Exception;

    List<DishDto> listOfAllFoods() throws Exception;

    List<DishDto> listOfSelectedFoodsByName(String foodName) throws Exception;
}
