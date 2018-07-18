package com.rest.automation.admin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TableDto {

    private Integer tableId;

    private String tableState;

    private boolean status;

    private CompanyDto company;

}
