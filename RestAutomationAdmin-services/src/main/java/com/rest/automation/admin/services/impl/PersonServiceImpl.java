package com.rest.automation.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.api.PersonApi;
import com.rest.automation.admin.dto.PersonDto;
import com.rest.automation.admin.dto.response.PersonResponseDto;
import com.rest.automation.admin.services.PersonService;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonApi personApi;
	

	public PersonResponseDto createNewPerson(PersonDto personDto) {
		return personApi.save(personDto);
	}

	public PersonResponseDto login(String username, String password) {
	return null;
//		provider.authenticate(authentication)
	}

}
