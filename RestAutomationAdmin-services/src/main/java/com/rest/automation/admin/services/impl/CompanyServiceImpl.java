package com.rest.automation.admin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.api.CompanyApi;
import com.rest.automation.admin.dto.CompanyDto;
import com.rest.automation.admin.services.CompanyService;

@Component
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyApi companyApi;
	
	public Boolean createCompany(CompanyDto company) {
		return companyApi.save(company);
	}

}
