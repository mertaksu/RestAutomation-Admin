package com.rest.automation.admin.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rest.automation.admin.dto.CategoryDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponseDto extends BaseResponseDto{

    CategoryDto category;

    List<CategoryDto> categoryList;

	public CategoryResponseDto(int responseCode, String resultDescription) {
		super(responseCode,resultDescription);
	}

    public CategoryResponseDto(int responseCode, String resultDescription,CategoryDto categoryDto) {
        super(responseCode,resultDescription);
        this.category = categoryDto;
    }

    public CategoryResponseDto(int responseCode, String resultDescription,List<CategoryDto> categoryDtoList) {
	    super(responseCode,resultDescription);
	    this.categoryList = categoryDtoList;
    }
}
