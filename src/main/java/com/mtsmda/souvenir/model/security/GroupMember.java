package com.mtsmda.souvenir.model.security;

/**
 * Created by dminzat on 6/10/2016.
 */
public class GroupMember {

    private Integer groupMemberId;
    private User user;
    private Group group;

    public GroupMember() {

    }

    public GroupMember(User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public GroupMember(Integer groupMemberId, User user, Group group) {
        this.groupMemberId = groupMemberId;
        this.user = user;
        this.group = group;
    }

    public Integer getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(Integer groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}