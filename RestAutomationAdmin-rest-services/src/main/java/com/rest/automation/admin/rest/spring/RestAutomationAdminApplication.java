package com.rest.automation.admin.rest.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({"com.rest.automation.admin.rest.*","com.rest.automation.admin.da.*","com.rest.automation.admin.services.*"})
public class RestAutomationAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestAutomationAdminApplication.class, args);
    }
}
