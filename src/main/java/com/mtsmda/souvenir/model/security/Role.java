package com.mtsmda.souvenir.model.security;

import com.mtsmda.souvenir.model.constant.SouvenirRoles;

/**
 * Created by dminzat on 6/10/2016.
 */
public class Role {

    private Integer roleId;
    private SouvenirRoles souvenirRoles;

    public Role() {

    }

    public Role(SouvenirRoles souvenirRoles) {
        this.souvenirRoles = souvenirRoles;
    }

    public Role(Integer roleId, SouvenirRoles souvenirRoles) {
        this.roleId = roleId;
        this.souvenirRoles = souvenirRoles;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public SouvenirRoles getSouvenirRoles() {
        return souvenirRoles;
    }

    public void setSouvenirRoles(SouvenirRoles souvenirRoles) {
        this.souvenirRoles = souvenirRoles;
    }
}