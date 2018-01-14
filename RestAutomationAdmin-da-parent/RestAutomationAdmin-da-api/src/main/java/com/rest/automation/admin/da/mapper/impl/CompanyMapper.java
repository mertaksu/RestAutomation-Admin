package com.rest.automation.admin.da.mapper.impl;

import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.domain.CompanyDomain;
import com.rest.automation.admin.da.mapper.DomainDtoMapperInterface;
import com.rest.automation.admin.dto.CompanyDto;

@Component
public class CompanyMapper implements DomainDtoMapperInterface<CompanyDomain, CompanyDto> {

	public CompanyDomain dtoToDomain(CompanyDto dto) {
		CompanyDomain domain = new CompanyDomain();
		domain.setCompanyId(dto.getCompanyId());
		domain.setAddress(dto.getAddress());
		domain.setCompanyName(dto.getCompanyName());
		return domain;
	}

	public CompanyDto domainToDto(CompanyDomain domain) {
		CompanyDto dto = new CompanyDto();
		dto.setCompanyId(domain.getCompanyId());
		dto.setAddress(domain.getAddress());
		dto.setCompanyName(domain.getCompanyName());
		return dto;
	}

}
