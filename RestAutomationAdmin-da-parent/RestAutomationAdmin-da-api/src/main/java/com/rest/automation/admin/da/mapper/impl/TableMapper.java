package com.rest.automation.admin.da.mapper.impl;

import com.rest.automation.admin.da.domain.TableDomain;
import com.rest.automation.admin.da.mapper.DomainDtoMapperInterface;
import com.rest.automation.admin.dto.TableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableMapper implements DomainDtoMapperInterface<TableDomain,TableDto> {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public TableDomain dtoToDomain(TableDto tableDto) {
        TableDomain tableDomain = new TableDomain();
        tableDomain.setTableState(tableDto.getTableState());
        tableDomain.setStatus(tableDto.isStatus());
        tableDomain.setTableId(tableDto.getTableId());
        if(tableDto.getCompany()!=null) {
            tableDomain.setCompany(companyMapper.dtoToDomain(tableDto.getCompany()));
        }
        return tableDomain;
    }

    @Override
    public TableDto domainToDto(TableDomain tableDomain) {
        TableDto tableDto = new TableDto();
        tableDto.setTableState(tableDomain.getTableState());
        tableDto.setStatus(tableDomain.isStatus());
        tableDto.setTableId(tableDomain.getTableId());
        if(tableDomain!=null && tableDomain.getCompany()!=null) {
            tableDto.setCompany(companyMapper.domainToDto(tableDomain.getCompany()));
        }
        return tableDto;
    }
}
