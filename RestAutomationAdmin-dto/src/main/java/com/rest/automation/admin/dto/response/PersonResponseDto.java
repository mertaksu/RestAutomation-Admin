package com.rest.automation.admin.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponseDto extends BaseResponseDto{

	private String token;
	
	public PersonResponseDto(int responseCode,String resultDescription) {
		super(responseCode,resultDescription);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
