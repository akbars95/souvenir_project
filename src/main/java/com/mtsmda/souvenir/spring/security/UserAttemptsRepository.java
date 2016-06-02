package com.mtsmda.souvenir.spring.security;

import com.mtsmda.souvenir.model.UserAttempts;

/**
 * Created by dminzat on 6/2/2016.
 */
public interface UserAttemptsRepository {

    public void updateFailAttempts(String username);
    public void resetFailAttempts(String username);
    public UserAttempts getUserAttempts(String username);

}