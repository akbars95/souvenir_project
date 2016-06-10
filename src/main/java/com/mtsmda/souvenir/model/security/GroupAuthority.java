package com.mtsmda.souvenir.model.security;

/**
 * Created by dminzat on 6/10/2016.
 */
public class GroupAuthority {

    private Group group;
    private Role role;

    public GroupAuthority() {

    }

    public GroupAuthority(Group group, Role role) {
        this.group = group;
        this.role = role;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}