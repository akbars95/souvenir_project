package com.mtsmda.souvenir.model.security;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by dminzat on 6/10/2016.
 */
public class UserAttempt {

    private Integer userAttemptId;
    private User user;
    private Integer attempt;
    private LocalDateTime lastModified;

    public UserAttempt() {

    }

    public UserAttempt(User user, Integer attempt, LocalDateTime lastModified) {
        this.user = user;
        this.attempt = attempt;
        this.lastModified = lastModified;
    }

    public Integer getUserAttemptId() {
        return userAttemptId;
    }

    public void setUserAttemptId(Integer userAttemptId) {
        this.userAttemptId = userAttemptId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}