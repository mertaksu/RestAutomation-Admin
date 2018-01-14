package com.rest.automation.admin.services;

import com.rest.automation.admin.dto.PersonDto;
import com.rest.automation.admin.dto.response.PersonResponseDto;

public interface PersonService {

	public PersonResponseDto createNewPerson(PersonDto personDto);
	
	public PersonResponseDto login(String username,String password);
}
