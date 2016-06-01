package com.mtsmda.souvenir.spring.config;

import com.mtsmda.souvenir.spring.security.SouvenirRoles;
import com.mtsmda.souvenir.spring.stereotype.controller.constants.AdminPieceConstants;
import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by dminzat on 5/30/2016.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String HAS_ROLE = "hasRole";

    @Autowired
    public void configureUsers(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().
                withUser("user9").password("user9")./*authorities(SouvenirRoles.ADMIN.getRoleNameFull())*/roles(SouvenirRoles.ADMIN.getRoleName());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //authorize requests
        httpSecurity.authorizeRequests().
                antMatchers(AdminPieceConstants.ADMIN_PIECE_PIECE_URL + StaticPageConstants.ROOT + StaticPageConstants.ROOT_SUB_CATALOG).
                access(HAS_ROLE + "('" + SouvenirRoles.ADMIN.getRoleNameFull() + "')");

        //custom login
        httpSecurity.formLogin().loginPage("/login").loginProcessingUrl("/login_process").failureUrl("/login?error")
                .usernameParameter("souvenir_username_9").passwordParameter("souvenir_password_9")
                /*.defaultSuccessUrl(StaticPageConstants.ROOT, false)*/
                .and().csrf()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

        //logout configuration
        //httpSecurity.logout()/*.*/
                /*logoutUrl("/logout").*/
                /*logoutSuccessUrl("/")*//*logoutSuccessUrl("/login?logout")*/
                /*.and().logout().    //logout configuration
                logoutUrl("/logout").
                logoutSuccessUrl(StaticPageConstants.ROOT)*/;
    }

}