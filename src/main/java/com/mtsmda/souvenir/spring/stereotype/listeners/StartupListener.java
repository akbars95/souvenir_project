package com.mtsmda.souvenir.spring.stereotype.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * Created by dminzat on 8/2/2016.
 */
@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private javax.sql.DataSource dataSource;

    @Autowired
    @Qualifier("messageSource")
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(this.dataSource != null);
        System.out.println(reloadableResourceBundleMessageSource == null);
    }
}
