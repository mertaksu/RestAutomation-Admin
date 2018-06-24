package com.rest.automation.admin.services.impl;

import com.rest.automation.admin.da.api.DishApi;
import com.rest.automation.admin.dto.DishDto;
import com.rest.automation.admin.services.FoodService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodServiceImpl implements FoodService {

    DishApi dishApi;

    public FoodServiceImpl(DishApi dishApi) throws Exception {
        this.dishApi = dishApi;
    }

    @Override
    public DishDto createFood(DishDto dishDto) throws Exception {
        return dishApi.save(dishDto);
    }

    @Override
    public DishDto updateFood(DishDto dishDto) throws Exception {
        return dishApi.update(dishDto);
    }

    @Override
    public void deleteFood(Long dishId) throws Exception{
        dishApi.delete(dishId);
    }

    @Override
    public List<DishDto> listOfAllFoods() throws Exception  {
        return dishApi.list();
    }

    @Override
    public List<DishDto> listOfSelectedFoodsByName(String foodName) throws Exception {
        return dishApi.listOfDishWithName(foodName);
    }
}
