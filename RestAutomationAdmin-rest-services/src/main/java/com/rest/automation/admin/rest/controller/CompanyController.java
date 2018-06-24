package com.rest.automation.admin.rest.controller;

import com.rest.automation.commons.ResponseCodes;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.automation.admin.dto.CompanyDto;
import com.rest.automation.admin.dto.response.CompanyResponseDto;
import com.rest.automation.admin.services.CompanyService;

@RestController
@Slf4j
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
	
	@RequestMapping(value="/company",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CompanyResponseDto createCompany(@RequestBody CompanyDto companyDto) {
        CompanyResponseDto response = new CompanyResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
	    try {
            CompanyDto savedCompany = companyService.createCompany(companyDto);
            if(savedCompany!=null) {
                response.setSavedCompany(savedCompany);
                return response;
            } else {
                log.warn("New Company could not saved.");
                response = new CompanyResponseDto(ResponseCodes.failCode,ResponseCodes.failDesc);
                return response;
            }
        } catch (Exception e) {
	        log.error("Exception occured while saving new company");
	        response = new CompanyResponseDto(ResponseCodes.exceptionCode,ResponseCodes.exceptionDesc);
	        return response;
        }
	}
}
