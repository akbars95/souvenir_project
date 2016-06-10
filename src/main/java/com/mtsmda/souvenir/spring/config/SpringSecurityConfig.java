package com.mtsmda.souvenir.spring.config;

import com.mtsmda.souvenir.spring.security.CustomJdbcTokenRepositoryImpl;
import com.mtsmda.souvenir.model.constant.SouvenirRoles;
import com.mtsmda.souvenir.spring.stereotype.controller.constants.AdminPieceConstants;
import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Created by dminzat on 5/30/2016.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String HAS_ROLE = "hasRole";

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "limitLoginAuthenticationProvider")
    private AuthenticationProvider authenticationProvider;

    @Autowired
    public void configureUsers(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        /*authenticationManagerBuilder.inMemoryAuthentication().
                withUser("user9").password("user9").roles(SouvenirRoles.ADMIN.getRoleName());*/
        /*authorities(SouvenirRoles.ADMIN.getRoleNameFull())*/

        /*JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> authenticationManagerBuilderJdbcUserDetailsManagerConfigurer = authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource);
        authenticationManagerBuilderJdbcUserDetailsManagerConfigurer.usersByUsernameQuery("select username, passwordC, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");*/
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //authorize requests
        httpSecurity.authorizeRequests().
                antMatchers(AdminPieceConstants.ADMIN_PIECE_PIECE_URL + StaticPageConstants.ROOT + StaticPageConstants.ROOT_SUB_CATALOG).
                access(HAS_ROLE + "('" + SouvenirRoles.ADMIN.getRoleNameFull() + "')");

        //custom login
        httpSecurity.formLogin().loginPage("/login").loginProcessingUrl("/login_process").failureUrl("/login?error=true")

                .usernameParameter("souvenir_username_9").passwordParameter("souvenir_password_9")
                /*.defaultSuccessUrl(StaticPageConstants.ROOT, false)*/
                .and().csrf()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

        //logout configuration
        httpSecurity.logout().
                logoutUrl("/logout").
                logoutSuccessUrl("/").deleteCookies("JSESSIONID")/*logoutSuccessUrl("/login?logout")*/
                /*.and().logout().    //logout configuration
                logoutUrl("/logout").
                logoutSuccessUrl(StaticPageConstants.ROOT)*/;

        //remember me
        httpSecurity.rememberMe().rememberMeParameter("souvenir-remember-me")
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60*60*24);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new CustomJdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler(){
        SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        savedRequestAwareAuthenticationSuccessHandler.setTargetUrlParameter("targetUrl");
        return savedRequestAwareAuthenticationSuccessHandler;
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}