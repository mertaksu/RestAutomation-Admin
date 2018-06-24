package com.rest.automation.admin.da.api;

import com.rest.automation.admin.dto.CompanyDto;
import com.rest.automation.admin.dto.response.CompanyResponseDto;

public interface CompanyApi {

    CompanyDto save(CompanyDto companyDto);
	
}
