package com.mtsmda.souvenir.spring.stereotype.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by MTSMDA on 01.08.2016.
 */
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("First INITMMMMM");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("First DESTROYMMMMM");
    }
}