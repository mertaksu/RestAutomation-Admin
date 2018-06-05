package com.rest.automation.admin.da.mapper;

public interface DomainDtoMapperInterface<Domain,Dto> {

    Domain dtoToDomain(Dto dto);
	
    Dto domainToDto(Domain domain);
}
