package com.rest.automation.admin.da.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.domain.PersonDomain;
import com.rest.automation.admin.da.mapper.DomainDtoMapperInterface;
import com.rest.automation.admin.dto.PersonDto;

@Component
public class PersonMapper implements DomainDtoMapperInterface<PersonDomain, PersonDto>{

	@Autowired
	private CompanyMapper companyMapper;
	
	public PersonDomain dtoToDomain(PersonDto dto) {
		PersonDomain domain = new PersonDomain();
		domain.setCompany(companyMapper.dtoToDomain(dto.getCompany()));
		domain.setFullName(dto.getFullName());
		domain.setPassword(dto.getPassword());
		domain.setRole(dto.getRole());
		domain.setStatus(dto.getStatus());
		domain.setUsername(dto.getUsername());
		return domain;
	}

	public PersonDto domainToDto(PersonDomain domain) {
		PersonDto dto = new PersonDto();
		dto.setCompany(companyMapper.domainToDto(domain.getCompany()));
		dto.setFullName(domain.getFullName());
		dto.setRole(domain.getRole());
		dto.setStatus(domain.getStatus());
		dto.setUsername(domain.getUsername());
		return dto;
	}

}
