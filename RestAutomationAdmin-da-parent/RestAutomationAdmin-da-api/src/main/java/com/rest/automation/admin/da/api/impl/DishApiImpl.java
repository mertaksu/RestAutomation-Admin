package com.rest.automation.admin.da.api.impl;

import com.rest.automation.admin.da.api.DishApi;
import com.rest.automation.admin.da.domain.DishDomain;
import com.rest.automation.admin.da.mapper.impl.DishMapper;
import com.rest.automation.admin.da.repository.DishRepository;
import com.rest.automation.admin.dto.DishDto;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DishApiImpl implements DishApi {

    DishRepository dishRepository;
    DishMapper dishMapper;

    public DishApiImpl(DishRepository dishRepository, DishMapper dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }

    @Override
    public DishDto save(DishDto dishDto) {
        DishDomain savedDishDomain;
        DishDto resultDishDto = new DishDto();
        try {
            DishDomain domain = dishMapper.dtoToDomain(dishDto);
            savedDishDomain = dishRepository.save(domain);
            if(savedDishDomain!=null) {
                resultDishDto = dishMapper.domainToDto(savedDishDomain);
            } else {
                log.warn("Could not saved new dish");
            }
        } catch (Exception e) {
            log.error("Exception occured while saving new dish ",e);
            return null;
        }
        return resultDishDto;
    }

    @Override
    public DishDto update(DishDto dishDto) {
        DishDto resultDishDto = new DishDto();
        try {
           DishDomain dishDomain = dishMapper.dtoToDomain(dishDto);
           if(dishDomain.getDishId()==null) {
                log.warn("Dish could not updated. DishId is null.");
           }
           DishDomain updatedDishDomain = dishRepository.save(dishDomain);
           resultDishDto = dishMapper.domainToDto(updatedDishDomain);
        } catch (Exception e) {
            log.error("Exception occured while updating dish ",e);
        }
        return resultDishDto;
    }

    @Override
    public List<DishDto> list() {
        List<DishDto> list = new ArrayList<>();
        try{
           List<DishDomain> listOfDishDomain = dishRepository.findAll();
           for (DishDomain dishDomain:listOfDishDomain) {
                list.add(dishMapper.domainToDto(dishDomain));
           }
        } catch (Exception e) {
            log.error("Exception occured while listing dishes ",e);
            throw e;
        }
        return list;
    }

    @Override
    public List<DishDto> listOfDishWithName(String name) {
        List<DishDto> list = new ArrayList<>();
        try {
            List<DishDomain> listOfDishDomain = dishRepository.findByDishName(name);
            for (DishDomain dishDomain:listOfDishDomain) {
                list.add(dishMapper.domainToDto(dishDomain));
            }
        } catch (Exception e) {
            log.error("Exception occured while listing dish with name ",e);
            throw e;
        }
        return list;
    }

    @Override
    public void delete(Long dishId) {
        try {
            dishRepository.delete(dishId);
        } catch (Exception e) {
            log.error("Exception occured while deleting dishes ",e);
            throw e;
        }
    }
}
