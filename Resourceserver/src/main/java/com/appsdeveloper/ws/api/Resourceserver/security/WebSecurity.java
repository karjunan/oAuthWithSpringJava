package com.appsdeveloper.ws.api.Resourceserver.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());

       http.authorizeRequests()
               .antMatchers(HttpMethod.GET,"/users/status/check")
//               .hasAnyAuthority("SCOPE_profile")
               .hasRole("developer")
//               .hasRole("user")
               .anyRequest().authenticated()
               .and()
               .oauth2ResourceServer()
               .jwt()
               .jwtAuthenticationConverter(jwtAuthenticationConverter);
    }
}
