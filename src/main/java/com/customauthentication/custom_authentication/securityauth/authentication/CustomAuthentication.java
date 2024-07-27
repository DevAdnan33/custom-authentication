package com.customauthentication.custom_authentication.securityauth.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomAuthentication implements Authentication{

    private final boolean authentication;
    private final String key; 

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getCredentials() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getDetails() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getPrincipal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isAuthenticated() {
       return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
