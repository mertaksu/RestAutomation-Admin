package com.rest.automation.admin.dto.response;

import com.rest.automation.admin.dto.CompanyDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponseDto extends BaseResponseDto{

    CompanyDto savedCompany;

	public CompanyResponseDto(int responseCode,String resultDescription) {
		super(responseCode,resultDescription);
	}

    public CompanyResponseDto(int responseCode,String resultDescription,CompanyDto savedCompany) {
	    super(responseCode,resultDescription);
        this.savedCompany = savedCompany;
    }

}
