package com.rest.automation.admin.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PersonResponseDto extends BaseResponseDto{

	private String token;
	
	public PersonResponseDto(int responseCode,String resultDescription) {
		super(responseCode,resultDescription);
	}

}
