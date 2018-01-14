package com.rest.automation.admin.services.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.api.PersonApi;
import com.rest.automation.admin.dto.PersonDto;
import com.rest.automation.admin.dto.response.PersonResponseDto;
import com.rest.automation.admin.services.PersonService;
import com.rest.automation.commons.ResponseCodes;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonApi personApi;
	

	public PersonResponseDto createNewPerson(PersonDto personDto) {
		return personApi.save(personDto);
	}

	public PersonResponseDto login(String username, String password) {
		PersonResponseDto response = null;
		PersonDto dto = personApi.findPersonForLogin(username, password);
		if(dto==null) {
			response = new PersonResponseDto(ResponseCodes.unauthorizeCode, ResponseCodes.unauthorizeDesc);
			return response;
		} else {
			response = new PersonResponseDto(ResponseCodes.successCode, ResponseCodes.successDesc);
			String token = Base64.getEncoder().encodeToString((username+":"+password).getBytes());
			response.setToken(token);
			return response;
		}
	}

}
