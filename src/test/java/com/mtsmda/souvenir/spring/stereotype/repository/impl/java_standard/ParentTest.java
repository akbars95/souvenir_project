package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by dminzat on 4/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:text-mvc-dispatcher-servlet.xml")
@WebAppConfiguration
@Component
@Ignore
public class ParentTest {

    @PostConstruct
    public void init() {
        System.out.println("ParentTestinitPostConstruct@PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ParentTestdestroyPreDestroy@PreDestroy");
    }

}