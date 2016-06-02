package com.mtsmda.souvenir.spring.security;

import com.mtsmda.souvenir.model.UserAttempts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dminzat on 6/2/2016.
 */
@Component("limitLoginAuthenticationProvider")
public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    @Qualifier(value = "userAttemptsRepositoryImpl")
    private UserAttemptsRepository userAttemptsRepository;

    @Autowired
    @Qualifier(value = "customUserDetailsService")
    @Override
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            Authentication authenticationLocal = super.authenticate(authentication);
            userAttemptsRepository.resetFailAttempts(authentication.getName());
            return authenticationLocal;
        } catch (BadCredentialsException e) {
            userAttemptsRepository.updateFailAttempts(authentication.getName());
            throw e;
        } catch (LockedException e) {
            String error = "";
            UserAttempts userAttempts = userAttemptsRepository.getUserAttempts(authentication.getName());
            if (userAttempts != null) {
                Date lastAttempts = userAttempts.getLastModified();
                error = "User account is locked!<br>Username : " + authentication.getName() + "<br>Last Attempts : " + lastAttempts;
            } else {
                error = e.getMessage();
            }
            throw new LockedException(error);
        }
    }
}