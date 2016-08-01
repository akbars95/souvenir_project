package com.mtsmda.souvenir.spring.stereotype.applistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by dminzat on 8/2/2016.
 */
public class ContextStartedEventApplicationListener implements ApplicationListener<ContextStartedEvent> {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private javax.sql.DataSource dataSource;

    @Autowired
    @Qualifier("messageSource")
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("hereeeee");
    }
}
