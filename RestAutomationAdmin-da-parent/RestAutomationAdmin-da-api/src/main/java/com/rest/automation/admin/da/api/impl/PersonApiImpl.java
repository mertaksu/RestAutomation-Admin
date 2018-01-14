package com.rest.automation.admin.da.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.api.PersonApi;
import com.rest.automation.admin.da.domain.PersonDomain;
import com.rest.automation.admin.da.mapper.impl.PersonMapper;
import com.rest.automation.admin.da.repository.PersonRepository;
import com.rest.automation.admin.dto.PersonDto;
import com.rest.automation.admin.dto.response.PersonResponseDto;
import com.rest.automation.commons.ResponseCodes;

@Component
public class PersonApiImpl implements PersonApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonApiImpl.class);
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonMapper personMapper;
	
	public PersonResponseDto save(PersonDto personDto) {
		PersonResponseDto response = null;
		try {
			response = new PersonResponseDto(ResponseCodes.successCode, ResponseCodes.successDesc);
			PersonDomain personDomain = personMapper.dtoToDomain(personDto);
			personDomain = personRepository.save(personDomain);
			if(personDomain == null) {
				response = new PersonResponseDto(ResponseCodes.failCode, ResponseCodes.failDesc);
				LOGGER.warn("Person could not saved ");
			}
			return response;
		} catch (Exception e) {
			LOGGER.error("Exception occured while person saving ",e);
			response = new PersonResponseDto(ResponseCodes.exceptionCode, e.getMessage());
			return response;
		}
	}

	public PersonDto findPersonForLogin(String username,String password) {
		PersonDomain domain = personRepository.findByUsernameAndPassword(username,password);
		if(domain!=null) 
			return personMapper.domainToDto(domain);
		else
			return null;
	}

}
