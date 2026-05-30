package com.geneza.lms.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.*;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements UserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        return Collections.emptyMap();
    }

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (!map.containsKey("realm_access")) {
            return null;
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> realmAccess = (Map<String, Object>) map.get("realm_access");

        @SuppressWarnings("unchecked")
        List<String> roles = (List<String>) realmAccess.get("roles");

        if (roles == null) {
            return null;
        }

        Collection<GrantedAuthority> authorities = roles.stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
            .collect(Collectors.toList());

        // Cast map to avoid Java 8 generic inference issue
        Map<String, Object> claims = (Map<String, Object>) map;
        String username = claims.containsKey("preferred_username")
            ? (String) claims.get("preferred_username")
            : "unknown";

        return new UsernamePasswordAuthenticationToken(username, "N/A", authorities);
    }
}