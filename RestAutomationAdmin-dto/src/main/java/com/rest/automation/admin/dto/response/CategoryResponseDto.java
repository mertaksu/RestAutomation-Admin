package com.rest.automation.admin.dto.response;

import com.rest.automation.admin.dto.CategoryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDto extends BaseResponseDto{

    CategoryDto category;

	public CategoryResponseDto(int responseCode, String resultDescription) {
		super(responseCode,resultDescription);
	}

    public CategoryResponseDto(int responseCode, String resultDescription,CategoryDto categoryDto) {
        super(responseCode,resultDescription);
        this.category = categoryDto;
    }
}
