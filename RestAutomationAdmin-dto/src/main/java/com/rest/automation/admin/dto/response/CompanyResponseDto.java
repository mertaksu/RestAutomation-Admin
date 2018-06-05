package com.rest.automation.admin.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponseDto extends BaseResponseDto{
	
	public CompanyResponseDto(int responseCode,String resultDescription) {
		super(responseCode,resultDescription);
	}

}
