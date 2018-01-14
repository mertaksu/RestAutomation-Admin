package com.rest.automation.admin.services;

import com.rest.automation.admin.dto.CompanyDto;
import com.rest.automation.admin.dto.response.CompanyResponseDto;

public interface CompanyService {

	public CompanyResponseDto createCompany(CompanyDto company);
}

