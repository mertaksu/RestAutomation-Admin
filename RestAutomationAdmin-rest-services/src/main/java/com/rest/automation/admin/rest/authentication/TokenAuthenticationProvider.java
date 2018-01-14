package com.rest.automation.admin.rest.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.rest.automation.admin.da.api.PersonApi;
import com.rest.automation.admin.dto.PersonDto;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	PersonApi personApi;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		
		PersonDto dto = personApi.findPersonForLogin(username, password);

        if(dto!=null) {
        	return new UsernamePasswordAuthenticationToken(username, password, authList);
        }
        return null;
//		String token = (String) authentication.getPrincipal();
//        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//		if (token != null && token.startsWith("Basic")) {
//	        // Authorization: Basic base64credentials
//	        String base64Credentials = token.substring("Basic".length()).trim();
//	        String credentials = new String(Base64.getDecoder().decode(base64Credentials),Charset.forName("UTF-8"));
//	        // credentials = username:password
//	        final String[] values = credentials.split(":",2);
//	        PersonDto dto = personApi.findPersonForLogin(values[0], values[1]);
//	        if(dto!=null) {
//	        	return new UsernamePasswordAuthenticationToken(values[0], values[1], authList);
//	        }
//		}
//		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
