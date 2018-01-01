package com.rest.automation.admin.da.mapper;

public interface DomainDtoMapperInterface<Domain,Dto> {

	public Domain dtoToDomain(Dto dto);
	
	public Dto domainToDto(Domain domain);
}
