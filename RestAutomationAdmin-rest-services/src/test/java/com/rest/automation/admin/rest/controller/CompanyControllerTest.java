package com.rest.automation.admin.rest.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.automation.admin.dto.response.CompanyResponseDto;
import com.rest.automation.admin.rest.spring.RestAutomationAdminApplication;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestAutomationAdminApplication.class)
public class CompanyControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.apply(springSecurity()).build();
	}

	@Test
	public void createCompanyTest() throws Exception {
		String requestJson = "{ \"companyName\":\"Dönerci Ali Usta\",\"address\":\"Maltepe/İstanbul\"}";

		MvcResult mvcResult = mockMvc
				.perform(
						post("/createCompany")
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.content(requestJson)
								.with(httpBasic("user","a4a16405-ecb4-4839-bf32-b6529559cb91")))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn();
		
		CompanyResponseDto response = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), CompanyResponseDto.class);
		assertEquals(0, response.getResponseCode());
	}

}
