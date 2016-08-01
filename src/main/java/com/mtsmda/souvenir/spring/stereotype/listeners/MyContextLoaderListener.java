package com.mtsmda.souvenir.spring.stereotype.listeners;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by dminzat on 8/2/2016.
 */
public class MyContextLoaderListener extends ContextLoaderListener {



    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);

    }
}