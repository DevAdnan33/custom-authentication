package com.customauthentication.custom_authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.customauthentication.custom_authentication.securityauth.filter.CustomAuthenticationFilter;

@Configuration
public class SecurityConfig {

    public SecurityConfig(com.customauthentication.custom_authentication.securityauth.filter.CustomAuthenticationFilter customAuthenticationFilter) {
        this.customAuthenticationFilter = customAuthenticationFilter;
    }
    
    private final CustomAuthenticationFilter customAuthenticationFilter;

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();
        return httpSecurity.addFilterAfter(customAuthenticationFilter, BasicAuthenticationFilter.class).authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).build();
        
    }

}
