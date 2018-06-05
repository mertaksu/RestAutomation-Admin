package com.rest.automation.admin.da.api;

import com.rest.automation.admin.dto.PersonDto;
import com.rest.automation.admin.dto.response.PersonResponseDto;

public interface PersonApi {

    PersonResponseDto save(PersonDto personDto);
	
    PersonDto findPersonForLogin(String username,String password);
}
