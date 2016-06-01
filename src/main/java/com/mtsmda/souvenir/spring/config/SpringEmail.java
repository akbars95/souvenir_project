package com.mtsmda.souvenir.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.Properties;

/**
 * Created by dminzat on 5/31/2016.
 */
@Configuration
public class SpringEmail {

    @Bean(name = "mailSender")
    public JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("souvenir.buy.site");
        mailSender.setPassword("souvenir.buy.site9");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.mime.charset", "UTF-8");

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(((int) Math.pow(10, 6)) * 100);//100Mb
        commonsMultipartResolver.setMaxInMemorySize((int) Math.pow(10, 6));//1Mb
        commonsMultipartResolver.setMaxUploadSizePerFile((int) Math.pow(10, 6) * 5);
        return commonsMultipartResolver;
    }

    @Bean(name = "velocityEngine")
    public VelocityEngineFactoryBean getVelocityEngineFactoryBean() {
        VelocityEngineFactoryBean velocityEngineFactoryBean = new VelocityEngineFactoryBean();
        Properties velocityProperties = new Properties();
        velocityEngineFactoryBean.setVelocityProperties(velocityProperties);
        velocityProperties.put("resource.loader", "class");
        velocityProperties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return velocityEngineFactoryBean;
    }

}