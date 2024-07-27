package com.customauthentication.custom_authentication.securityauth.filter;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.customauthentication.custom_authentication.securityauth.authentication.CustomAuthentication;
import com.customauthentication.custom_authentication.securityauth.manager.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String headerKey = request.getHeader("key");
        CustomAuthentication customAuthentication = new CustomAuthentication(false, headerKey);
        Authentication authenticationObject = customAuthenticationManager.authenticate(customAuthentication);
        SecurityContextHolder.getContext().setAuthentication(authenticationObject);
        filterChain.doFilter(request, response);
    }

}
