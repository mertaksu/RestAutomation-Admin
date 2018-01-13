package com.rest.automation.admin.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.automation.admin.dto.CompanyDto;
import com.rest.automation.admin.services.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value="/createCompany",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Boolean createCompany(@RequestBody CompanyDto companyDto) {
		return companyService.createCompany(companyDto);
	}
}