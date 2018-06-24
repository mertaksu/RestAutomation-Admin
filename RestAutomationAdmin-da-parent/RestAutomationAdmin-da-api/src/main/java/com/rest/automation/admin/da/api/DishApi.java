package com.rest.automation.admin.da.api;

import com.rest.automation.admin.dto.DishDto;

import java.util.List;

public interface DishApi {

    DishDto save(DishDto dishDto);

    DishDto update(DishDto dishDto);

    List<DishDto> list();

    List<DishDto> listOfDishWithName(String name);

    void delete(Long dishId);
}
