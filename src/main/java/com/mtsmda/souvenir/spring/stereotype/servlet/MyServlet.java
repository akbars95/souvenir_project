package com.mtsmda.souvenir.spring.stereotype.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by dminzat on 8/2/2016.
 */
public class MyServlet extends HttpServlet {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private javax.sql.DataSource dataSource;

    @Autowired
    @Qualifier("messageSource")
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(reloadableResourceBundleMessageSource != null);
    }
}