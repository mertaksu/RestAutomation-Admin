package com.rest.automation.admin.da.api;

import com.rest.automation.admin.dto.PersonDto;
import com.rest.automation.admin.dto.response.PersonResponseDto;

public interface PersonApi {

	public PersonResponseDto save(PersonDto personDto);
	
	public PersonDto findPersonForLogin(String username,String password);
}
