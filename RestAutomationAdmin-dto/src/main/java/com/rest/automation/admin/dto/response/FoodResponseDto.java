package com.rest.automation.admin.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.automation.admin.dto.DishDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodResponseDto extends BaseResponseDto {

    public DishDto food;

    public List<DishDto> foodList;

    public FoodResponseDto(int responseCode, String resultDescription) {
        super(responseCode, resultDescription);
    }

}
