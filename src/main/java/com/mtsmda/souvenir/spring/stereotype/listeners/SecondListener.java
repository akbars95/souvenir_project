package com.mtsmda.souvenir.spring.stereotype.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by MTSMDA on 01.08.2016.
 */
public class SecondListener implements ServletContextListener {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private javax.sql.DataSource dataSource;

    @Autowired
    @Qualifier("messageSource")
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(this.dataSource != null);
        System.out.println(reloadableResourceBundleMessageSource == null);
        System.out.println("Second INITMMMMM");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Second DESTROYMMMMM");
    }
}