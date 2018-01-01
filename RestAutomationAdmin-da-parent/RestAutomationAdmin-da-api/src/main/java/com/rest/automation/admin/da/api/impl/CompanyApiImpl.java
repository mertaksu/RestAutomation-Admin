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

@Component
public class CompanyApiImpl implements CompanyApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyApiImpl.class);
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	public Boolean save(CompanyDto companyDto) {
		try {
			CompanyDomain companyDomain = companyMapper.dtoToDomain(companyDto);
			companyDomain = companyRepository.save(companyDomain);
			if(companyDomain!=null) {
				LOGGER.debug("Company saved with companyId : {}",companyDomain.getCompanyId());
				return true;	
			}
			else {
				LOGGER.warn("Company could not saved!");
				return true;	
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while company saving ...",e );
			return false;
		}
	}
}
