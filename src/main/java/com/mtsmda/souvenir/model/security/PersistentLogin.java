package com.mtsmda.souvenir.model.security;

import java.time.LocalDateTime;

/**
 * Created by dminzat on 6/10/2016.
 */
public class PersistentLogin {

    private User user;
    private String series;
    private String token;
    private LocalDateTime lastUsed;

    public PersistentLogin() {

    }

    public PersistentLogin(String series, String token, LocalDateTime lastUsed) {
        this.series = series;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }
}