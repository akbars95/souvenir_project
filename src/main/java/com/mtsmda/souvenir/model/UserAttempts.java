package com.mtsmda.souvenir.model;

import java.util.Date;

/**
 * Created by dminzat on 6/2/2016.
 */
public class UserAttempts {

    private int id;
    private String username;
    private int attempts;
    private Date lastModified;

    public UserAttempts() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}