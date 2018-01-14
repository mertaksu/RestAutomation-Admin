package com.rest.automation.admin.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rest.automation.admin.dto.PersonDto;
import com.rest.automation.admin.dto.response.PersonResponseDto;
import com.rest.automation.admin.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/newUser",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PersonResponseDto createNewPerson(@RequestBody PersonDto personDto) {
		return personService.createNewPerson(personDto);
	}
	
	@RequestMapping(value="/auth/login",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public PersonResponseDto login(String username,String password) {
		return personService.login(username, password);
	}
}
