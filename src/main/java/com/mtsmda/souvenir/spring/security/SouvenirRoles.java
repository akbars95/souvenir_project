package com.mtsmda.souvenir.spring.security;

/**
 * Created by dminzat on 5/30/2016.
 */
public enum SouvenirRoles {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    SouvenirRoles(){}

    SouvenirRoles(String roleNameFull){
        this.roleNameFull = roleNameFull;
    }

    private String roleNameFull;

    public String getRoleNameFull() {
        return roleNameFull;
    }

    public String getRoleName(){
        return this.roleNameFull.substring(5);
    }
}