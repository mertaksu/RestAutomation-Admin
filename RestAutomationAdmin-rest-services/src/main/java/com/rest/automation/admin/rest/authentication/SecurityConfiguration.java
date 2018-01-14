package com.rest.automation.admin.rest.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@ComponentScan({"com.rest.automation.admin.rest.authentication"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	TokenAuthenticationProvider provider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		   http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/auth/login")
		   .permitAll().anyRequest()
		   .authenticated()
           .and()
           .httpBasic();
		   
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}
}
