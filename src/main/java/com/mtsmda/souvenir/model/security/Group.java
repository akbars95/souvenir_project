package com.mtsmda.souvenir.model.security;

/**
 * Created by dminzat on 6/10/2016.
 */
public class Group {

    private Integer groupId;
    private String groupName;

    public Group() {

    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}