package com.rest.automation.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {

    private Long dishId;

    private String dishName;

    private String description;

    private Double price;

    private Long calories;

    private Integer discount;

    private Integer avgCookingTime;

    private byte[] image;

    private boolean status;

    private CategoryDto category;
}
