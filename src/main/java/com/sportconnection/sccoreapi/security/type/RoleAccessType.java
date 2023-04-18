package com.sportconnection.sccoreapi.security.type;

import org.springframework.security.core.GrantedAuthority;

public enum RoleAccessType implements GrantedAuthority {
    USER("USER"),
    ADMIN("ADMIN");

    private final String role;

    RoleAccessType(String role) {
        this.role = role;
    };

    @Override
    public String getAuthority() {
        return this.role;
    }

}
