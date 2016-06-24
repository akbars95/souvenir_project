package com.mtsmda.souvenir.spring.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by dminzat on 5/31/2016.
 */
//@Configuration
public class SpringDataSource {

    /*@Bean(name = "mySqlDataSource")
    public BasicDataSource getMySqlDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/souvenir");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        return basicDataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(){
        return new DataSourceTransactionManager(getMySqlDataSource());
    }*/

}