package com.rest.automation.admin.rest.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.rest.automation.admin.rest.spring.RestAutomationAdminApplication;

public class ServletInitializer extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestAutomationAdminApplication.class);
	}

}
