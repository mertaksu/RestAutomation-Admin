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

    private CompanyRepository companyRepository;

    private CompanyMapper companyMapper;

    public CompanyApiImpl(CompanyRepository companyRepository,CompanyMapper companyMapper) {
	    this.companyRepository = companyRepository;
	    this.companyMapper = companyMapper;
    }
	
	public CompanyDto save(CompanyDto companyDto) {
		CompanyDto response = null;
		try {
			CompanyDomain companyDomain = companyMapper.dtoToDomain(companyDto);
			CompanyDomain savedCompanyDomain = companyRepository.save(companyDomain);
			if(companyDomain!=null) {
			    response = companyMapper.domainToDto(savedCompanyDomain);
				LOGGER.debug("Company saved with companyId : {}",companyDomain.getCompanyId());
				return response;	
			}
			else {
				LOGGER.warn("Company could not saved!");
				return response;
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while company saving ",e );
			return response;
		}
	}
}
