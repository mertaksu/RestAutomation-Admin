package com.rest.automation.admin.da.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.api.CompanyApi;
import com.rest.automation.admin.da.domain.CompanyDomain;
import com.rest.automation.admin.da.mapper.impl.CompanyMapper;
import com.rest.automation.admin.da.repository.CompanyRepository;
import com.rest.automation.admin.dto.CompanyDto;
import com.rest.automation.admin.dto.response.CompanyResponseDto;
import com.rest.automation.commons.*;

@Component
public class CompanyApiImpl implements CompanyApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyApiImpl.class);
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	public CompanyResponseDto save(CompanyDto companyDto) {
		CompanyResponseDto response = null;
		try {
			response = new CompanyResponseDto(ResponseCodes.successCode,ResponseCodes.successDesc);
			CompanyDomain companyDomain = companyMapper.dtoToDomain(companyDto);
			companyDomain = companyRepository.save(companyDomain);
			if(companyDomain!=null) {
				LOGGER.debug("Company saved with companyId : {}",companyDomain.getCompanyId());
				return response;	
			}
			else {
				LOGGER.warn("Company could not saved!");
				response = new CompanyResponseDto(ResponseCodes.failCode, ResponseCodes.failDesc);
				return response;	
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while company saving ...",e );
			response = new CompanyResponseDto(ResponseCodes.exceptionCode, e.getMessage());
			return response;
		}
	}
}
