package com.appsdeveloper.ws.api.Resourceserver.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeyCloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {


    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String,Object> realm = (Map<String, Object>) jwt.getClaims().get("realm_access");
        if(realm == null) {
            return new ArrayList<>();
        }

        List<String> list = (List<String>) realm.get("roles");
        return list.stream().map(roleName -> "ROLE_"+roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }
}
