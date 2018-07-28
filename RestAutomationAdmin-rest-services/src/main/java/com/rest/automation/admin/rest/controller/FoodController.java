package com.rest.automation.admin.rest.controller;

import com.rest.automation.admin.dto.DishDto;
import com.rest.automation.admin.dto.response.FoodResponseDto;
import com.rest.automation.admin.services.FoodService;
import com.rest.automation.commons.ResponseCodes;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FoodController {

    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping(value = "/food",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodResponseDto createNewFood(@RequestBody List<DishDto> dishDto) {
        long startDate = System.currentTimeMillis();
        FoodResponseDto response = new FoodResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
        try {
            DishDto savedDishDto=null;
            for (DishDto dishDto1:dishDto) {
                savedDishDto = foodService.createFood(dishDto1);
            }
           if(savedDishDto != null) {
               log.info("New Food created with FoodId {}. Delta {}",savedDishDto.getDishId(),System.currentTimeMillis() - startDate);
               response.setFood(savedDishDto);
               return response;
           } else {
               log.warn("New Food could not saved.");
               response = new FoodResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc);
               return  response;
           }
        } catch (Exception e) {
            log.warn("Exception occured while saving a food.",e);
            return new FoodResponseDto(ResponseCodes.exceptionCode, ResponseCodes.exceptionDesc);
        }
    }

    @RequestMapping(value = "/food",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodResponseDto updateFood(@RequestBody DishDto dishDto) {
        long startDate = System.currentTimeMillis();
        FoodResponseDto response = new FoodResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
        try {
            DishDto updatedDishDto = foodService.updateFood(dishDto);
            if(updatedDishDto != null) {
                log.info("Updated Food with FoodId {}. Delta {}",updatedDishDto.getDishId(),System.currentTimeMillis() - startDate);
                response.setFood(updatedDishDto);
                return response;
            } else {
                log.warn("Food could not updated.");
                response = new FoodResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc);
                return  response;
            }
        } catch (Exception e) {
            log.warn("Exception occured while updating a food.",e);
            return new FoodResponseDto(ResponseCodes.exceptionCode, ResponseCodes.exceptionDesc);
        }
    }

    @RequestMapping(value = "/foods",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodResponseDto listOfAllFoods() {
        long startDate = System.currentTimeMillis();
        FoodResponseDto response = new FoodResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
        try {
            List<DishDto> allFoods = foodService.listOfAllFoods();
            if(allFoods != null) {
                log.info("Food list returned with FoodList Size {}. Delta {}",allFoods.size(),System.currentTimeMillis() - startDate);
                response.setFoodList(allFoods);
                return response;
            } else {
                log.warn("Food list could not fetched.");
                response = new FoodResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc);
                return  response;
            }
        } catch (Exception e) {
            log.warn("Exception occured while getting food list.",e);
            return new FoodResponseDto(ResponseCodes.exceptionCode, ResponseCodes.exceptionDesc);
        }
    }

    @RequestMapping(value = "/foods/{foodName}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodResponseDto listOfSelectedFoods(@PathVariable("foodName") String foodName) {
        long startDate = System.currentTimeMillis();
        FoodResponseDto response = new FoodResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
        try {
            List<DishDto> searchedFoods = foodService.listOfSelectedFoodsByName(foodName);
            if(searchedFoods != null) {
                log.info("Food list returned with list size {}. Delta {}",searchedFoods.size(),System.currentTimeMillis() - startDate);
                response.setFoodList(searchedFoods);
                return response;
            } else {
                log.warn("Searched Food list could not fetched.");
                response = new FoodResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc);
                return  response;
            }
        } catch (Exception e) {
            log.warn("Exception occured while getting food list.",e);
            return new FoodResponseDto(ResponseCodes.exceptionCode, ResponseCodes.exceptionDesc);
        }
    }

    @RequestMapping(value = "/food/{foodId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodResponseDto deleteFood(@PathVariable("foodId") Long foodId) {
        long startDate = System.currentTimeMillis();
        FoodResponseDto response = new FoodResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
        try {
            foodService.deleteFood(foodId);
            log.info("Food deleted with id {}. Delta {}",foodId,System.currentTimeMillis()-startDate);
        } catch (Exception e) {
            log.warn("Exception occured while deleting food.",e);
            response = new FoodResponseDto(ResponseCodes.exceptionCode,ResponseCodes.exceptionDesc);
            return response;
        }
        return response;
    }
}
